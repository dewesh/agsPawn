package com.ags.pawn.services.agsPawnService.dao;

import com.ags.pawn.services.agsPawnService.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/25/18.
 */
public interface CustomerDao {

    List getCustomersDetails();

    Customer createCustomer(Customer customer);

    Customer getCustomerById(UUID id);
}
