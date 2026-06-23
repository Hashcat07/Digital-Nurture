package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void printBook(int id){
        String title=bookRepository.getBookTitle(id);
        System.out.println("Fetched: "+title);
    }
//    public void run() {
//        System.out.println("BookService is up and running.");
//    }
}