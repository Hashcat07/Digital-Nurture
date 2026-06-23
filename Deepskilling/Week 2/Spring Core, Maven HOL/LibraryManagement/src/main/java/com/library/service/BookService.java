package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

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