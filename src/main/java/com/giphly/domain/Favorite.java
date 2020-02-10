package com.giphly.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Favorite.
 */
@Entity
// Manual entry - add unique composite index
@Table(name = "favorite", uniqueConstraints=
    @UniqueConstraint(columnNames = {"user_id", "gif_id"}))
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Favorite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("favorites")
    private Gif gif;

    @ManyToOne
    @JsonIgnoreProperties("favorites")
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gif getGif() {
        return gif;
    }

    public Favorite gif(Gif gif) {
        this.gif = gif;
        return this;
    }

    public void setGif(Gif gif) {
        this.gif = gif;
    }

    public User getUser() {
        return user;
    }

    public Favorite user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Favorite)) {
            return false;
        }
        return id != null && id.equals(((Favorite) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Favorite{" +
            "id=" + getId() +
            "}";
    }
}
