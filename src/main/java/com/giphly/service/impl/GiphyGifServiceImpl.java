package com.giphly.service.impl;

import com.giphly.client.giphy.api.GifsApi;
import com.giphly.client.giphy.api.model.Gif;
import com.giphly.client.giphy.api.model.GiphyGifInlineResponse200;
import com.giphly.client.giphy.api.model.GiphyGifsInlineResponse200;
import com.giphly.domain.model.GiphyPaginatedResponse;
import com.giphly.domain.model.GiphyResponse;
import com.giphly.service.GiphyGifService;
import com.giphly.service.mapper.GiphyMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

@Service
public class GiphyGifServiceImpl implements GiphyGifService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public static final String CPU_CACHE = "availableCpuCache";

    private static final String G_RATING = "g";
    private GifsApi gifsApi;

    private GiphyMapper mapper;

    public GiphyGifServiceImpl(GifsApi gifsApi, GiphyMapper mapper,
                               @Value(value = "#{environment.GIPHY_API_KEY}") String giphyApiKey) {
        this.gifsApi = gifsApi;
        this.mapper = mapper;
        gifsApi.getApiClient().setApiKey(giphyApiKey);
        gifsApi.getApiClient().addDefaultHeader("Authorization", giphyApiKey);
    }

    @Override
    public ResponseEntity<GiphyResponse> getGifById(String giphyGifId) {
        try {
            GiphyGifInlineResponse200 response = gifsApi.getGifById(giphyGifId);
            if (response != null && isGifNotFamilyFriendly(response.getData())) {
                log.error("Rating for GIF is not G-rated, throwing 400 error");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(mapper.toGiphyResponse(response), HttpStatus.OK);
        } catch (RestClientResponseException e) {
            // relay Giphy's response code as our own since it is basically a proxy
            return new ResponseEntity<>(HttpStatus.valueOf(e.getRawStatusCode()));
        }
    }

    @Override
    public ResponseEntity<GiphyPaginatedResponse> trendingGifs(Integer limit, Integer offset) {
        try {
            GiphyGifsInlineResponse200 response = gifsApi.trendingGifs(limit, offset, G_RATING);
            return new ResponseEntity<>(mapper.toGiphyResponse(response), HttpStatus.OK);
        } catch (RestClientResponseException e) {
            // relay Giphy's response code as our own since it is basically a proxy
            return new ResponseEntity<>(HttpStatus.valueOf(e.getRawStatusCode()));
        }
    }

    @Override
    public ResponseEntity<GiphyPaginatedResponse> searchGifs(String q, Integer limit, Integer offset, String lang) {

        try {
            GiphyGifsInlineResponse200 response = gifsApi.searchGifs(q,limit, offset, G_RATING, normalizeLang(lang));
            return new ResponseEntity<>(mapper.toGiphyResponse(response), HttpStatus.OK);
        } catch (RestClientResponseException e) {
            // relay Giphy's response code as our own since it is basically a proxy
            return new ResponseEntity<>(HttpStatus.valueOf(e.getRawStatusCode()));
        }
    }

    @Override
    public ResponseEntity<GiphyPaginatedResponse> getGifsById(String ids) {
        try {
            GiphyGifsInlineResponse200 response = gifsApi.getGifsById(ids);
            if (response != null && isGifListNotFamilyFriendly(response.getData())) {
                log.error("Rating for GIFs is not G-rated, throwing 400 error");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(mapper.toGiphyResponse(response), HttpStatus.OK);
        } catch (RestClientResponseException e) {
            // relay Giphy's response code as our own since it is basically a proxy
            return new ResponseEntity<>(HttpStatus.valueOf(e.getRawStatusCode()));
        }
    }

    public boolean isGifListNotFamilyFriendly(List<Gif> gifs) {
        if (gifs == null || gifs.size() == 0) {
            return false;
        }
        if (gifs.size() <= 10 ||
            Runtime.getRuntime().availableProcessors() <= 1) {
            return gifs.stream().anyMatch(this::isGifNotFamilyFriendly);
        }
        // when doing parallel, best to use separate thread pools instead of
        // the default global one to avoid blocking/slowness from outside tasks
        ForkJoinPool customThreadPool = new ForkJoinPool();
        try {
            return customThreadPool.submit(
                () -> gifs.parallelStream().anyMatch(this::isGifNotFamilyFriendly)).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isGifNotFamilyFriendly(Gif gif) {
        if (gif == null) {
            return false;
        }
        boolean failed = StringUtils.isNotBlank(gif.getRating()) &&
            !G_RATING.equalsIgnoreCase(gif.getRating());
        if (failed) {
            log.error("Found improper rating of: " + gif.getRating() + ", failing...");
        }
        return failed;
    }

    /**
     * Tries to normalize the BCP47 locales (Angular i18n) with the format required by Giphy (2-letter ISO 639-1)
     * @param lang can be either BCP47 or
     * @return normalized value; null if we could not figure out the language or if null/empty was passed in
     */
    public String normalizeLang(String lang) {
        String trimmed = StringUtils.trimToNull(lang);
        if (trimmed == null) {
            return null;
        }
        if (trimmed.length() < 2) {
            return null;
        }
        if (trimmed.length() == 2) {
            return trimmed.toLowerCase();
        }
        String[] parts = StringUtils.split(trimmed,'-');
        if (parts != null && parts[0].length() == 2) {
            return parts[0].toLowerCase();
        }
        return null;
    }
}
