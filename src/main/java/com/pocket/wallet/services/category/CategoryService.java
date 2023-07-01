package com.pocket.wallet.services.category;

import com.pocket.wallet.entity.UserCategory;
import com.pocket.wallet.models.UserCategoryModel;
import com.pocket.wallet.repository.UserCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private final UserCategoryRepository userCategoryRepository;
    private final CategoryHelper categoryHelper;

    public UserCategoryModel addCategory(UserCategoryModel categoryModel){
        UserCategory category=categoryHelper.mapToEntity(categoryModel);
        category = userCategoryRepository.save(category);
        return categoryHelper.mapToModel(category);
    }

    public UserCategory getCategoryByCode(String code){
        return userCategoryRepository.getByCode(code);
    }
}
