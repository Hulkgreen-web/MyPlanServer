package com.helha.myplanserver.application.subcategory.query.getall;

import com.helha.myplanserver.domain.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class GetAllSubCategoryOutput {
    public List<SubCategory> subCategories = new ArrayList<>();

    public static class SubCategory{
        public long id;
        public String name;
        public long category_id;
    }


}
