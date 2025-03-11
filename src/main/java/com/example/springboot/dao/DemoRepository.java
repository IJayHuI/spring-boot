package com.example.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemoRepository extends JpaRepository<Demo, Long> {

    List<Demo> findByEmail(String email);

}
