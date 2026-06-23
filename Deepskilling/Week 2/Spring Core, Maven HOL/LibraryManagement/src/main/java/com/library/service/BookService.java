package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void printBook(int id){
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String title=bookRepository.getBookTitle(id);
        System.out.println("Fetched: "+title);
    }
//    public void run() {
//        System.out.println("BookService is up and running.");
//    }
}