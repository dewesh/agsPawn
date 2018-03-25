package com.ags.pawn.services.agsPawnService.dao.impl;

import com.ags.pawn.services.agsPawnService.dao.TransactionDao;
import com.ags.pawn.services.agsPawnService.entity.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/26/18.
 */
public class TransactionDaoImpl implements TransactionDao {
    @Override
    public List getTransactionsByBaseTransactionId(UUID baseTransactionId) {
        return null;
    }

    @Override
    public Transaction getTransactionById(UUID transactionId) {
        return null;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return null;
    }
}
