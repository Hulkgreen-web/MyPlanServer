package com.helha.myplanserver.application.transaction.command;

import com.helha.myplanserver.application.transaction.command.create.CreateTransactionHandler;
import com.helha.myplanserver.application.transaction.command.delete.DeleteTransactionHandler;
import com.helha.myplanserver.application.transaction.command.update.UpdateTransactionHandler;
import org.springframework.stereotype.Service;

@Service
public class TransactionCommandProcessor {
    public final CreateTransactionHandler createTransactionHandler;
    public final UpdateTransactionHandler updateTransactionHandler;
    public final DeleteTransactionHandler deleteTransactionHandler;

    public TransactionCommandProcessor(CreateTransactionHandler createTransactionHandler, UpdateTransactionHandler updateTransactionHandler, DeleteTransactionHandler deleteTransactionHandler) {
        this.createTransactionHandler = createTransactionHandler;
        this.updateTransactionHandler = updateTransactionHandler;
        this.deleteTransactionHandler = deleteTransactionHandler;
    }

}
