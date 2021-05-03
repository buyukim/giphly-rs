package com.giphly.web.rest;

import com.giphly.domain.Favorite;
import com.giphly.repository.FavoriteRepository;
import com.giphly.service.FavoriteService;
import com.giphly.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.giphly.domain.Favorite}.
 */
@RestController
@RequestMapping("/api")
public class FavoriteResource {

    private final Logger log = LoggerFactory.getLogger(FavoriteResource.class);

    private static final String ENTITY_NAME = "favorite";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FavoriteService favoriteService;

    private final FavoriteRepository favoriteRepository;

    public FavoriteResource(FavoriteService favoriteService, FavoriteRepository favoriteRepository) {
        this.favoriteService = favoriteService;
        this.favoriteRepository = favoriteRepository;
    }

    /**
     * {@code POST  /favorites} : Create a new favorite.
     *
     * @param favorite the favorite to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new favorite, or with status {@code 400 (Bad Request)} if the favorite has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/favorites")
    public ResponseEntity<Favorite> createFavorite(@RequestBody Favorite favorite) throws URISyntaxException {
        log.debug("REST request to save Favorite : {}", favorite);
        if (favorite.getId() != null) {
            throw new BadRequestAlertException("A new favorite cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Favorite result = favoriteService.save(favorite);
        return ResponseEntity
            .created(new URI("/api/favorites/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /favorites/:id} : Updates an existing favorite.
     *
     * @param id the id of the favorite to save.
     * @param favorite the favorite to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated favorite,
     * or with status {@code 400 (Bad Request)} if the favorite is not valid,
     * or with status {@code 500 (Internal Server Error)} if the favorite couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/favorites/{id}")
    public ResponseEntity<Favorite> updateFavorite(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Favorite favorite
    ) throws URISyntaxException {
        log.debug("REST request to update Favorite : {}, {}", id, favorite);
        if (favorite.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, favorite.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!favoriteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Favorite result = favoriteService.save(favorite);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, favorite.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /favorites/:id} : Partial updates given fields of an existing favorite, field will ignore if it is null
     *
     * @param id the id of the favorite to save.
     * @param favorite the favorite to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated favorite,
     * or with status {@code 400 (Bad Request)} if the favorite is not valid,
     * or with status {@code 404 (Not Found)} if the favorite is not found,
     * or with status {@code 500 (Internal Server Error)} if the favorite couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/favorites/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<Favorite> partialUpdateFavorite(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Favorite favorite
    ) throws URISyntaxException {
        log.debug("REST request to partial update Favorite partially : {}, {}", id, favorite);
        if (favorite.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, favorite.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!favoriteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Favorite> result = favoriteService.partialUpdate(favorite);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, favorite.getId().toString())
        );
    }

    /**
     * {@code GET  /favorites} : get all the favorites.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of favorites in body.
     */
    @GetMapping("/favorites")
    public List<Favorite> getAllFavorites() {
        log.debug("REST request to get all Favorites");
        return favoriteService.findAll();
    }

    /**
     * {@code GET  /favorites/:id} : get the "id" favorite.
     *
     * @param id the id of the favorite to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the favorite, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/favorites/{id}")
    public ResponseEntity<Favorite> getFavorite(@PathVariable Long id) {
        log.debug("REST request to get Favorite : {}", id);
        Optional<Favorite> favorite = favoriteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(favorite);
    }

    /**
     * {@code DELETE  /favorites/:id} : delete the "id" favorite.
     *
     * @param id the id of the favorite to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id) {
        log.debug("REST request to delete Favorite : {}", id);
        favoriteService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
