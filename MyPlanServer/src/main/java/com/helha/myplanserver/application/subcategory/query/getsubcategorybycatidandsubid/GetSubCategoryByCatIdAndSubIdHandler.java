package com.helha.myplanserver.application.subcategory.query.getsubcategorybycatidandsubid;

import com.helha.myplanserver.application.utils.IQueryWithMultipleInputsHandler;
import com.helha.myplanserver.infrastructure.subcategory.DbSubCategory;
import com.helha.myplanserver.infrastructure.subcategory.ISubCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetSubCategoryByCatIdAndSubIdHandler implements IQueryWithMultipleInputsHandler<Long, GetSubCategoryByCatIdAndSubIdOuput> {
    private ISubCategoryRepository subCategoryRepository;
    private ModelMapper modelMapper;

    public GetSubCategoryByCatIdAndSubIdHandler(ISubCategoryRepository subCategoryRepository, ModelMapper modelMapper) {
        this.subCategoryRepository = subCategoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public GetSubCategoryByCatIdAndSubIdOuput handle(Long catId, Long subCatId) {
        Iterable<DbSubCategory> dbSubCategories;
        Optional<DbSubCategory> entity;

        dbSubCategories = subCategoryRepository.findAll();

        for (DbSubCategory dbSubCategory : dbSubCategories) {
            if (dbSubCategory.category_id == catId && dbSubCategory.id == subCatId) {
                return modelMapper.map(dbSubCategory, GetSubCategoryByCatIdAndSubIdOuput.class);
            }
        }

        throw new IllegalArgumentException("Subcategory with id " + subCatId + " not found");
    }
}
