package com.helha.myplanserver.application.subcategory.query.getall;

import com.helha.myplanserver.application.utils.IQueryHandler;
import com.helha.myplanserver.infrastructure.subcategory.DbSubCategory;
import com.helha.myplanserver.infrastructure.subcategory.ISubCategoryRepository;
import org.modelmapper.ModelMapper;

public class GetAllSubCategoryHandler implements IQueryHandler<GetAllSubCategoryOutput> {
    private ISubCategoryRepository subCategoryRepository;
    private ModelMapper modelMapper;

    public GetAllSubCategoryHandler(ISubCategoryRepository subCategoryRepository, ModelMapper modelMapper) {
        this.subCategoryRepository = subCategoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public GetAllSubCategoryOutput handle() {
        Iterable<DbSubCategory> dbSubCategories;
        GetAllSubCategoryOutput output = new GetAllSubCategoryOutput();

        dbSubCategories = subCategoryRepository.findAll();

        for (DbSubCategory entity : dbSubCategories){
            output.subCategories.add(modelMapper.map(entity, GetAllSubCategoryOutput.SubCategory.class));
        }
        return output;

    }
}
