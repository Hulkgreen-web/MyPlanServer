package com.helha.myplanserver.application.category.query.getbyid;

import com.helha.myplanserver.application.utils.IQueryWithInputHandler;
import com.helha.myplanserver.infrastructure.category.DbCategory;
import com.helha.myplanserver.infrastructure.category.ICategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCategoryByIdHandler implements IQueryWithInputHandler<Long, GetCategoryByIdOutput> {
    private ICategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public GetCategoryByIdHandler(ICategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public GetCategoryByIdOutput handle(Long input) {
        Optional<DbCategory> entity = categoryRepository.findById(input);

        if (entity.isPresent()) {
            return modelMapper.map(entity.get(), GetCategoryByIdOutput.class);
        }

        throw new IllegalArgumentException("Category not found");
    }
}
