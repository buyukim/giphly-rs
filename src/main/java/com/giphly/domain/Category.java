package com.giphly.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Category.
 */
@Entity
@Table(name = "category")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "tag", nullable = false)
    private String tag;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "category_gif",
               joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "gif_id", referencedColumnName = "id"))
    private Set<Gif> gifs = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public Category tag(String tag) {
        this.tag = tag;
        return this;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Set<Gif> getGifs() {
        return gifs;
    }

    public Category gifs(Set<Gif> gifs) {
        this.gifs = gifs;
        return this;
    }

    public Category addGif(Gif gif) {
        this.gifs.add(gif);
        gif.getCategories().add(this);
        return this;
    }

    public Category removeGif(Gif gif) {
        this.gifs.remove(gif);
        gif.getCategories().remove(this);
        return this;
    }

    public void setGifs(Set<Gif> gifs) {
        this.gifs = gifs;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Category)) {
            return false;
        }
        return id != null && id.equals(((Category) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + getId() +
            ", tag='" + getTag() + "'" +
            "}";
    }
}
