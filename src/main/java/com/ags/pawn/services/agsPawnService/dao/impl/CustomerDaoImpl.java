package com.ags.pawn.services.agsPawnService.dao.impl;

import com.ags.pawn.services.agsPawnService.dao.CustomerDao;
import com.ags.pawn.services.agsPawnService.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/25/18.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getCustomersDetails() {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        return customer;
    }
}
