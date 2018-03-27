package com.ags.pawn.services.agsPawnService.dao.impl;

import com.ags.pawn.services.agsPawnService.dao.TransactionDao;
import com.ags.pawn.services.agsPawnService.entity.Transaction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/26/18.
 */
@Transactional
@Repository
public class TransactionDaoImpl implements TransactionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getTransactionsByBaseTransactionId(UUID baseTransactionId) {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Transaction.class);
        criteria.add(Restrictions.eq("base_transaction.id",baseTransactionId));
        return criteria.list();
    }

    @Override
    public Transaction getTransactionById(UUID transactionId) {
        return entityManager.find(Transaction.class, transactionId);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        entityManager.persist(transaction);
        return transaction;
    }
}
