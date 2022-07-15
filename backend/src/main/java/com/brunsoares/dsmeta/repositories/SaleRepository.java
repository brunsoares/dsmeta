package com.brunsoares.dsmeta.repositories;

import com.brunsoares.dsmeta.models.Sales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sales, Long> {
    @Query("SELECT obj FROM Sales obj WHERE obj.date BETWEEN :minimum AND :maximum ORDER BY obj.amount DESC")
    Page<Sales> findSales(LocalDate minimum, LocalDate maximum, Pageable pageable);
}
