package com.ags.pawn.services.agsPawnService.dao;

import com.ags.pawn.services.agsPawnService.entity.BaseTransaction;
import com.ags.pawn.services.agsPawnService.entity.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/26/18.
 */
public interface TransactionDao {
    List getTransactionsByBaseTransactionId(UUID baseTransactionId);
    Transaction getTransactionById(UUID transactionId);
    Transaction createTransaction(Transaction transaction);
}
