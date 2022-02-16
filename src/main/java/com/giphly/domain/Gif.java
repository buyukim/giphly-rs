package com.giphly.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Gif.
 */
@Entity
@Table(name = "gif")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "gifs" }, allowSetters = true)
    private Set<Category> categories = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gif id(Long id) {
        this.id = id;
        return this;
    }

    public String getGiphyGifId() {
        return this.giphyGifId;
    }

    public Gif giphyGifId(String giphyGifId) {
        this.giphyGifId = giphyGifId;
        return this;
    }

    public void setGiphyGifId(String giphyGifId) {
        this.giphyGifId = giphyGifId;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public Gif categories(Set<Category> categories) {
        this.setCategories(categories);
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
        if (this.categories != null) {
            this.categories.forEach(i -> i.removeGif(this));
        }
        if (categories != null) {
            categories.forEach(i -> i.addGif(this));
        }
        this.categories = categories;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

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
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Gif{" +
            "id=" + getId() +
            ", giphyGifId='" + getGiphyGifId() + "'" +
            "}";
    }
}
