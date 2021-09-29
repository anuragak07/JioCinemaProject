package com.masai.jiocinmea.model;

public class AllCategory {
    private  String CategoryTitle;
     private Integer CategoryId;

    public AllCategory( Integer categoryId,String categoryTitle) {
        CategoryTitle = categoryTitle;
        CategoryId = categoryId;
    }

    public String getCategoryTitle() {
        return CategoryTitle;
    }

    public Integer getCategoryId() {
        return CategoryId;
    }
}
