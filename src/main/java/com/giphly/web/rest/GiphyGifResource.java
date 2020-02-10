package com.giphly.web.rest;

import com.giphly.domain.model.GiphyPaginatedResponse;
import com.giphly.domain.model.GiphyResponse;
import com.giphly.service.GiphyGifService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/api")
public class GiphyGifResource {

    private GiphyGifService giphyGifService;

    public GiphyGifResource(GiphyGifService giphyGifService) {
        this.giphyGifService = giphyGifService;
    }

    /**
     * GET /giphy-gifs/{giphyGifId} : Get GIF by Id
     * Returns a GIF given that GIF&#39;s unique ID
     *
     * @param giphyGifId Filters results by specified Giphy GIF ID (alphanumeric) (required)
     * @return  (status code 200)
     *         or Your request was formatted incorrectly or missing required parameters. (status code 400)
     *         or You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key. (status code 403)
     *         or The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist. (status code 404)
     *         or Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.  (status code 429)
     */
    @ApiOperation(value = "Get GIF by Id", nickname = "getGifById", notes = "Returns a GIF given that GIF's unique ID ", response = GiphyResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "", response = GiphyResponse.class),
        @ApiResponse(code = 400, message = "Your request was formatted incorrectly or missing required parameters."),
        @ApiResponse(code = 403, message = "You weren't authorized to make your request; most likely this indicates an issue with your API Key."),
        @ApiResponse(code = 404, message = "The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist."),
        @ApiResponse(code = 429, message = "Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits. ") })
    @RequestMapping(value = "/giphy-gifs/{giphyGifId}",
        produces = { "application/json" },
        method = RequestMethod.GET)
    public ResponseEntity<GiphyResponse> getGifById(@ApiParam(value = "Filters results by specified Giphy GIF ID (alphanumeric)",required=true) @PathVariable("giphyGifId") String giphyGifId) {
        return giphyGifService.getGifById(giphyGifId);
    }


    /**
     * GET /giphy-gifs : Get GIFs by ID
     * A multiget version of the get GIF by ID endpoint.
     *
     * @param ids Filters results by specified Giphy GIF IDs (alphanumeric), separated by commas. (optional)
     * @return  (status code 200)
     *         or Your request was formatted incorrectly or missing required parameters. (status code 400)
     *         or You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key. (status code 403)
     *         or The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist. (status code 404)
     *         or Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.  (status code 429)
     */
    @ApiOperation(value = "Get GIFs by ID", nickname = "getGifsById", notes = "A multiget version of the get GIF by ID endpoint. ", response = GiphyPaginatedResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "", response = GiphyPaginatedResponse.class),
        @ApiResponse(code = 400, message = "Your request was formatted incorrectly or missing required parameters."),
        @ApiResponse(code = 403, message = "You weren't authorized to make your request; most likely this indicates an issue with your API Key."),
        @ApiResponse(code = 404, message = "The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist."),
        @ApiResponse(code = 429, message = "Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits. ") })
    @RequestMapping(value = "/giphy-gifs",
        produces = { "application/json" },
        method = RequestMethod.GET)
    public ResponseEntity<GiphyPaginatedResponse> getGifsById(@ApiParam(value = "Filters results by specified Giphy GIF IDs (alphanumeric), separated by commas.") @Valid @RequestParam(value = "ids", required = false) String ids) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /giphy-gifs/search : Search GIFs
     * Search all GIPHY GIFs for a word or phrase. Punctuation will be stripped and ignored.  Use a plus or url encode for phrases. Example paul+rudd, ryan+gosling or american+psycho. Results are G-rated.
     *
     * @param q Search query term or prhase. (required)
     * @param limit The maximum number of records to return. (optional, default to 25)
     * @param offset An optional results offset. (optional, default to 0)
     * @param lang Specify default language for regional content; use a 2-letter ISO 639-1 language code. (optional)
     * @return Search results (status code 200)
     *         or Your request was formatted incorrectly or missing required parameters. (status code 400)
     *         or You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key. (status code 403)
     *         or The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist. (status code 404)
     *         or Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.  (status code 429)
     */
    @ApiOperation(value = "Search GIFs", nickname = "searchGifs", notes = "Search all GIPHY GIFs for a word or phrase. Punctuation will be stripped and ignored.  Use a plus or url encode for phrases. Example paul+rudd, ryan+gosling or american+psycho. Results are G-rated. ", response = GiphyPaginatedResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Search results", response = GiphyPaginatedResponse.class),
        @ApiResponse(code = 400, message = "Your request was formatted incorrectly or missing required parameters."),
        @ApiResponse(code = 403, message = "You weren't authorized to make your request; most likely this indicates an issue with your API Key."),
        @ApiResponse(code = 404, message = "The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist."),
        @ApiResponse(code = 429, message = "Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits. ") })
    @RequestMapping(value = "/giphy-gifs/search",
        produces = { "application/json" },
        method = RequestMethod.GET)
    public ResponseEntity<GiphyPaginatedResponse> searchGifs(@NotNull @ApiParam(value = "Search query term or prhase.", required = true) @Valid @RequestParam(value = "q", required = true) String q, @ApiParam(value = "The maximum number of records to return.", defaultValue = "25") @Valid @RequestParam(value = "limit", required = false, defaultValue="25") Integer limit, @ApiParam(value = "An optional results offset.", defaultValue = "0") @Valid @RequestParam(value = "offset", required = false, defaultValue="0") Integer offset, @ApiParam(value = "Specify default language for regional content; use a 2-letter ISO 639-1 language code.") @Valid @RequestParam(value = "lang", required = false) String lang) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /giphy-gifs/trending : Trending GIFs
     * Fetch GIFs currently trending online. Hand curated by the GIPHY editorial team (and G rated!).  The data returned mirrors the GIFs showcased on the GIPHY homepage. Returns 25 results by default.
     *
     * @param limit The maximum number of records to return. (optional, default to 25)
     * @param offset An optional results offset. (optional, default to 0)
     * @return  (status code 200)
     *         or Your request was formatted incorrectly or missing required parameters. (status code 400)
     *         or You weren&#39;t authorized to make your request; most likely this indicates an issue with your API Key. (status code 403)
     *         or The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist. (status code 404)
     *         or Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits.  (status code 429)
     */
    @ApiOperation(value = "Trending GIFs", nickname = "trendingGifs", notes = "Fetch GIFs currently trending online. Hand curated by the GIPHY editorial team (and G rated!).  The data returned mirrors the GIFs showcased on the GIPHY homepage. Returns 25 results by default. ", response = GiphyPaginatedResponse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "", response = GiphyPaginatedResponse.class),
        @ApiResponse(code = 400, message = "Your request was formatted incorrectly or missing required parameters."),
        @ApiResponse(code = 403, message = "You weren't authorized to make your request; most likely this indicates an issue with your API Key."),
        @ApiResponse(code = 404, message = "The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist."),
        @ApiResponse(code = 429, message = "Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits. ") })
    @RequestMapping(value = "/giphy-gifs/trending",
        produces = { "application/json" },
        method = RequestMethod.GET)
    public ResponseEntity<GiphyPaginatedResponse> trendingGifs(@ApiParam(value = "The maximum number of records to return.", defaultValue = "25") @Valid @RequestParam(value = "limit", required = false, defaultValue="25") Integer limit, @ApiParam(value = "An optional results offset.", defaultValue = "0") @Valid @RequestParam(value = "offset", required = false, defaultValue="0") Integer offset) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
