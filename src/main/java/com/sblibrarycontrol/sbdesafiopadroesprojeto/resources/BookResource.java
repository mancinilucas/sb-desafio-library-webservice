package com.sblibrarycontrol.sbdesafiopadroesprojeto.resources;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

    @GetMapping
    public ResponseEntity<Book> findAll(){
        Book book = new Book(1L, "Livro do Desassossego", "Pessoa, Fernando", "1982");
        return ResponseEntity.ok().body(book);
    }
}
