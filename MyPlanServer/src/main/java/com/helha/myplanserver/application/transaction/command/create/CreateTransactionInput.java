package com.helha.myplanserver.application.transaction.command.create;

import java.util.Date;

public class CreateTransactionInput {
    public Date date_operation;
    public long montant_operation;
    public String type_operation;
    public long category_transaction_id;
    public long subcategory_transaction_id;
}
