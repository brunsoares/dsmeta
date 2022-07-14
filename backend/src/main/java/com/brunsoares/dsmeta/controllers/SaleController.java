package com.brunsoares.dsmeta.controllers;

import com.brunsoares.dsmeta.models.Sales;
import com.brunsoares.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public Page<Sales> findSales(
            @RequestParam(value = "initialDate", defaultValue = "") String initialDate,
            @RequestParam(value = "finalDate"  , defaultValue = "") String finalDate,
            Pageable pegeable) {
        return saleService.findSales(initialDate, finalDate, pegeable);
    }
}
