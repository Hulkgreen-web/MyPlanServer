package com.helha.myplanserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubCategory {
    private long id;
    private String name;
    private long category_id;
}
