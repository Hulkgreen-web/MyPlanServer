package com.helha.myplanserver.infrastructure.category;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class DbCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public long estimatedAmount;
}
