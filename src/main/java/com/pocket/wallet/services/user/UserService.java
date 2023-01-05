package com.pocket.wallet.services.user;

import com.pocket.wallet.entities.UserCategory;
import com.pocket.wallet.entities.UserEntity;
import com.pocket.wallet.exceptions.UserCategoryNotFound;
import com.pocket.wallet.models.UserModel;
import com.pocket.wallet.repositories.IWalletRepository;
import com.pocket.wallet.repositories.UserRepository;
import com.pocket.wallet.response.IBasicResponse;
import com.pocket.wallet.response.UserResponse;
import com.pocket.wallet.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final IWalletRepository<UserEntity> userRepository;
    private final CategoryService categoryService;
    private final UserHelper userHelper;

    public UserService(@Qualifier("USER") UserRepository userRepository, CategoryService categoryService,
                       UserHelper userHelper){
        this.userRepository=userRepository;
        this.categoryService=categoryService;
        this.userHelper=userHelper;
    }

    public UserModel addUser(UserModel userModel) {
        UserEntity user= userHelper.mapToEntity(userModel);
        UserCategory userCategory=categoryService.getCategoryByCode(userModel.getCategory());
        if (userCategory==null) throw new UserCategoryNotFound();
        user.setUserCategory(userCategory);
        userRepository.save(user);
        return userModel;
    }

}
