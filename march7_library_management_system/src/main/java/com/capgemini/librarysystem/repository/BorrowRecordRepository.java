package com.capgemini.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.librarysystem.model.BorrowRecord;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord,Long> {

}