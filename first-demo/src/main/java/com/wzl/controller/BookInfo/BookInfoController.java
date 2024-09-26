package com.wzl.controller.BookInfo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzl.entity.Book;
import com.wzl.service.BookService;
import com.wzl.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("book")
public class BookInfoController {
    @Autowired
    BookService bookService;
    //查询所有
    @GetMapping("getAllBook")
    @Cacheable("allBooks")
    public ResponseResult BookInfoController() {
        return ResponseResult.success(200,"请求成功",bookService.list());
    }

    /**
     * 根据姓名和作者查询
     * @param book
     * @return
     */
    @GetMapping("getAllBookByCondition")
    public ResponseResult BookInfoControllerByCondition (@RequestBody Book book) {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("name",book.getName());
        wrapper.like("author",book.getAuthor());
        return ResponseResult.success(200,"查询成功",bookService.list(wrapper));
    }
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("choosePage")
    public ResponseResult choosePage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        try {
            IPage<Book> page = new Page<>(pageNum, pageSize);
            IPage<Book> bookPage = bookService.page(page);
            long total = bookPage.getTotal();
            List<Book> records = bookPage.getRecords();
            if (records.isEmpty()) {
                return ResponseResult.success(200, "No data found", new ArrayList<>());
            } else {
                return ResponseResult.success(200, String.valueOf(total), records);
            }
        } catch (Exception e) {
            return ResponseResult.fail(500, "An error occurred while fetching data");
        }
    }

    /**
     * 上架书本
     * @param book
     * @return
     */
    @PostMapping("addBook")
    @Transactional
    public ResponseResult addBook(@RequestBody Book book) {
        return ResponseResult.success(200,"上架成功");
    }

    /**
     * 根据id删除单个书本
     * @param id
     * @return
     */
    @PostMapping("deleteOnlyBook")
    @Transactional
    public ResponseResult deleteOnly(@RequestParam("id") int id) {
        if (bookService.removeById(id)){
            return ResponseResult.success(200);
        }
        return ResponseResult.fail(400);
    }

    /***
     * 根据数组批量删除书本
     * @param ids
     * @return
     */
    @PostMapping("deleteChooseBook")
    @Transactional
    public ResponseResult deleteChoose(@RequestParam("id") int[] ids) {
        if (bookService.removeBatchByIds(List.of(ids))){
            return ResponseResult.success(200,"删除成功");
        }
        return ResponseResult.fail(400,"删除失败");
    }

    /***
     * 根据id查询具体书本
     * @param id
     * @return
     */
    @PostMapping("getOnlyBook")
    public ResponseResult getOnlyBook(@RequestParam("id") int id){
        Book book = bookService.getById(id);
        return ResponseResult.success(200,"查询成功！",book);
    }

    /**
     * 修改书本信息
     * @param book
     * @return
     */
    @PostMapping("updateBook")
    public ResponseResult updateBook(@RequestBody Book book){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        if (bookService.update(wrapper.eq("id",book.getId()))){
            return ResponseResult.success(200,"修改成功");
        }
        return ResponseResult.fail(200,"修改失败");
    }

}
