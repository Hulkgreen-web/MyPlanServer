package com.helha.myplanserver.application.category.query.getall;

import com.helha.myplanserver.application.utils.IQueryHandler;
import com.helha.myplanserver.infrastructure.category.DbCategory;
import com.helha.myplanserver.infrastructure.category.ICategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GetAllCategoryHandler implements IQueryHandler<GetAllCategoryOutput> {
    private final ICategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public GetAllCategoryHandler(ICategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public GetAllCategoryOutput handle() {
        Iterable< DbCategory> dbCategories;
        GetAllCategoryOutput output = new GetAllCategoryOutput();

        dbCategories = categoryRepository.findAll();

        for (DbCategory entity : dbCategories) {
            output.categories.add(modelMapper.map(entity, GetAllCategoryOutput.Category.class));
        }
        return output;
    }
}
