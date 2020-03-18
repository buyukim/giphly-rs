package com.giphly.web.rest;

import com.giphly.GiphlyApp;
import com.giphly.domain.Gif;
import com.giphly.repository.GifRepository;
import com.giphly.service.GifService;
import com.giphly.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static com.giphly.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link GifResource} REST controller.
 */
@SpringBootTest(classes = GiphlyApp.class)
public class GifResourceIT {

    private static final String DEFAULT_GIPHY_GIF_ID = "AAAAAAAAAA";
    private static final String UPDATED_GIPHY_GIF_ID = "BBBBBBBBBB";

    @Autowired
    private GifRepository gifRepository;

    @Autowired
    private GifService gifService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restGifMockMvc;

    private Gif gif;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final GifResource gifResource = new GifResource(gifService);
        this.restGifMockMvc = MockMvcBuilders.standaloneSetup(gifResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Gif createEntity(EntityManager em) {
        Gif gif = new Gif()
            .giphyGifId(DEFAULT_GIPHY_GIF_ID);
        return gif;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Gif createUpdatedEntity(EntityManager em) {
        Gif gif = new Gif()
            .giphyGifId(UPDATED_GIPHY_GIF_ID);
        return gif;
    }

    @BeforeEach
    public void initTest() {
        gif = createEntity(em);
    }

    @Test
    @Transactional
    public void createGif() throws Exception {
        int databaseSizeBeforeCreate = gifRepository.findAll().size();

        // Create the Gif
        restGifMockMvc.perform(post("/api/gifs")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(gif)))
            .andExpect(status().isCreated());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeCreate + 1);
        Gif testGif = gifList.get(gifList.size() - 1);
        assertThat(testGif.getGiphyGifId()).isEqualTo(DEFAULT_GIPHY_GIF_ID);
    }

    @Test
    @Transactional
    public void createGifWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = gifRepository.findAll().size();

        // Create the Gif with an existing ID
        gif.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restGifMockMvc.perform(post("/api/gifs")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(gif)))
            .andExpect(status().isBadRequest());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkGiphyGifIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = gifRepository.findAll().size();
        // set the field null
        gif.setGiphyGifId(null);

        // Create the Gif, which fails.

        restGifMockMvc.perform(post("/api/gifs")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(gif)))
            .andExpect(status().isBadRequest());

        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllGifs() throws Exception {
        // Initialize the database
        gifRepository.saveAndFlush(gif);

        // Get all the gifList
        restGifMockMvc.perform(get("/api/gifs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(gif.getId().intValue())))
            .andExpect(jsonPath("$.[*].giphyGifId").value(hasItem(DEFAULT_GIPHY_GIF_ID)));
    }
    
    @Test
    @Transactional
    public void getGif() throws Exception {
        // Initialize the database
        gifRepository.saveAndFlush(gif);

        // Get the gif
        restGifMockMvc.perform(get("/api/gifs/{id}", gif.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(gif.getId().intValue()))
            .andExpect(jsonPath("$.giphyGifId").value(DEFAULT_GIPHY_GIF_ID));
    }

    @Test
    @Transactional
    public void getNonExistingGif() throws Exception {
        // Get the gif
        restGifMockMvc.perform(get("/api/gifs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateGif() throws Exception {
        // Initialize the database
        gifService.save(gif);

        int databaseSizeBeforeUpdate = gifRepository.findAll().size();

        // Update the gif
        Gif updatedGif = gifRepository.findById(gif.getId()).get();
        // Disconnect from session so that the updates on updatedGif are not directly saved in db
        em.detach(updatedGif);
        updatedGif
            .giphyGifId(UPDATED_GIPHY_GIF_ID);

        restGifMockMvc.perform(put("/api/gifs")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedGif)))
            .andExpect(status().isOk());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
        Gif testGif = gifList.get(gifList.size() - 1);
        assertThat(testGif.getGiphyGifId()).isEqualTo(UPDATED_GIPHY_GIF_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingGif() throws Exception {
        int databaseSizeBeforeUpdate = gifRepository.findAll().size();

        // Create the Gif

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restGifMockMvc.perform(put("/api/gifs")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(gif)))
            .andExpect(status().isBadRequest());

        // Validate the Gif in the database
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteGif() throws Exception {
        // Initialize the database
        gifService.save(gif);

        int databaseSizeBeforeDelete = gifRepository.findAll().size();

        // Delete the gif
        restGifMockMvc.perform(delete("/api/gifs/{id}", gif.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Gif> gifList = gifRepository.findAll();
        assertThat(gifList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
