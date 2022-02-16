package com.giphly.service;

import com.giphly.domain.Favorite;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Favorite}.
 */
public interface FavoriteService {
    /**
     * Save a favorite.
     *
     * @param favorite the entity to save.
     * @return the persisted entity.
     */
    Favorite save(Favorite favorite);

    /**
     * Partially updates a favorite.
     *
     * @param favorite the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Favorite> partialUpdate(Favorite favorite);

    /**
     * Get all the favorites.
     *
     * @return the list of entities.
     */
    List<Favorite> findAll();

    /**
     * Get the "id" favorite.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Favorite> findOne(Long id);

    /**
     * Delete the "id" favorite.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
