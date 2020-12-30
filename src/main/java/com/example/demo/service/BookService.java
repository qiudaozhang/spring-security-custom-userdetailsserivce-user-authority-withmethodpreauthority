package com.example.demo.service;

import com.example.demo.commom.ServerResponse;
import com.example.demo.entity.Book;

/**
 * @author 邱道长
 * 2020/12/30
 */
public interface BookService {
    ServerResponse<Book> findById(Integer id);

    ServerResponse createBook(Book book);

    ServerResponse deleteBook(Integer id);

    ServerResponse modifyBook(Book book);
}
