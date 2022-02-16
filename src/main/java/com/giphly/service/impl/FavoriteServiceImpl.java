package com.giphly.service.impl;

import com.giphly.domain.Favorite;
import com.giphly.repository.FavoriteRepository;
import com.giphly.service.FavoriteService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Favorite save(Favorite favorite) {
        log.debug("Request to save Favorite : {}", favorite);
        return favoriteRepository.save(favorite);
    }

    @Override
    public Optional<Favorite> partialUpdate(Favorite favorite) {
        log.debug("Request to partially update Favorite : {}", favorite);

        return favoriteRepository
            .findById(favorite.getId())
            .map(existingFavorite -> {
                return existingFavorite;
            })
            .map(favoriteRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Favorite> findAll() {
        log.debug("Request to get all Favorites");
        return favoriteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Favorite> findOne(Long id) {
        log.debug("Request to get Favorite : {}", id);
        return favoriteRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Favorite : {}", id);
        favoriteRepository.deleteById(id);
    }
}
