package com.pocket.wallet.services.user;

import com.pocket.wallet.entities.UserCategory;
import com.pocket.wallet.entities.UserEntity;
import com.pocket.wallet.exceptions.UserCategoryNotFound;
import com.pocket.wallet.models.UserModel;
import com.pocket.wallet.repositories.UserRepository;
import com.pocket.wallet.services.category.CategoryService;
import com.pocket.wallet.utilities.AESCipher;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CategoryService categoryService;
    private final UserHelper userHelper;
    private final AESCipher aesCipher;


    public UserModel addUser(UserModel userModel) throws Exception {
        userModel.setPassword(aesCipher.encrypt(userModel.getPassword()));
        UserEntity user= userHelper.mapToEntity(userModel);
        UserCategory userCategory=categoryService.getCategoryByCode(userModel.getCategory());
        if (userCategory==null) throw new UserCategoryNotFound();
        user.setUserCategory(userCategory);
        userRepository.save(user);
        return userModel;
    }

    public List<UserModel> getAllUsers(int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<UserEntity> userEntityList=userRepository.findAll(pageable);
        return userEntityList.getContent().stream().map(userHelper::mapToModel).collect(Collectors.toList());
    }

}
