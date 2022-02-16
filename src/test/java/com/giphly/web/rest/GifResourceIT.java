package com.giphly.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.giphly.IntegrationTest;
import com.giphly.domain.Gif;
import com.giphly.repository.GifRepository;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link GifResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class GifResourceIT {

    private static final String DEFAULT_GIPHY_GIF_ID = "AAAAAAAAAA";
    private static final String UPDATED_GIPHY_GIF_ID = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/gifs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private GifRepository gifRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restGifMockMvc;

    private Gif gif;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Gif createEntity(EntityManager em) {
        Gif gif = new Gif().giphyGifId(DEFAULT_GIPHY_GIF_ID);
        return gif;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Gif createUpdatedEntity(EntityManager em) {
        Gif gif = new Gif().giphyGifId(UPDATED_GIPHY_GIF_ID);
        return gif;
    }

    @BeforeEach
    public void initTest() {
        gif = createEntity(em);
    }

    @Test
    @Transactional
    void createGif() throws Exception {
        int databaseSizeBeforeCreate = gifRepository.findAll().size();
        // Create the Gif
        restGifMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(gif)))
            .andExpect(status().isCreated());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeCreate + 1);
        Gif testGif = gifList.get(gifList.size() - 1);
        assertThat(testGif.getGiphyGifId()).isEqualTo(DEFAULT_GIPHY_GIF_ID);
    }

    @Test
    @Transactional
    void createGifWithExistingId() throws Exception {
        // Create the Gif with an existing ID
        gif.setId(1L);

        int databaseSizeBeforeCreate = gifRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restGifMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(gif)))
            .andExpect(status().isBadRequest());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkGiphyGifIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = gifRepository.findAll().size();
        // set the field null
        gif.setGiphyGifId(null);

        // Create the Gif, which fails.

        restGifMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(gif)))
            .andExpect(status().isBadRequest());

        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllGifs() throws Exception {
        // Initialize the database
        gifRepository.saveAndFlush(gif);

        // Get all the gifList
        restGifMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(gif.getId().intValue())))
            .andExpect(jsonPath("$.[*].giphyGifId").value(hasItem(DEFAULT_GIPHY_GIF_ID)));
    }

    @Test
    @Transactional
    void getGif() throws Exception {
        // Initialize the database
        gifRepository.saveAndFlush(gif);

        // Get the gif
        restGifMockMvc
            .perform(get(ENTITY_API_URL_ID, gif.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(gif.getId().intValue()))
            .andExpect(jsonPath("$.giphyGifId").value(DEFAULT_GIPHY_GIF_ID));
    }

    @Test
    @Transactional
    void getNonExistingGif() throws Exception {
        // Get the gif
        restGifMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewGif() throws Exception {
        // Initialize the database
        gifRepository.saveAndFlush(gif);

        int databaseSizeBeforeUpdate = gifRepository.findAll().size();

        // Update the gif
        Gif updatedGif = gifRepository.findById(gif.getId()).get();
        // Disconnect from session so that the updates on updatedGif are not directly saved in db
        em.detach(updatedGif);
        updatedGif.giphyGifId(UPDATED_GIPHY_GIF_ID);

        restGifMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedGif.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedGif))
            )
            .andExpect(status().isOk());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
        Gif testGif = gifList.get(gifList.size() - 1);
        assertThat(testGif.getGiphyGifId()).isEqualTo(UPDATED_GIPHY_GIF_ID);
    }

    @Test
    @Transactional
    void putNonExistingGif() throws Exception {
        int databaseSizeBeforeUpdate = gifRepository.findAll().size();
        gif.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restGifMockMvc
            .perform(
                put(ENTITY_API_URL_ID, gif.getId()).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(gif))
            )
            .andExpect(status().isBadRequest());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchGif() throws Exception {
        int databaseSizeBeforeUpdate = gifRepository.findAll().size();
        gif.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restGifMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(gif))
            )
            .andExpect(status().isBadRequest());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamGif() throws Exception {
        int databaseSizeBeforeUpdate = gifRepository.findAll().size();
        gif.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restGifMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(gif)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateGifWithPatch() throws Exception {
        // Initialize the database
        gifRepository.saveAndFlush(gif);

        int databaseSizeBeforeUpdate = gifRepository.findAll().size();

        // Update the gif using partial update
        Gif partialUpdatedGif = new Gif();
        partialUpdatedGif.setId(gif.getId());

        partialUpdatedGif.giphyGifId(UPDATED_GIPHY_GIF_ID);

        restGifMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedGif.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedGif))
            )
            .andExpect(status().isOk());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
        Gif testGif = gifList.get(gifList.size() - 1);
        assertThat(testGif.getGiphyGifId()).isEqualTo(UPDATED_GIPHY_GIF_ID);
    }

    @Test
    @Transactional
    void fullUpdateGifWithPatch() throws Exception {
        // Initialize the database
        gifRepository.saveAndFlush(gif);

        int databaseSizeBeforeUpdate = gifRepository.findAll().size();

        // Update the gif using partial update
        Gif partialUpdatedGif = new Gif();
        partialUpdatedGif.setId(gif.getId());

        partialUpdatedGif.giphyGifId(UPDATED_GIPHY_GIF_ID);

        restGifMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedGif.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedGif))
            )
            .andExpect(status().isOk());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
        Gif testGif = gifList.get(gifList.size() - 1);
        assertThat(testGif.getGiphyGifId()).isEqualTo(UPDATED_GIPHY_GIF_ID);
    }

    @Test
    @Transactional
    void patchNonExistingGif() throws Exception {
        int databaseSizeBeforeUpdate = gifRepository.findAll().size();
        gif.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restGifMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, gif.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(gif))
            )
            .andExpect(status().isBadRequest());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchGif() throws Exception {
        int databaseSizeBeforeUpdate = gifRepository.findAll().size();
        gif.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restGifMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(gif))
            )
            .andExpect(status().isBadRequest());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamGif() throws Exception {
        int databaseSizeBeforeUpdate = gifRepository.findAll().size();
        gif.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restGifMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(gif)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteGif() throws Exception {
        // Initialize the database
        gifRepository.saveAndFlush(gif);

        int databaseSizeBeforeDelete = gifRepository.findAll().size();

        // Delete the gif
        restGifMockMvc.perform(delete(ENTITY_API_URL_ID, gif.getId()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
