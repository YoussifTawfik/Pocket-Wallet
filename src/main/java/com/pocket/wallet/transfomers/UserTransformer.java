package com.pocket.wallet.transfomers;

import com.pocket.wallet.dto.UserDto;
import com.pocket.wallet.models.UserModel;
import com.pocket.wallet.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer implements IParentTransformer<UserDto, UserModel, UserResponse> {

    @Override
    public UserModel transformRequest(UserDto request) {
        return UserModel.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .category(request.getCategory()).build();
    }

    @Override
    public UserResponse transformResponse(UserModel model) {
        return UserResponse.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .email(model.getEmail())
                .phone(model.getPhone())
                .category(model.getCategory()).build();
    }

}
