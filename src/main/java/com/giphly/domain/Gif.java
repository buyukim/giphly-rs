package com.giphly.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Gif.
 */
@Entity
@Table(name = "gif")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Gif implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "giphy_gif_id", nullable = false)
    private String giphyGifId;

    @ManyToMany(mappedBy = "gifs")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Category> categories = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiphyGifId() {
        return giphyGifId;
    }

    public Gif giphyGifId(String giphyGifId) {
        this.giphyGifId = giphyGifId;
        return this;
    }

    public void setGiphyGifId(String giphyGifId) {
        this.giphyGifId = giphyGifId;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Gif categories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Gif addCategory(Category category) {
        this.categories.add(category);
        category.getGifs().add(this);
        return this;
    }

    public Gif removeCategory(Category category) {
        this.categories.remove(category);
        category.getGifs().remove(this);
        return this;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Gif)) {
            return false;
        }
        return id != null && id.equals(((Gif) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Gif{" +
            "id=" + getId() +
            ", giphyGifId='" + getGiphyGifId() + "'" +
            "}";
    }
}
