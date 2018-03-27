package com.ags.pawn.services.agsPawnService.service.impl;

import com.ags.pawn.services.agsPawnService.dao.CustomerDao;
import com.ags.pawn.services.agsPawnService.entity.Customer;
import com.ags.pawn.services.agsPawnService.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/25/18.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

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

    @Override
    public Customer getCustomer(UUID id) {
        LOGGER.info("Get Customer Called for ID:"+id);
        return customerDao.getCustomerById(id);
    }
}
