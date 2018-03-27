package com.ags.pawn.services.agsPawnService.dao.impl;

import com.ags.pawn.services.agsPawnService.dao.CustomerDao;
import com.ags.pawn.services.agsPawnService.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/25/18.
 */
@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getCustomersDetails() {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Override
    @Transactional
    public Customer getCustomerById(UUID id) {
        Customer customer = entityManager.find(Customer.class,id);
        return customer;
    }
}
