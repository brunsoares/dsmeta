package com.brunsoares.dsmeta.repositorys;

import com.brunsoares.dsmeta.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sales, Long> {

}
