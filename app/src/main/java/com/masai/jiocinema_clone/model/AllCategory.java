package com.masai.jiocinema_clone.model;

import java.util.List;

public class AllCategory {
    private  String CategoryTitle;
     private Integer CategoryId;
     private List<CategoryItem> categoryItemList = null;

    public AllCategory(Integer categoryId,String categoryTitle, List<CategoryItem> categoryItemList) {
        CategoryTitle = categoryTitle;
        CategoryId = categoryId;
        this.categoryItemList = categoryItemList;
    }

    public String getCategoryTitle() {
        return CategoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        CategoryTitle = categoryTitle;
    }

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }

    public List<CategoryItem> getCategoryItemList() {
        return categoryItemList;
    }

    public void setCategoryItemList(List<CategoryItem> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }
}
