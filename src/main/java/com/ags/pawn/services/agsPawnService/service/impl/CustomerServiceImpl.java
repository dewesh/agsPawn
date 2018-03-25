package com.ags.pawn.services.agsPawnService.service.impl;

import com.ags.pawn.services.agsPawnService.dao.CustomerDao;
import com.ags.pawn.services.agsPawnService.entity.Customer;
import com.ags.pawn.services.agsPawnService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dagraw2 on 3/25/18.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List getCustomers() {
        return customerDao.getCustomersDetails();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }
}
