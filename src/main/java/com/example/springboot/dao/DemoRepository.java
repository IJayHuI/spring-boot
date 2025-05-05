package com.example.springboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemoRepository extends JpaRepository<Demo, Long> {

    List<Demo> findByEmail(String email);

    Page<Demo> findByNameContainingOrEmailContaining(
            String name, String email, Pageable pageable);

}
