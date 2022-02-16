package com.giphly.service;

import com.giphly.domain.Gif;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Gif}.
 */
public interface GifService {

    /**
     * Save a gif.
     *
     * @param gif the entity to save.
     * @return the persisted entity.
     */
    Gif save(Gif gif);

    /**
     * Get all the gifs.
     *
     * @return the list of entities.
     */
    List<Gif> findAll();


    /**
     * Get the "id" gif.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Gif> findOne(Long id);

    /**
     * Delete the "id" gif.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
