package com.pocket.wallet.services.user;

import com.pocket.wallet.dto.AddUserDto;
import com.pocket.wallet.entities.User;
import com.pocket.wallet.entities.UserCategory;
import com.pocket.wallet.exceptions.UserCategoryNotFound;
import com.pocket.wallet.repositories.UserCategoryRepository;
import com.pocket.wallet.repositories.UserRepository;
import com.pocket.wallet.repositories.IWalletRepository;
import com.pocket.wallet.response.AddUserResponse;
import com.pocket.wallet.response.IBasicResponse;
import com.pocket.wallet.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final IWalletRepository<User> userRepository;
    private final CategoryService categoryService;

    public UserService(@Qualifier("USER") UserRepository userRepository, CategoryService categoryService){
        this.userRepository=userRepository;
        this.categoryService=categoryService;
    }

    public IBasicResponse addUser(AddUserDto userDto) {
        User user=new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        UserCategory userCategory=categoryService.getCategoryByCode(userDto.getCategory());
        if (userCategory==null) throw new UserCategoryNotFound();
        user.setUserCategory(userCategory);
        userRepository.save(user);
        AddUserResponse response=new AddUserResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setPhone(user.getPhone());
        response.setPassword(user.getPassword());
        response.setCategory(user.getUserCategory()!=null? userCategory.getCode():"NORM");
        return response;
    }

}
