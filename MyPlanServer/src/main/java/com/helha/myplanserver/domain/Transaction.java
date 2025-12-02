package com.helha.myplanserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Transaction {
    private long id;
    private Date date_operation;
    private long montant_operation;
    private String type_operation;
    private long category_transaction_id;
    private long subcategory_transaction_id;
}
