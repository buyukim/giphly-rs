package com.giphly.service;

import com.giphly.client.giphy.api.GifsApi;
import com.giphly.client.giphy.api.model.Gif;
import com.giphly.service.impl.GiphyGifServiceImpl;
import com.giphly.service.mapper.GiphyMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GiphyGifServiceImplTest {

    private static final String API_KEY = "1234";
    GiphyGifServiceImpl fixture;

    @Mock
    private GiphyMapper mapper;

    @BeforeAll
    public void setUp() {
        // TODO: will need to replace real API impl with Mock when time to test API logic
        fixture = new GiphyGifServiceImpl(new GifsApi(), mapper, API_KEY);
    }

    @Test
    public void testIsGifListNotFamilyFriendlySerialGRated() {
        // One R-rated GIF at the end
        var gifs = Arrays.asList(forRating("G"), forRating("G"));
        boolean result = fixture.isGifListNotFamilyFriendly(gifs);
        assertFalse("must be false; all G-rated content", result);
    }

    @Test
    public void testIsGifListNotFamilyFriendlyNullList() {
        // One R-rated GIF at the end
        boolean result = fixture.isGifListNotFamilyFriendly(null);
        assertFalse("must be false; null list", result);
    }

    @Test
    public void testIsGifListNotFamilyFriendlyEmptyList() {
        // One R-rated GIF at the end
        boolean result = fixture.isGifListNotFamilyFriendly(new ArrayList<Gif>(0));
        assertFalse("must be false; empty list", result);
    }

    @Test
    public void testIsGifListNotFamilyFriendlySerialNotGRated() {
        // One R-rated GIF at the end
        var gifs = Arrays.asList(forRating("G"), forRating("R"));
        boolean result = fixture.isGifListNotFamilyFriendly(gifs);
        assertTrue("must be true; R-rated content", result);
    }

    @Test
    public void testIsGifListNotFamilyFriendlyParallelNotGRated() {

        // One R-rated GIF at the end
        var gifs = Arrays.asList(forRating("G"), forRating("G"),
            forRating("G"),forRating("G"),forRating("G"),forRating("G")
        ,forRating("G"),forRating("G"),forRating("G"),forRating("G"),forRating("R"));

        boolean result = fixture.isGifListNotFamilyFriendly(gifs);
        assertTrue("must fail; R-rated GIF at the end", result);

        gifs = Arrays.asList(forRating("G"), forRating("G"),
            forRating("G"),forRating("G"),forRating("G"),forRating("G")
            ,forRating("G"),forRating("G"),forRating("G"),forRating("G"),forRating("PG"));
        result = fixture.isGifListNotFamilyFriendly(gifs);
        assertTrue("must fail; PG-rated GIF at the end", result);
    }

    @Test
    public void testIsGifListNotFamilyFriendlyParallelGRated() {

        // One R-rated GIF at the end
        var gifs = Arrays.asList(forRating("G"), forRating("G"),
            forRating("G"),forRating("G"),forRating("G"),forRating("G")
            ,forRating("G"),forRating("G"),forRating("G"),forRating("G"),forRating("G"));

        boolean result = fixture.isGifListNotFamilyFriendly(gifs);
        assertFalse("must be false; all G-rated content", result);

    }

    private Gif forRating(String rating) {
        return new Gif().rating(rating);
    }
}
