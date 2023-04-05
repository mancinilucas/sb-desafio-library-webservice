package com.sblibrarycontrol.sbdesafiopadroesprojeto.config;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Book;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Book b1 = new Book(null, "Livro do Desassossego", "Fernando Pessoa", "1982");
        Book b2 = new Book(null, "Tudo sobre o amor", "Bell Hooks", "2021");

        bookRepository.saveAll(Arrays.asList(b1, b2));
    }
}
