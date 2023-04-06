package com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.pk;

import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Book;
import com.sblibrarycontrol.sbdesafiopadroesprojeto.entities.Loan;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

public class LoanItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanItemPK that = (LoanItemPK) o;

        if (getLoan() != null ? !getLoan().equals(that.getLoan()) : that.getLoan() != null) return false;
        return getBook() != null ? getBook().equals(that.getBook()) : that.getBook() == null;
    }

    @Override
    public int hashCode() {
        int result = getLoan() != null ? getLoan().hashCode() : 0;
        result = 31 * result + (getBook() != null ? getBook().hashCode() : 0);
        return result;
    }
}
