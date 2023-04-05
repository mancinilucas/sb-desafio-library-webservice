package com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
