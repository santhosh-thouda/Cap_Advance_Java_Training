package com.capgemini.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.librarysystem.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}