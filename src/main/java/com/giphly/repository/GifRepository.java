package com.giphly.repository;

import com.giphly.domain.Gif;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Gif entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GifRepository extends JpaRepository<Gif, Long> {
}
