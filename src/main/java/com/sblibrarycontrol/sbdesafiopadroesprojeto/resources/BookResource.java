package com.sblibrarycontrol.sbdesafiopadroesprojeto.resources;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Book;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Book;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Book> insert(@RequestBody Book obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book>update(@PathVariable Long id, @RequestBody Book obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
