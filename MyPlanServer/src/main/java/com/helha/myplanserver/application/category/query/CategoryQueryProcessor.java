package com.helha.myplanserver.application.category.query;

import com.helha.myplanserver.application.category.query.getall.GetAllCategoryHandler;
import org.springframework.stereotype.Service;

@Service
public class CategoryQueryProcessor {
    public final GetAllCategoryHandler getAllCategoryHandler;

    public CategoryQueryProcessor(GetAllCategoryHandler getAllCategoryHandler) {
        this.getAllCategoryHandler = getAllCategoryHandler;
    }
}
