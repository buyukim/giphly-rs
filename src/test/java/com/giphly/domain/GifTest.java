package com.giphly.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.giphly.web.rest.TestUtil;

public class GifTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Gif.class);
        Gif gif1 = new Gif();
        gif1.setId(1L);
        Gif gif2 = new Gif();
        gif2.setId(gif1.getId());
        assertThat(gif1).isEqualTo(gif2);
        gif2.setId(2L);
        assertThat(gif1).isNotEqualTo(gif2);
        gif1.setId(null);
        assertThat(gif1).isNotEqualTo(gif2);
    }
}
