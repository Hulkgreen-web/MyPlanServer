package com.helha.myplanserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Category {
    private long id;
    private String name;
    private long estimatedAmount;
}
