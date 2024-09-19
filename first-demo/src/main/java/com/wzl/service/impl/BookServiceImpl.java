package com.wzl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzl.entity.Book;
import com.wzl.mapper.BookMapper;
import com.wzl.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
