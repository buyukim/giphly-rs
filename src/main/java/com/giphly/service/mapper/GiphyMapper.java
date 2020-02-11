package com.giphly.service.mapper;

import com.giphly.client.giphy.api.model.GiphyGifInlineResponse200;
import com.giphly.client.giphy.api.model.GiphyGifsInlineResponse200;
import com.giphly.domain.model.GiphyPaginatedResponse;
import com.giphly.domain.model.GiphyResponse;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface GiphyMapper {

    GiphyResponse toGiphyResponse(GiphyGifInlineResponse200 input);

    GiphyPaginatedResponse toGiphyResponse(GiphyGifsInlineResponse200 input);

}
