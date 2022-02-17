package com.giphly.web.rest;

import com.giphly.domain.model.GiphyPaginatedResponse;
import com.giphly.domain.model.GiphyResponse;
import com.giphly.service.GiphyGifService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @Operation(
        tags = "getGifById",
        description = "Get GIF by Id. Returns a GIF given that GIF's unique ID",
        responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = GiphyResponse.class))),
            @ApiResponse(responseCode = "400", description = "Your request was formatted incorrectly or missing required parameters."),
            @ApiResponse(
                responseCode = "403",
                description = "You weren't authorized to make your request; most likely this indicates an issue with your API Key."
            ),
            @ApiResponse(
                responseCode = "404",
                description = "The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist."
            ),
            @ApiResponse(
                responseCode = "429",
                description = "Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits. "
            ),
        }
    )
    @RequestMapping(value = "/giphy-gifs/{giphyGifId}", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<GiphyResponse> getGifById(
        @Parameter(description = "Filters results by specified Giphy GIF ID (alphanumeric)", required = true) @PathVariable(
            "giphyGifId"
        ) String giphyGifId
    ) {
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
    @Operation(
        tags = "getGifsById",
        description = "Get GIFs by ID. A multi-get version of the get GIF by ID endpoint. ",
        responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = GiphyPaginatedResponse.class))),
            @ApiResponse(responseCode = "400", description = "Your request was formatted incorrectly or missing required parameters."),
            @ApiResponse(
                responseCode = "403",
                description = "You weren't authorized to make your request; most likely this indicates an issue with your API Key."
            ),
            @ApiResponse(
                responseCode = "404",
                description = "The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist."
            ),
            @ApiResponse(
                responseCode = "429",
                description = "Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits. "
            ),
        }
    )
    @RequestMapping(value = "/giphy-gifs", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<GiphyPaginatedResponse> getGifsById(
        @Parameter(description = "Filters results by specified Giphy GIF IDs (alphanumeric), separated by commas.") @Valid @RequestParam(
            value = "ids",
            required = false
        ) String ids
    ) {
        return giphyGifService.getGifsById(ids);
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
    @Operation(
        description = "Search GIFs. Search all GIPHY GIFs for a word or phrase. Punctuation will be stripped and ignored.  Use a plus or url encode for phrases. Example paul+rudd, ryan+gosling or american+psycho. Results are G-rated. ",
        tags = "searchGifs",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "search results",
                content = @Content(schema = @Schema(implementation = GiphyPaginatedResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Your request was formatted incorrectly or missing required parameters."),
            @ApiResponse(
                responseCode = "403",
                description = "You weren't authorized to make your request; most likely this indicates an issue with your API Key."
            ),
            @ApiResponse(
                responseCode = "404",
                description = "The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist."
            ),
            @ApiResponse(
                responseCode = "429",
                description = "Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits. "
            ),
        }
    )
    @RequestMapping(value = "/giphy-gifs/search", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<GiphyPaginatedResponse> searchGifs(
        @NotNull @Parameter(description = "Search query term or phrase.", required = true) @Valid @RequestParam(
            value = "q",
            required = true
        ) String q,
        @Parameter(
            description = "The maximum number of records to return.",
            schema = @Schema(defaultValue = "25", type = "integer")
        ) @Valid @RequestParam(value = "limit", required = false, defaultValue = "25") Integer limit,
        @Parameter(
            description = "An optional results offset.",
            schema = @Schema(defaultValue = "0", type = "integer")
        ) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
        @Parameter(
            description = "Specify default language for regional content; use a 2-letter ISO 639-1 language code."
        ) @Valid @RequestParam(value = "lang", required = false) String lang
    ) {
        return giphyGifService.searchGifs(q, limit, offset, lang);
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
    @Operation(
        description = "Trending GIFs.Fetch GIFs currently trending online. Hand curated by the GIPHY editorial team (and G rated!).  The data returned mirrors the GIFs showcased on the GIPHY homepage. Returns 25 results by default.",
        tags = "trendingGifs",
        responses = {
            @ApiResponse(content = @Content(schema = @Schema(implementation = GiphyPaginatedResponse.class))),
            @ApiResponse(responseCode = "400", description = "Your request was formatted incorrectly or missing required parameters."),
            @ApiResponse(
                responseCode = "403",
                description = "You weren't authorized to make your request; most likely this indicates an issue with your API Key."
            ),
            @ApiResponse(
                responseCode = "404",
                description = "The particular GIF you are requesting was not found. This occurs, for example, if you request a GIF by an id that does not exist."
            ),
            @ApiResponse(
                responseCode = "429",
                description = "Your API Key is making too many requests. Read about [requesting a Production Key](https://developers.giphy.com/docs/#access) to upgrade your API Key rate limits. "
            ),
        }
    )
    @RequestMapping(value = "/giphy-gifs/trending", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<GiphyPaginatedResponse> trendingGifs(
        @Parameter(
            description = "The maximum number of records to return.",
            schema = @Schema(defaultValue = "25", type = "integer")
        ) @Valid @RequestParam(value = "limit", required = false, defaultValue = "25") Integer limit,
        @Parameter(
            description = "An optional results offset.",
            schema = @Schema(defaultValue = "0", type = "integer")
        ) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset
    ) {
        return giphyGifService.trendingGifs(limit, offset);
    }
}
