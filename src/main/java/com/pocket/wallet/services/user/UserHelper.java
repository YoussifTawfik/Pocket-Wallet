package com.pocket.wallet.services.user;

import com.pocket.wallet.dto.UserDto;
import com.pocket.wallet.entity.UserEntity;
import com.pocket.wallet.models.UserModel;
import com.pocket.wallet.services.IBasicHelper;
import org.springframework.stereotype.Component;

@Component
public class UserHelper implements IBasicHelper<UserEntity, UserModel> {

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

    public UserEntity mapToEntity(UserDto userDto){
        UserEntity userEntity=new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPhone(userDto.getPhone());
        userEntity.setPassword(userDto.getPassword());
        return userEntity;
    }

}
