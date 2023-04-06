package com.sblibrarycontrol.sbdesafiopadroesprojeto.repositories;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
