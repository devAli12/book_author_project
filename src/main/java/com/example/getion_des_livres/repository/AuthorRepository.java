package com.example.getion_des_livres.repository;

import com.example.getion_des_livres.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
