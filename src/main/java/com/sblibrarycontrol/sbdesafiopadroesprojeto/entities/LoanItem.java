package com.sblibrarycontrol.sbdesafiopadroesprojeto.entities;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.pk.LoanItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_loan_item")
public class LoanItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private LoanItemPK id;

    public LoanItem() {
    }

    public LoanItem(Loan loan, Book book){
        id.setLoan(loan);
        id.setBook(book);
    }

    public Loan getLoan(){
        return id.getLoan();
    }

    public void setLoan(Loan loan){
        id.setLoan(loan);
    }

    public Book getBook(){
        return id.getBook();
    }

    public void setBook(Book book){
        id.setBook(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanItem loanItem = (LoanItem) o;

        return Objects.equals(id, loanItem.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
