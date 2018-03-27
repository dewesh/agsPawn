package com.ags.pawn.services.agsPawnService.controllers;

import com.ags.pawn.services.agsPawnService.entity.BaseTransaction;
import com.ags.pawn.services.agsPawnService.entity.Customer;
import com.ags.pawn.services.agsPawnService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * Created by dagraw2 on 3/26/18.
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/base/start", method = RequestMethod.POST)
    @ResponseBody
    public BaseTransaction startTransaction(@Valid @RequestBody BaseTransaction baseTransaction) {
        return transactionService.startBaseTransaction(baseTransaction);
    }

    @RequestMapping(value = "/base/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseTransaction getBaseTransaction(@PathVariable("id") UUID id ) {
        return transactionService.getBaseTransaction(id);
    }

    // Todo : response should be uniform, some full resp DTO some responds with id
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BaseTransaction> getBaseTransactionByCustomerId(@PathVariable("id") UUID id ) {
        return transactionService.getTransactionsByCustomerId(id);
    }
}
