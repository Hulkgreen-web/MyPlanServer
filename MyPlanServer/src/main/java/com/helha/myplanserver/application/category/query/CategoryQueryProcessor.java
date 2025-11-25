package com.helha.myplanserver.application.category.query;

import com.helha.myplanserver.application.category.query.getall.GetAllCategoryHandler;
import com.helha.myplanserver.application.category.query.getallbyid.GetAllByIdHandler;
import org.springframework.stereotype.Service;

@Service
public class CategoryQueryProcessor {
    public final GetAllCategoryHandler getAllCategoryHandler;
    public final GetAllByIdHandler getAllByIdHandler;

    public CategoryQueryProcessor(GetAllCategoryHandler getAllCategoryHandler, GetAllByIdHandler getAllByIdHandler) {
        this.getAllCategoryHandler = getAllCategoryHandler;
        this.getAllByIdHandler = getAllByIdHandler;
    }
}
