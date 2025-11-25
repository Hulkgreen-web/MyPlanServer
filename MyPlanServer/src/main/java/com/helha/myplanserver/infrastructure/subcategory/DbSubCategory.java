package com.helha.myplanserver.infrastructure.subcategory;

import jakarta.persistence.*;

@Entity
@Table(name = "subcategory")
public class DbSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public long category_id;
}
