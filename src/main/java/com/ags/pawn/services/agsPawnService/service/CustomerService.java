package com.ags.pawn.services.agsPawnService.service;

import com.ags.pawn.services.agsPawnService.entity.Customer;

import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/25/18.
 */
public interface CustomerService {
    List getCustomers();
    Customer createCustomer(Customer customer);
    Customer getCustomer(UUID id);
}
