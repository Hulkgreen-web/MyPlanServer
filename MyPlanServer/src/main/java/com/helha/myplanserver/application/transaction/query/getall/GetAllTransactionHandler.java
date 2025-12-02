package com.helha.myplanserver.application.transaction.query.getall;

import com.helha.myplanserver.application.utils.IQueryHandler;
import com.helha.myplanserver.infrastructure.transaction.DbTransaction;
import com.helha.myplanserver.infrastructure.transaction.ITransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GetAllTransactionHandler implements IQueryHandler<GetAllTransactionOutput> {
    private ITransactionRepository transactionRepository;
    private ModelMapper modelMapper;

    public GetAllTransactionHandler(ITransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public GetAllTransactionOutput handle() {
        Iterable<DbTransaction> dbTransactions;
        GetAllTransactionOutput output = new GetAllTransactionOutput();

        dbTransactions = transactionRepository.findAll();

        for (DbTransaction entity : dbTransactions) {
            output.transactions.add(modelMapper.map(entity, GetAllTransactionOutput.Transaction.class));
        }
        return output;
    }
}
