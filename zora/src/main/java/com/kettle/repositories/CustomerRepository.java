package com.kettle.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.kettle.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
