package com.basecamp.mreview.repository;

import com.basecamp.mreview.entity.MovieImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {

    @Query("select m, mi, avg(coalesce(r.grade,0)), count(distinct r) " +
            "from Movie m " +
            "left outer join MovieImage mi on mi.movie = m " +
            "left outer join Review r on r.movie = m " +
            "group by m ")
    Page<Object[]> getListPage(Pageable pageable);
}
