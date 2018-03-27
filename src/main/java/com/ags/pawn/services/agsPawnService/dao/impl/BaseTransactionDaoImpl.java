package com.ags.pawn.services.agsPawnService.dao.impl;

import com.ags.pawn.services.agsPawnService.dao.BaseTransactionDao;
import com.ags.pawn.services.agsPawnService.entity.BaseTransaction;
import com.ags.pawn.services.agsPawnService.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/26/18.
 */
@Transactional
@Repository
public class BaseTransactionDaoImpl implements BaseTransactionDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BaseTransaction startBaseTransaction(BaseTransaction baseTransaction) {
        baseTransaction.setCustomer(entityManager.find(Customer.class,baseTransaction.getCustomer().getId()));
        entityManager.persist(baseTransaction);
        return baseTransaction;
    }

    @Override
    public BaseTransaction closeBaseTransaction(UUID baseTransactionPk) {
        BaseTransaction baseTransaction = entityManager.find(BaseTransaction.class, baseTransactionPk);
        baseTransaction.setActive(false);
        entityManager.merge(baseTransaction);
        return baseTransaction;
    }

    @Override
    public BaseTransaction getBaseTransactionById(UUID baseTransactionPk) {
        return entityManager.find(BaseTransaction.class, baseTransactionPk);
    }

    @Override
    public List getBaseTransactionsByCustomerPk(UUID customerPk) {
        List<BaseTransaction> baseTransactions = new ArrayList<>();
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(BaseTransaction.class);
        criteria.add(Restrictions.eq("customer.id",customerPk));
        return criteria.list();
    }
}
