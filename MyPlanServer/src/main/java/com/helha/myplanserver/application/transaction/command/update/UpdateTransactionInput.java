package com.helha.myplanserver.application.transaction.command.update;

import java.util.Date;

public class UpdateTransactionInput {
    public long id;
    public Date date_operation;
    public long montant_operation;
    public String type_operation;
    public long category_transaction_id;
    public long subcategory_transaction_id;
}
