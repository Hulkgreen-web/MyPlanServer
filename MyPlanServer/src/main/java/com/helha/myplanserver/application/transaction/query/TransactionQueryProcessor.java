package com.helha.myplanserver.application.transaction.query;

import com.helha.myplanserver.application.transaction.query.getall.GetAllTransactionHandler;
import org.springframework.stereotype.Service;

@Service
public class TransactionQueryProcessor {
    public final GetAllTransactionHandler getAllTransactionHandler;

    public TransactionQueryProcessor(GetAllTransactionHandler getAllTransactionHandler) {
        this.getAllTransactionHandler = getAllTransactionHandler;
    }

}
