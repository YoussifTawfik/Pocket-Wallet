package com.pocket.wallet.transfomers;

import com.pocket.wallet.dto.UserDto;
import com.pocket.wallet.models.UserModel;
import com.pocket.wallet.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer implements IParentTransformer<UserDto, UserModel, UserResponse> {

    @Override
    public UserModel transformRequest(UserDto request) {
        UserModel model=new UserModel();
        model.setFirstName(request.getFirstName());
        model.setLastName(request.getLastName());
        model.setPhone(request.getPhone());
        model.setPassword(request.getPassword());
        model.setCategory(request.getCategory());
        return model;
    }

    @Override
    public UserResponse transformResponse(UserModel model) {
        UserResponse response=new UserResponse();
        response.setFirstName(model.getFirstName());
        response.setLastName(model.getLastName());
        response.setPhone(model.getPhone());
        response.setPassword(model.getPassword());
        response.setCategory(model.getCategory());
        return response;
    }
}
