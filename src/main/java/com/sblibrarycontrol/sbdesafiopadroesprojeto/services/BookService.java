package com.sblibrarycontrol.sbdesafiopadroesprojeto.services;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Book;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book findById(Long id){
        Optional<Book> obj = repository.findById(id);
        return obj.get();
    }
}