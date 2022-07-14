package com.brunsoares.dsmeta.services;

import com.brunsoares.dsmeta.models.Sales;
import com.brunsoares.dsmeta.repositorys.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sales> findSales(){
        return saleRepository.findAll();
    }
}
