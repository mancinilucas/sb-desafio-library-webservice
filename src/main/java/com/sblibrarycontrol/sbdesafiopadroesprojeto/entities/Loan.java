package com.sblibrarycontrol.sbdesafiopadroesprojeto.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_loan")
public class Loan implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momentOfLoan;

    private Integer loanStatus;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User member;

    public Loan(){}

    public Loan(Long id, Instant momentOfLoan, LoanStatus loanStatus, User member) {
        this.id = id;
        this.momentOfLoan = momentOfLoan;
        setLoanStatus(loanStatus);
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomentOfLoan() {
        return momentOfLoan;
    }

    public void setMomentOfLoan(Instant momentOfLoan) {
        this.momentOfLoan = momentOfLoan;
    }

    public LoanStatus getLoanStatus() {
        return LoanStatus.valueOf(loanStatus);
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        if(loanStatus != null){
            this.loanStatus = loanStatus.getCode();
        }
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        return getId() != null ? getId().equals(loan.getId()) : loan.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
