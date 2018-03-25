package com.ags.pawn.services.agsPawnService.service;

import com.ags.pawn.services.agsPawnService.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dagraw2 on 3/25/18.
 */
public interface CustomerService {
    List getCustomers();
    Customer createCustomer(Customer customer);
}
