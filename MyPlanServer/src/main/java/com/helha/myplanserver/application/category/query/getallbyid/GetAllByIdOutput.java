package com.helha.myplanserver.application.category.query.getallbyid;


import com.helha.myplanserver.domain.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class GetAllByIdOutput {
    public List<SubCategory> subCategories = new ArrayList<SubCategory>();

    public static class SubCategory {
        public long id;
        public String name;
        public long category_id;
    }
}
