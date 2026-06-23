package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public String getBookTitle(int id) {
        return "Book Temp (id=" + id + ")";
    }
}