package com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.LoanItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanItemRepository extends JpaRepository<LoanItem, Long> {
}
