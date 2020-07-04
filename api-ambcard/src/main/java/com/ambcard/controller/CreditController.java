package com.ambcard.controller;

import com.ambcard.business.CreditBusiness;
import com.ambcard.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit")
public class CreditController {


    @Autowired
    private CreditBusiness creditBusiness;

    @PostMapping
    public ResponseEntity<Boolean> newCredit(@RequestBody Credit credit){
        return new ResponseEntity<Boolean>(creditBusiness.makeCredit(credit), HttpStatus.ACCEPTED);
    }

}
