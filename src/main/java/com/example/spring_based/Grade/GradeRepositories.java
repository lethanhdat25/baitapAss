package com.example.spring_based.Grade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepositories extends JpaRepository<GradeEntity,Integer> {
    Page<GradeEntity> findAll(Pageable pageable);

}
