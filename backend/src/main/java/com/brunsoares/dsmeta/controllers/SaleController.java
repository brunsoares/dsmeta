package com.brunsoares.dsmeta.controllers;

import com.brunsoares.dsmeta.models.Sales;
import com.brunsoares.dsmeta.services.SaleService;
import com.brunsoares.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public Page<Sales> findSales(
            @RequestParam(value = "initialDate", defaultValue = "") String initialDate,
            @RequestParam(value = "finalDate"  , defaultValue = "") String finalDate,
            Pageable pegeable) {
        return saleService.findSales(initialDate, finalDate, pegeable);
    }

    @GetMapping("/{id}/notification")
    public void notifySaleToSms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
