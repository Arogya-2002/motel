package com.kettle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kettle.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
