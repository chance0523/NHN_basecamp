package com.basecamp.mreview.repository;

import com.basecamp.mreview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
