package com.helha.myplanserver.application.transaction.command.delete;

import com.helha.myplanserver.infrastructure.transaction.ITransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTransactionHandler {
    private ITransactionRepository transactionRepository;

    public DeleteTransactionHandler(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void handle(Long id){
        transactionRepository.deleteById(id);
    }
}
