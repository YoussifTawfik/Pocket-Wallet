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
        UserModel model=new UserModel();
        model.setFirstName(userEntity.getFirstName());
        model.setLastName(userEntity.getLastName());
        model.setEmail(userEntity.getEmail());
        model.setPhone(userEntity.getPhone());
        model.setCategory(userEntity.getUserCategory().getCode());
        return model;
    }

}
