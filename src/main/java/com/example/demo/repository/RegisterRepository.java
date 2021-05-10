package com.example.demo.repository;

import com.example.demo.model.Expert;
import com.example.demo.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<UserDetail, Long> {
}
