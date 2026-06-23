package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private final BookRepository bookRepository;
    private String libraryName;

    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void setLibraryName(String libraryName){
        this.libraryName=libraryName;
    }

    public void printBook(int id){
//        try{
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
        String title=bookRepository.getBookTitle(id);
        System.out.println("Fetched: "+title+" from Library: "+libraryName);
    }
//    public void run() {
//        System.out.println("BookService is up and running.");
//    }
}