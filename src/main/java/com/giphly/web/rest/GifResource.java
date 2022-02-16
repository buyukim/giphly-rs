package com.giphly.web.rest;

import com.giphly.domain.Gif;
import com.giphly.repository.GifRepository;
import com.giphly.service.GifService;
import com.giphly.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.giphly.domain.Gif}.
 */
@RestController
@RequestMapping("/api")
public class GifResource {

    private final Logger log = LoggerFactory.getLogger(GifResource.class);

    private static final String ENTITY_NAME = "gif";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GifService gifService;

    private final GifRepository gifRepository;

    public GifResource(GifService gifService, GifRepository gifRepository) {
        this.gifService = gifService;
        this.gifRepository = gifRepository;
    }

    /**
     * {@code POST  /gifs} : Create a new gif.
     *
     * @param gif the gif to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new gif, or with status {@code 400 (Bad Request)} if the gif has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/gifs")
    public ResponseEntity<Gif> createGif(@Valid @RequestBody Gif gif) throws URISyntaxException {
        log.debug("REST request to save Gif : {}", gif);
        if (gif.getId() != null) {
            throw new BadRequestAlertException("A new gif cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Gif result = gifService.save(gif);
        return ResponseEntity
            .created(new URI("/api/gifs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /gifs/:id} : Updates an existing gif.
     *
     * @param id the id of the gif to save.
     * @param gif the gif to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated gif,
     * or with status {@code 400 (Bad Request)} if the gif is not valid,
     * or with status {@code 500 (Internal Server Error)} if the gif couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/gifs/{id}")
    public ResponseEntity<Gif> updateGif(@PathVariable(value = "id", required = false) final Long id, @Valid @RequestBody Gif gif)
        throws URISyntaxException {
        log.debug("REST request to update Gif : {}, {}", id, gif);
        if (gif.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, gif.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!gifRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Gif result = gifService.save(gif);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, gif.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /gifs/:id} : Partial updates given fields of an existing gif, field will ignore if it is null
     *
     * @param id the id of the gif to save.
     * @param gif the gif to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated gif,
     * or with status {@code 400 (Bad Request)} if the gif is not valid,
     * or with status {@code 404 (Not Found)} if the gif is not found,
     * or with status {@code 500 (Internal Server Error)} if the gif couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/gifs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<Gif> partialUpdateGif(@PathVariable(value = "id", required = false) final Long id, @NotNull @RequestBody Gif gif)
        throws URISyntaxException {
        log.debug("REST request to partial update Gif partially : {}, {}", id, gif);
        if (gif.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, gif.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!gifRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Gif> result = gifService.partialUpdate(gif);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, gif.getId().toString())
        );
    }

    /**
     * {@code GET  /gifs} : get all the gifs.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of gifs in body.
     */
    @GetMapping("/gifs")
    public List<Gif> getAllGifs() {
        log.debug("REST request to get all GIPHLY gifs");
        return gifService.findAll();
    }

    /**
     * {@code GET  /gifs/:id} : get the "id" gif.
     *
     * @param id the id of the gif to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the gif, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/gifs/{id}")
    public ResponseEntity<Gif> getGif(@PathVariable Long id) {
        log.debug("REST request to get Gif : {}", id);
        Optional<Gif> gif = gifService.findOne(id);
        return ResponseUtil.wrapOrNotFound(gif);
    }

    /**
     * {@code DELETE  /gifs/:id} : delete the "id" gif.
     *
     * @param id the id of the gif to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/gifs/{id}")
    public ResponseEntity<Void> deleteGif(@PathVariable Long id) {
        log.debug("REST request to delete Gif : {}", id);
        gifService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
