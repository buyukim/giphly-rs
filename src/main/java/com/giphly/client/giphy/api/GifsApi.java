package com.giphly.client.giphy.api;

import com.giphly.client.giphy.api.invoker.ApiClient;
import com.giphly.client.giphy.api.model.GiphyGifsInlineResponse200;
import com.giphly.client.giphy.api.model.GiphyGifInlineResponse200;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-02-10T13:51:22.963150-06:00[America/Chicago]")
@Component("com.giphly.client.giphy.api.GifsApi")
public class GifsApi {
    private ApiClient apiClient;

    public GifsApi() {
        this(new ApiClient());
    }

    @Autowired
    public GifsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get GIF by Id
     * Returns a GIF given that GIF&#39;s unique ID
     * <p><b>200</b> -
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param gifId Filters results by specified GIF ID. (required)
     * @return GiphyGifInlineResponse200
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GiphyGifInlineResponse200 getGifById(String gifId) throws RestClientException {
        return getGifByIdWithHttpInfo(gifId).getBody();
    }

    /**
     * Get GIF by Id
     * Returns a GIF given that GIF&#39;s unique ID
     * <p><b>200</b> -
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param gifId Filters results by specified GIF ID. (required)
     * @return ResponseEntity&lt;InlineResponse2002&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GiphyGifInlineResponse200> getGifByIdWithHttpInfo(String gifId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'gifId' is set
        if (gifId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gifId' when calling getGifById");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gifId", gifId);
        String path = apiClient.expandPath("/gifs/{gifId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        final String[] accepts = {
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "api_key" };

        ParameterizedTypeReference<GiphyGifInlineResponse200> returnType = new ParameterizedTypeReference<GiphyGifInlineResponse200>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get GIFs by ID
     * A multiget version of the get GIF by ID endpoint.
     * <p><b>200</b> -
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param ids Filters results by specified GIF IDs, separated by commas. (optional)
     * @return InlineResponse2001
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GiphyGifsInlineResponse200 getGifsById(String ids) throws RestClientException {
        return getGifsByIdWithHttpInfo(ids).getBody();
    }

    /**
     * Get GIFs by ID
     * A multiget version of the get GIF by ID endpoint.
     * <p><b>200</b> -
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param ids Filters results by specified GIF IDs, separated by commas. (optional)
     * @return ResponseEntity&lt;InlineResponse2001&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GiphyGifsInlineResponse200> getGifsByIdWithHttpInfo(String ids) throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/gifs", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "ids", ids));

        final String[] accepts = {
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "api_key" };

        ParameterizedTypeReference<GiphyGifsInlineResponse200> returnType = new ParameterizedTypeReference<GiphyGifsInlineResponse200>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Random GIF
     * Returns a random GIF, limited by tag. Excluding the tag parameter will return a random GIF from the GIPHY catalog.
     * <p><b>200</b> -
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param tag Filters results by specified tag. (optional)
     * @param rating Filters results by specified rating. (optional)
     * @return InlineResponse2002
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GiphyGifInlineResponse200 randomGif(String tag, String rating) throws RestClientException {
        return randomGifWithHttpInfo(tag, rating).getBody();
    }

    /**
     * Random GIF
     * Returns a random GIF, limited by tag. Excluding the tag parameter will return a random GIF from the GIPHY catalog.
     * <p><b>200</b> -
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param tag Filters results by specified tag. (optional)
     * @param rating Filters results by specified rating. (optional)
     * @return ResponseEntity&lt;InlineResponse2002&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GiphyGifInlineResponse200> randomGifWithHttpInfo(String tag, String rating) throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/gifs/random", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tag", tag));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "rating", rating));

        final String[] accepts = {
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "api_key" };

        ParameterizedTypeReference<GiphyGifInlineResponse200> returnType = new ParameterizedTypeReference<GiphyGifInlineResponse200>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Search GIFs
     * Search all GIPHY GIFs for a word or phrase. Punctuation will be stripped and ignored.  Use a plus or url encode for phrases. Example paul+rudd, ryan+gosling or american+psycho.
     * <p><b>200</b> - Search results
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param q Search query term or prhase. (required)
     * @param limit The maximum number of records to return. (optional, default to 25)
     * @param offset An optional results offset. (optional, default to 0)
     * @param rating Filters results by specified rating. (optional)
     * @param lang Specify default language for regional content; use a 2-letter ISO 639-1 language code. (optional)
     * @return InlineResponse2001
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GiphyGifsInlineResponse200 searchGifs(String q, Integer limit, Integer offset, String rating, String lang) throws RestClientException {
        return searchGifsWithHttpInfo(q, limit, offset, rating, lang).getBody();
    }

    /**
     * Search GIFs
     * Search all GIPHY GIFs for a word or phrase. Punctuation will be stripped and ignored.  Use a plus or url encode for phrases. Example paul+rudd, ryan+gosling or american+psycho.
     * <p><b>200</b> - Search results
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param q Search query term or prhase. (required)
     * @param limit The maximum number of records to return. (optional, default to 25)
     * @param offset An optional results offset. (optional, default to 0)
     * @param rating Filters results by specified rating. (optional)
     * @param lang Specify default language for regional content; use a 2-letter ISO 639-1 language code. (optional)
     * @return ResponseEntity&lt;InlineResponse2001&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GiphyGifsInlineResponse200> searchGifsWithHttpInfo(String q, Integer limit, Integer offset, String rating, String lang) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'q' is set
        if (q == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'q' when calling searchGifs");
        }

        String path = apiClient.expandPath("/gifs/search", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "q", q));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "rating", rating));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "lang", lang));

        final String[] accepts = {
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "api_key" };

        ParameterizedTypeReference<GiphyGifsInlineResponse200> returnType = new ParameterizedTypeReference<GiphyGifsInlineResponse200>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Translate phrase to GIF
     * The translate API draws on search, but uses the GIPHY &#x60;special sauce&#x60; to handle translating from one vocabulary to another. In this case, words and phrases to GIF
     * <p><b>200</b> -
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param s Search term. (required)
     * @return InlineResponse2002
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GiphyGifInlineResponse200 translateGif(String s) throws RestClientException {
        return translateGifWithHttpInfo(s).getBody();
    }

    /**
     * Translate phrase to GIF
     * The translate API draws on search, but uses the GIPHY &#x60;special sauce&#x60; to handle translating from one vocabulary to another. In this case, words and phrases to GIF
     * <p><b>200</b> -
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param s Search term. (required)
     * @return ResponseEntity&lt;InlineResponse2002&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GiphyGifInlineResponse200> translateGifWithHttpInfo(String s) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 's' is set
        if (s == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 's' when calling translateGif");
        }

        String path = apiClient.expandPath("/gifs/translate", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "s", s));

        final String[] accepts = {
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "api_key" };

        ParameterizedTypeReference<GiphyGifInlineResponse200> returnType = new ParameterizedTypeReference<GiphyGifInlineResponse200>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Trending GIFs
     * Fetch GIFs currently trending online. Hand curated by the GIPHY editorial team.  The data returned mirrors the GIFs showcased on the GIPHY homepage. Returns 25 results by default.
     * <p><b>200</b> -
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param limit The maximum number of records to return. (optional, default to 25)
     * @param offset An optional results offset. (optional, default to 0)
     * @param rating Filters results by specified rating. (optional)
     * @return InlineResponse2001
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GiphyGifsInlineResponse200 trendingGifs(Integer limit, Integer offset, String rating) throws RestClientException {
        return trendingGifsWithHttpInfo(limit, offset, rating).getBody();
    }

    /**
     * Trending GIFs
     * Fetch GIFs currently trending online. Hand curated by the GIPHY editorial team.  The data returned mirrors the GIFs showcased on the GIPHY homepage. Returns 25 results by default.
     * <p><b>200</b> -
     * <p><b>400</b> - Your request was formatted incorrectly or missing required parameters.
     * <p><b>403</b> - You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key.
     * <p><b>404</b> - The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist.
     * <p><b>429</b> - Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.
     * @param limit The maximum number of records to return. (optional, default to 25)
     * @param offset An optional results offset. (optional, default to 0)
     * @param rating Filters results by specified rating. (optional)
     * @return ResponseEntity&lt;InlineResponse2001&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GiphyGifsInlineResponse200> trendingGifsWithHttpInfo(Integer limit, Integer offset, String rating) throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/gifs/trending", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "rating", rating));

        final String[] accepts = {
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "api_key" };

        ParameterizedTypeReference<GiphyGifsInlineResponse200> returnType = new ParameterizedTypeReference<GiphyGifsInlineResponse200>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
