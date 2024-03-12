package com.example.getion_des_livres.repository;

import com.example.getion_des_livres.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
