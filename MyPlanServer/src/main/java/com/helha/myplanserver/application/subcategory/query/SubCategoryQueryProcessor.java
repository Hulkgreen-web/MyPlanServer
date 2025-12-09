package com.helha.myplanserver.application.subcategory.query;

import com.helha.myplanserver.application.subcategory.query.getsubcategorybycatidandsubid.GetSubCategoryByCatIdAndSubIdHandler;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryQueryProcessor {
    public final GetSubCategoryByCatIdAndSubIdHandler getCategoryByIdHandler;

    public SubCategoryQueryProcessor(GetSubCategoryByCatIdAndSubIdHandler getSubCategoryByCatIdAndSubIdHandler) {
        this.getCategoryByIdHandler = getSubCategoryByCatIdAndSubIdHandler;
    }
}
