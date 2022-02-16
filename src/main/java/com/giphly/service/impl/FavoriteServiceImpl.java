package com.giphly.service.impl;

import com.giphly.service.FavoriteService;
import com.giphly.domain.Favorite;
import com.giphly.repository.FavoriteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Favorite}.
 */
@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {

    private final Logger log = LoggerFactory.getLogger(FavoriteServiceImpl.class);

    private final FavoriteRepository favoriteRepository;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    /**
     * Save a favorite.
     *
     * @param favorite the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Favorite save(Favorite favorite) {
        log.debug("Request to save Favorite : {}", favorite);
        return favoriteRepository.save(favorite);
    }

    /**
     * Get all the favorites.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Favorite> findAll() {
        log.debug("Request to get all Favorites");
        return favoriteRepository.findAll();
    }


    /**
     * Get all the favorites for the currently logged in user
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Favorite> findAllForLoggedInUser() {
        log.debug("Request to get all Favorites");
        return favoriteRepository.findByUserIsCurrentUser();
    }

    /**
     * Get one favorite by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Favorite> findOne(Long id) {
        log.debug("Request to get Favorite : {}", id);
        return favoriteRepository.findById(id);
    }

    /**
     * Delete the favorite by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Favorite : {}", id);
        favoriteRepository.deleteById(id);
    }
}
