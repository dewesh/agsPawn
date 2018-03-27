package com.ags.pawn.services.agsPawnService.dao;

import com.ags.pawn.services.agsPawnService.entity.BaseTransaction;

import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/26/18.
 */
public interface BaseTransactionDao {
    BaseTransaction startBaseTransaction(BaseTransaction baseTransaction);
    BaseTransaction closeBaseTransaction(UUID baseTransactionPk);
    BaseTransaction getBaseTransactionById(UUID baseTransactionPk);
    List getBaseTransactionsByCustomerPk(UUID customerPk);
}
