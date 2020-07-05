package com.ambcard.controller;

import com.ambcard.business.WalletBusiness;
import com.ambcard.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletCRUDController {

    @Autowired
    private WalletBusiness customerBusiness;

    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getCustomerById(@PathVariable("id") String id) {
        return new ResponseEntity<Wallet>( customerBusiness.findWalletById(id),HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Wallet>  createCustomer(@RequestBody Wallet customer) {
        return new ResponseEntity<Wallet>( customerBusiness.createWallet(customer),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Wallet>  updateCustomer(@PathVariable("id") String id, @RequestBody Wallet customer) {
        return new ResponseEntity<Wallet>(customerBusiness.update(customer,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id") String id) {
        return new ResponseEntity<Boolean>( customerBusiness.deleteWallet(id),HttpStatus.OK);
    }

}

