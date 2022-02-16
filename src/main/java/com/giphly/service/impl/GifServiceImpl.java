package com.giphly.service.impl;

import com.giphly.service.GifService;
import com.giphly.domain.Gif;
import com.giphly.repository.GifRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Gif}.
 */
@Service
@Transactional
public class GifServiceImpl implements GifService {

    private final Logger log = LoggerFactory.getLogger(GifServiceImpl.class);

    private final GifRepository gifRepository;

    public GifServiceImpl(GifRepository gifRepository) {
        this.gifRepository = gifRepository;
    }

    @Override
    public Gif save(Gif gif) {
        log.debug("Request to save Gif : {}", gif);
        return gifRepository.save(gif);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gif> findAll() {
        log.debug("Request to get all Gifs");
        return gifRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Gif> findOne(Long id) {
        log.debug("Request to get Gif : {}", id);
        return gifRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Gif : {}", id);
        gifRepository.deleteById(id);
    }
}
