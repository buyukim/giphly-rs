package com.giphly.client.giphy.api;

import com.giphly.client.giphy.api.invoker.ApiClient;
import com.giphly.client.giphy.api.model.RandomInlineResponse200;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;

import java.util.Collections;
import java.util.List;

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-02-10T13:51:22.963150-06:00[America/Chicago]")
@Component("com.giphly.client.giphy.api.RandomidApi")
public class RandomidApi {
    private ApiClient apiClient;

    public RandomidApi() {
        this(new ApiClient());
    }

    @Autowired
    public RandomidApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get random hash ID
     * GIPHY Random ID Endpoint allows GIPHY to generate a unique ID you can assign to each new user in your app.To get the most out of Random ID, we recommend sending the random_id param with all compatible endpoints. This lets us adjust the API response to your users’ preferences and improve their GIF experience while maintaining their privacy.
     * <p><b>200</b> -
     * @return InlineResponse200
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RandomInlineResponse200 getRandomIdForUser() throws RestClientException {
        return getRandomIdForUserWithHttpInfo().getBody();
    }

    /**
     * Get random hash ID
     * GIPHY Random ID Endpoint allows GIPHY to generate a unique ID you can assign to each new user in your app.To get the most out of Random ID, we recommend sending the random_id param with all compatible endpoints. This lets us adjust the API response to your users’ preferences and improve their GIF experience while maintaining their privacy.
     * <p><b>200</b> -
     * @return ResponseEntity&lt;InlineResponse200&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<RandomInlineResponse200> getRandomIdForUserWithHttpInfo() throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/randomid", Collections.<String, Object>emptyMap());

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

        ParameterizedTypeReference<RandomInlineResponse200> returnType = new ParameterizedTypeReference<RandomInlineResponse200>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
