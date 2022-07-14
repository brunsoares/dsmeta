package com.brunsoares.dsmeta.services;

import com.brunsoares.dsmeta.models.Sales;
import com.brunsoares.dsmeta.repositorys.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

@Service
public class SmsService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    private SaleRepository saleRepository;

    public void sendSms(Long id) {
        Sales sale = saleRepository.getReferenceById(id);

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message.creator(to, from, formatMessage(sale)).create();
    }

    private String formatMessage(Sales sale){
        DecimalFormat df = new DecimalFormat("#,###.00");
        StringBuilder message = new StringBuilder();
        message.append("Seller:     "+sale.getSellerName()+"\n");
        message.append("Sale Value: R$"+df.format(sale.getAmount())+"\n");
        message.append("Date:       "+sale.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        return message.toString();
    }
}


