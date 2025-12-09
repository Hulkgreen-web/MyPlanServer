package com.helha.myplanserver.application.category.query;

import com.helha.myplanserver.application.category.query.getall.GetAllCategoryHandler;
import com.helha.myplanserver.application.category.query.getallbyid.GetAllByIdHandler;
import com.helha.myplanserver.application.category.query.getbyid.GetCategoryByIdHandler;
import org.springframework.stereotype.Service;

@Service
public class CategoryQueryProcessor {
    public final GetAllCategoryHandler getAllCategoryHandler;
    public final GetAllByIdHandler getAllByIdHandler;
    public final GetCategoryByIdHandler getCategoryByIdHandler;

    public CategoryQueryProcessor(GetAllCategoryHandler getAllCategoryHandler, GetAllByIdHandler getAllByIdHandler, GetCategoryByIdHandler getCategoryByIdHandler) {
        this.getAllCategoryHandler = getAllCategoryHandler;
        this.getAllByIdHandler = getAllByIdHandler;
        this.getCategoryByIdHandler = getCategoryByIdHandler;
    }
}
