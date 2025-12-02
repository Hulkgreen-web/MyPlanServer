package com.helha.myplanserver.application.transaction.command;

import com.helha.myplanserver.application.transaction.command.create.CreateTransactionHandler;
import org.springframework.stereotype.Service;

@Service
public class TransactionCommandProcessor {
    public final CreateTransactionHandler createTransactionHandler;

    public TransactionCommandProcessor(CreateTransactionHandler createTransactionHandler) {
        this.createTransactionHandler = createTransactionHandler;
    }

}
