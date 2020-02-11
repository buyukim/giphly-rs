package com.giphly.service.impl;

import com.giphly.client.giphy.api.GifsApi;
import com.giphly.client.giphy.api.model.GiphyGifInlineResponse200;
import com.giphly.client.giphy.api.model.GiphyGifsInlineResponse200;
import com.giphly.domain.model.GiphyPaginatedResponse;
import com.giphly.domain.model.GiphyResponse;
import com.giphly.service.GiphyGifService;
import com.giphly.service.mapper.GiphyMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

@Service
public class GiphyGifServiceImpl implements GiphyGifService {

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
            GiphyGifsInlineResponse200 response = gifsApi.searchGifs(q,limit, offset, G_RATING, lang);
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
            return new ResponseEntity<>(mapper.toGiphyResponse(response), HttpStatus.OK);
        } catch (RestClientResponseException e) {
            // relay Giphy's response code as our own since it is basically a proxy
            return new ResponseEntity<>(HttpStatus.valueOf(e.getRawStatusCode()));
        }
    }
}
