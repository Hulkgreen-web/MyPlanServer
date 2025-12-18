package com.helha.myplanserver.application.transaction.command.update;

import com.helha.myplanserver.application.utils.IEffectCommandHandler;
import com.helha.myplanserver.infrastructure.transaction.ITransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTransactionHandler implements IEffectCommandHandler<UpdateTransactionInput> {
    private final ITransactionRepository transactionRepository;

    public UpdateTransactionHandler(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void handle(UpdateTransactionInput input) {
        transactionRepository
                .findById(input.id)
                .map(e -> {
                    e.date_operation = input.date_operation;
                    e.montant_operation = input.montant_operation;
                    e.type_operation = input.type_operation;
                    e.category_transaction_id = input.category_transaction_id;
                    e.subcategory_transaction_id = input.subcategory_transaction_id;

                    return transactionRepository.save(e);
                }).orElseThrow(() -> new IllegalArgumentException("Transaction not found"));
    }
}
