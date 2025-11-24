package com.helha.myplanserver.application.category.query.getall;

import java.util.ArrayList;
import java.util.List;

public class GetAllCategoryOutput {
    public List<Category> categories = new ArrayList<>();

    public static class Category {
        public long id;
        public String name;
        public long estimatedAmount;
    }
}
