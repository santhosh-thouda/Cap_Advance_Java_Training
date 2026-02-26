package com.capgemini.springbootbasic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarJpaRepository extends JpaRepository<Car, Integer>{
	public Car getByPrice(double price);
}
