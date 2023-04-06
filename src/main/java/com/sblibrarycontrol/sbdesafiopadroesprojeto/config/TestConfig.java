package com.sblibrarycontrol.sbdesafiopadroesprojeto.config;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.*;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories.BookRepository;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories.LoanItemRepository;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories.LoanRepository;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanItemRepository loanItemRepository;


    @Override
    public void run(String... args) throws Exception {
        Book b1 = new Book(null, "Livro do Desassossego", "Fernando Pessoa", "1982");
        Book b2 = new Book(null, "Tudo sobre o amor", "Bell Hooks", "2021");
        Book b3 = new Book(null, "Dom Casmurro", "Machado de Assis", "1899");
        Book b4 = new Book(null, "O gato preto", "Edgar A Poe", "1843");
        bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4));

        User u1 = new User(null, "Leticia Santos", "739999944444");
        User u2 = new User(null, "Ana Silva", "73888883333");


        Loan l1 = new Loan(null, Instant.parse("2023-02-18T14:50:07Z"), LoanStatus.RETURNED, u1);
        Loan l2 = new Loan(null, Instant.parse("2023-03-25T20:20:07Z"), LoanStatus.LOANED,u2);
        Loan l3 = new Loan(null, Instant.parse("2023-04-02T16:53:07Z"), LoanStatus.LOANED,u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        loanRepository.saveAll(Arrays.asList(l1,l2,l3));

        LoanItem li1 = new LoanItem(l1, b3);
        LoanItem li2 = new LoanItem(l2, b1);
        LoanItem li3 = new LoanItem(l3, b4);
        loanItemRepository.saveAll(Arrays.asList(li1,li2,li3));
    }
}
