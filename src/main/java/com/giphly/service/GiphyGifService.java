package com.giphly.service;

import com.giphly.domain.model.GiphyResponse;
import org.springframework.http.ResponseEntity;

public interface GiphyGifService {

    ResponseEntity<GiphyResponse> getGifById(String giphyGifId);
}
