package com.example.spring_based.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositories extends JpaRepository<StudentEntity,Integer> {
    Page<StudentEntity> findAll(Pageable pageable);
}
