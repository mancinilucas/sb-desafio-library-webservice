package com.sblibrarycontrol.sbdesafiopadroesprojeto.services;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Book;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Book;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories.BookRepository;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.services.exceptions.DatabaseExceptions;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Book insert(Book obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseExceptions(e.getMessage());
        }

    }

    public Book update(Long id, Book obj){
        try {
            Book entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Book entity, Book obj) {
        entity.setTitle(obj.getTitle());
        entity.setAuthor(obj.getAuthor());
        entity.setReleaseYear(obj.getReleaseYear());

    }
}
