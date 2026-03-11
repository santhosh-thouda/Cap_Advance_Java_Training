package com.capgemini.sms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.sms.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Long>{

Optional<AppUser> findByUsername(String username);

}