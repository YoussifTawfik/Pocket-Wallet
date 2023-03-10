package com.pocket.wallet.services.user;

import com.pocket.wallet.entities.UserEntity;
import com.pocket.wallet.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {

    public UserEntity mapToEntity(UserModel model){
        UserEntity userEntity=new UserEntity();
        userEntity.setFirstName(model.getFirstName());
        userEntity.setLastName(model.getLastName());
        userEntity.setEmail(model.getEmail());
        userEntity.setPhone(model.getPhone());
        userEntity.setPassword(model.getPassword());
        return userEntity;
    }

    public UserModel mapToModel(UserEntity userEntity){
        return UserModel.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .category(userEntity.getUserCategory().getCode()).build();
    }

}
