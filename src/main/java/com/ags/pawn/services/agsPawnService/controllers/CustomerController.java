package com.ags.pawn.services.agsPawnService.controllers;

import com.ags.pawn.services.agsPawnService.entity.Customer;
import com.ags.pawn.services.agsPawnService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by dagraw2 on 3/25/18.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List> userDetails() {

        List customerDetails = customerService.getCustomers();
        return new ResponseEntity<List>(customerDetails,HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
}
