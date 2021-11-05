package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.RentalBook;
import com.codegym.service.impl.BookServiceImpl;
import com.codegym.service.impl.RentalBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookServiceImpl bookService;
    @Autowired
    RentalBookServiceImpl rentalBookService;
    @GetMapping("")
    public String showList(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList);
        return "/list";
    }
    @GetMapping("/rent/{id}")
    public String showRent(Model model,@PathVariable long id){
        Book book = new Book();
        book.setId(id);
        Random generator = new Random();
        int code = generator.nextInt(99999) + 1;
        RentalBook rentalBook = new RentalBook(code,book);
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList);
        model.addAttribute("rentalBook",rentalBook);
        return "/rent";
    }
    @PostMapping("/rent")
    public String saveRent(Model model,@ModelAttribute RentalBook rentalBook){
        Book book = bookService.findById(rentalBook.getBook().getId());
        if(book.getQuantity() == 0){
            return "error";
        }
        long temp = book.getQuantity() - 1;
        book.setQuantity(temp);
        bookService.save(book);
        rentalBookService.save(rentalBook);
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList);

        return "/list";
    }
    @GetMapping("/repay")
    public String showRepayBook(){
//
        return "/repay";
    }
    @PostMapping("/repay")
    public String saveRepayBook(@RequestParam(required = false) long codeRenta, Model model){
        List<RentalBook> rentalBookList = rentalBookService.finfAll();

        for (int i = 0; i < rentalBookList.size(); i++) {
            if(codeRenta == rentalBookList.get(i).getCodeRenta()){
                Book book = bookService.findById(rentalBookList.get(i).getBook().getId());
                long temp = book.getQuantity() + 1;
                book.setQuantity(temp);
                bookService.save(book);
                rentalBookService.delete(rentalBookList.get(i));
            }
        }
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList);
        return "/list";
    }
}
