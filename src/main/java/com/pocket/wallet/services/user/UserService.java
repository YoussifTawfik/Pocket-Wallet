package com.pocket.wallet.services.user;

import com.pocket.wallet.dto.UserDto;
import com.pocket.wallet.entity.UserCategory;
import com.pocket.wallet.entity.UserEntity;
import com.pocket.wallet.exceptions.UserCategoryNotFound;
import com.pocket.wallet.models.UserModel;
import com.pocket.wallet.repository.UserRepository;
import com.pocket.wallet.services.category.CategoryService;
import com.pocket.wallet.utilities.AESCipher;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
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
    private final PasswordEncoder passwordEncoder;

    public UserEntity getUserById(Long id){
        return userRepository.getById(id);
    }

    public UserEntity getUserByEmail(String email){
        return userRepository.getByEmail(email);
    }


    public UserModel addUser(UserDto userDto) throws Exception {
        UserEntity user= userHelper.mapToEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserCategory userCategory=categoryService.getCategoryByCode(userDto.getCategory());
        if (userCategory==null) throw new UserCategoryNotFound();
        user.setUserCategory(userCategory);
        userRepository.save(user);
        return userHelper.mapToModel(user);
    }

    public List<UserModel> getAllUsers(int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<UserEntity> userEntityList=userRepository.findAll(pageable);
        return userEntityList.getContent().stream().map(userHelper::mapToModel).collect(Collectors.toList());
    }

}
