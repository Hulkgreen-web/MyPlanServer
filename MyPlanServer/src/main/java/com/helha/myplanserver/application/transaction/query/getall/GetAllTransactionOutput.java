package com.helha.myplanserver.application.transaction.query.getall;

import com.helha.myplanserver.domain.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetAllTransactionOutput {
    public List<Transaction> transactions = new ArrayList<>();

    public static class Transaction{
        public long id;
        public Date date_operation;
        public long montant_operation;
        public String type_operation;
        public long category_transaction_id;
        public long subcategory_transaction_id;
    }
}
