package com.example.demo.dao;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author 邱道长
 * 2020/12/30
 */
public interface BookDao extends JpaRepository<Book,Integer> {

    Optional<Book> findBookById(Integer id);
}
