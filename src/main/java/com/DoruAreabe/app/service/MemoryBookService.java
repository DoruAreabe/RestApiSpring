package com.DoruAreabe.app.service;

import com.DoruAreabe.app.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MemoryBookService {
    private List<Book> listOfBooks;

    public MemoryBookService() {
        listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book(1, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        listOfBooks.add(new Book(2, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        listOfBooks.add(new Book(3, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getAllBooks(){
        return listOfBooks;
    }
}
