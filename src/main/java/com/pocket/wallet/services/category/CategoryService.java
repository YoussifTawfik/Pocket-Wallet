package com.pocket.wallet.services.category;

import com.pocket.wallet.entities.UserCategory;
import com.pocket.wallet.repositories.UserCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final UserCategoryRepository userCategoryRepository;

    public CategoryService(UserCategoryRepository userCategoryRepository){
        this.userCategoryRepository=userCategoryRepository;
    }

    public UserCategory getCategoryByCode(String code){
        return userCategoryRepository.getByCode(code);
    }
}
