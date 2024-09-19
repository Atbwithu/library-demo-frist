package com.wzl.controller.userborrowbook;

import com.wzl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("borrow")
public class BorrowBookController {

    @Autowired
    BookService bookService;
    static int num = 0;
    @RequestMapping("borrwBook")
    public String borrwBook() {
        return null;
    }
}
