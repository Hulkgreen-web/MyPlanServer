package com.helha.myplanserver.infrastructure.transaction;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaction")
public class DbTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public Date date_operation;
    public long montant_operation;
    public String type_operation;
    public long category_transaction_id;
    public long subcategory_transaction_id;

}
