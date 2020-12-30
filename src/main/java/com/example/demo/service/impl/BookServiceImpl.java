package com.example.demo.service.impl;

import com.example.demo.commom.ServerResponse;
import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * @author 邱道长
 * 2020/12/30
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;
    @Override
    public ServerResponse<Book> findById(Integer id) {
        Optional<Book> op = bookDao.findBookById(id);
        Book book = op.orElseThrow(() -> new EntityNotFoundException());
        return ServerResponse.success(book);
    }

    @Override
    public ServerResponse createBook(Book book) {
        System.out.println("写书");
        bookDao.save(book);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteBook(Integer id) {
        bookDao.deleteById(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse modifyBook(Book book) {
        Optional<Book> op = bookDao.findBookById(book.getId());
        Book b = op.orElseThrow(() -> new EntityNotFoundException());
        bookDao.save(book);
        return ServerResponse.success();
    }
}
