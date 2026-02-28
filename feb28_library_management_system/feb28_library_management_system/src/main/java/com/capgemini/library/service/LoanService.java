package com.capgemini.library.service;

import com.capgemini.library.entity.Loan;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {

    Loan issueBook(Long memberId, Long bookId, LocalDate dueDate);

    Loan returnBook(Long loanId);

    Loan getLoanById(Long id);

    List<Loan> getAllLoans();

    List<Loan> getLoansByMember(Long memberId);
}