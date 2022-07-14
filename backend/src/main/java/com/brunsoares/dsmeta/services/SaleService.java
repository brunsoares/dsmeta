package com.brunsoares.dsmeta.services;

import com.brunsoares.dsmeta.models.Sales;
import com.brunsoares.dsmeta.repositorys.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Page<Sales> findSales(String initialDate, String finalDate, Pageable pegeable){
        LocalDate initialDateSQL = initialDate.equals("") ? today().minusYears(1) : LocalDate.parse(initialDate);
        LocalDate finalDateSQL = finalDate.equals("") ? today() : LocalDate.parse(finalDate);
        return saleRepository.findSales(initialDateSQL, finalDateSQL, pegeable);
    }

    private LocalDate today(){
        return LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
    }
}
