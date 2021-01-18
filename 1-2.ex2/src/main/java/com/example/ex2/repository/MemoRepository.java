package com.example.ex2.repository;

import com.example.ex2.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // Spring Data JPA는 인터페이스 선언만으로도 자동으로 스프링의 빈으로 등록

    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
}
