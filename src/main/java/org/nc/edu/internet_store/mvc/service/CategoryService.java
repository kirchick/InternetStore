package org.nc.edu.internet_store.mvc.service;

import org.nc.edu.internet_store.mvc.domain.Category;
import java.util.List;

public interface CategoryService {
    public void addCategory(Category category);

    public List<Category> listCategory();

    public void removeCategory(Integer id);
}
