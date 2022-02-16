package com.giphly.web.rest;

import com.giphly.domain.Gif;
import com.giphly.service.GifService;
import com.giphly.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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

    public GifResource(GifService gifService) {
        this.gifService = gifService;
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
        return ResponseEntity.created(new URI("/api/gifs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /gifs} : Updates an existing gif.
     *
     * @param gif the gif to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated gif,
     * or with status {@code 400 (Bad Request)} if the gif is not valid,
     * or with status {@code 500 (Internal Server Error)} if the gif couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/gifs")
    public ResponseEntity<Gif> updateGif(@Valid @RequestBody Gif gif) throws URISyntaxException {
        log.debug("REST request to update Gif : {}", gif);
        if (gif.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Gif result = gifService.save(gif);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, gif.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /gifs} : get all the gifs in **Giphly**
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
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
