package com.ags.pawn.services.agsPawnService.service.impl;

import com.ags.pawn.services.agsPawnService.dao.BaseTransactionDao;
import com.ags.pawn.services.agsPawnService.dao.TransactionDao;
import com.ags.pawn.services.agsPawnService.entity.BaseTransaction;
import com.ags.pawn.services.agsPawnService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/27/18.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private BaseTransactionDao baseTransactionDao;

    @Autowired
    private TransactionDao transactionDao;

    @Override
    public List getTransactions() {
        return null;
    }

    @Override
    public List getTransactionsByCustomerId(UUID id) {
        List<BaseTransaction> baseTransactions = baseTransactionDao.getBaseTransactionsByCustomerPk(id);
        return baseTransactions;
    }

    @Override
    public BaseTransaction startBaseTransaction(BaseTransaction baseTransaction) {
        return baseTransactionDao.startBaseTransaction(baseTransaction);
    }

    @Override
    public BaseTransaction closeBaseTransaction(UUID id) {
        return baseTransactionDao.closeBaseTransaction(id);
    }

    @Override
    public BaseTransaction getBaseTransaction(UUID id) {
        BaseTransaction baseTransaction =  baseTransactionDao.getBaseTransactionById(id);
        return baseTransaction;
    }
}
