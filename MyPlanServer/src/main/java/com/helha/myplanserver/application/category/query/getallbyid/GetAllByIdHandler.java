package com.helha.myplanserver.application.category.query.getallbyid;

import com.helha.myplanserver.application.utils.IQuerySubCategoryHandler;
import com.helha.myplanserver.infrastructure.subcategory.DbSubCategory;
import com.helha.myplanserver.infrastructure.subcategory.ISubCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GetAllByIdHandler implements IQuerySubCategoryHandler<GetAllByIdOutput> {
    private ISubCategoryRepository subCategoryRepository;
    private ModelMapper modelMapper;

    public GetAllByIdHandler(ISubCategoryRepository subCategoryRepository, ModelMapper modelMapper) {
        this.subCategoryRepository = subCategoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public GetAllByIdOutput handle(long category_id) {
        Iterable<DbSubCategory> dbSubCategories;
        GetAllByIdOutput output = new GetAllByIdOutput();

        dbSubCategories = subCategoryRepository.findAll();

        for (DbSubCategory entity : dbSubCategories) {
            if (entity.category_id == category_id) {
                output.subCategories.add(modelMapper.map(entity, GetAllByIdOutput.SubCategory.class));
            }
        }
        return output;
    }
}
