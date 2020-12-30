package com.example.demo.controller;

import com.example.demo.commom.ServerResponse;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 邱道长
 * 2020/12/30
 */
@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Resource
    private BookService bookService;

    @PreAuthorize("hasAuthority('book:read')")
    @GetMapping("{id}")
    public ServerResponse<Book> get(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    // 注解授权模式，这样需要一个一个配置，还是比较麻烦
    @PreAuthorize("hasAuthority('book:write')")
    @PostMapping
    public ServerResponse createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }


    // 注解授权模式，这样需要一个一个配置，还是比较麻烦
    @PreAuthorize("hasAuthority('book:delete')")
    @DeleteMapping("{id}")
    public ServerResponse deleteBook(@PathVariable("id") Integer id) {
        return bookService.deleteBook(id);
    }

    @PreAuthorize("hasAuthority('book:modify')")
    @PutMapping
    public ServerResponse modifyBook(@RequestBody Book book) {
        return bookService.modifyBook(book);
    }


}
