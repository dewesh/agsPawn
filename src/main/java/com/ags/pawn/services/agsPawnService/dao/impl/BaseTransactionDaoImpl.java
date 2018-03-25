package com.ags.pawn.services.agsPawnService.dao.impl;

import com.ags.pawn.services.agsPawnService.dao.BaseTransactionDao;
import com.ags.pawn.services.agsPawnService.entity.BaseTransaction;

import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/26/18.
 */
public class BaseTransactionDaoImpl implements BaseTransactionDao {
    @Override
    public BaseTransaction createBaseTransaction(BaseTransaction baseTransaction) {
        return null;
    }

    @Override
    public BaseTransaction closeBaseTransaction(UUID baseTransactionPk) {
        return null;
    }

    @Override
    public BaseTransaction getBaseTransactionById(UUID baseTransactionPk) {
        return null;
    }

    @Override
    public List getBaseTransactionsByCustomerPk(UUID customerPk) {
        return null;
    }
}
