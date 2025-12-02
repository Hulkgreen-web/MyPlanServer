package com.helha.myplanserver.application.transaction.command.create;

import com.helha.myplanserver.application.utils.ICommandHandler;
import com.helha.myplanserver.infrastructure.transaction.DbTransaction;
import com.helha.myplanserver.infrastructure.transaction.ITransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionHandler implements ICommandHandler<CreateTransactionInput, CreateTrasactionOutput> {
    private final ITransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public CreateTransactionHandler(ITransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CreateTrasactionOutput handle(CreateTransactionInput input) {
        DbTransaction entity =modelMapper.map(input,DbTransaction.class);
        DbTransaction savedEntity = transactionRepository.save(entity);
        return modelMapper.map(savedEntity,CreateTrasactionOutput.class);
    }
}
