package com.giphly.service;

import com.giphly.domain.model.GiphyPaginatedResponse;
import com.giphly.domain.model.GiphyResponse;
import org.springframework.http.ResponseEntity;

public interface GiphyGifService {

    /**
     *
     * @param giphyGifId Giphy GIF IF (alphanumeric)
     * @return A single GIF that corresponds to the input ID
     */
    ResponseEntity<GiphyResponse> getGifById(String giphyGifId);

    /**
     *
     * @param limit max number of results
     * @param offset starting offset for pagination
     * @return Paginated response of G-rated tending GIFs
     */
    ResponseEntity<GiphyPaginatedResponse> trendingGifs(Integer limit, Integer offset);

    /**
     *
     * @param q the query search string (e.g., "dogs")
     * @param limit max results to be returned
     * @param offset starting offset for pagination
     * @param lang Specify default language for regional content; use a 2-letter ISO 639-1 language code
     * @return Paginated response of G-rated search results
     */
    ResponseEntity<GiphyPaginatedResponse> searchGifs(String q, Integer limit, Integer offset, String lang);

    /**
     * Get a list of GIFs by the Giphy ID
     * @param ids list of Giphy IDs (alphanumeric)
     * @return paginated response
     */
    ResponseEntity<GiphyPaginatedResponse> getGifsById(String ids);
}
