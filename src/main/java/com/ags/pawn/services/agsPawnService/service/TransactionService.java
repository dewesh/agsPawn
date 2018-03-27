package com.ags.pawn.services.agsPawnService.service;

import com.ags.pawn.services.agsPawnService.entity.BaseTransaction;

import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/26/18.
 */
public interface TransactionService {
    List getTransactions();
    List getTransactionsByCustomerId(UUID id);
    BaseTransaction startBaseTransaction(BaseTransaction baseTransaction);
    BaseTransaction closeBaseTransaction(UUID id);
    BaseTransaction getBaseTransaction(UUID id);
}
