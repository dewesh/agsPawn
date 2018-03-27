package com.ags.pawn.services.agsPawnService.controllers;

import com.ags.pawn.services.agsPawnService.entity.Customer;
import com.ags.pawn.services.agsPawnService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/25/18.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List userDetails() {
        List customerDetails = customerService.getCustomers();
        return customerDetails;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable("id") UUID id) {
        return customerService.getCustomer(id);
    }
}
