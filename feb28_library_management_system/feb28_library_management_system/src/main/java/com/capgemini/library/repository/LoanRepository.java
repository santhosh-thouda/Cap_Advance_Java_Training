package com.capgemini.library.repository;

import com.capgemini.library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByMemberMemberId(Long memberId);
}