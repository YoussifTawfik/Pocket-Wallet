package com.pocket.wallet.services.user;

import com.pocket.wallet.dto.UserDto;
import com.pocket.wallet.entity.UserCategory;
import com.pocket.wallet.entity.UserEntity;
import com.pocket.wallet.exceptions.UserCategoryNotFound;
import com.pocket.wallet.models.UserModel;
import com.pocket.wallet.repository.UserRepository;
import com.pocket.wallet.services.category.CategoryService;
import com.pocket.wallet.utilities.AESCipher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private AESCipher aesCipher;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CategoryService categoryService;
    @Mock
    private UserHelper userHelper;
    @InjectMocks
    private UserService userService;

    private UserModel userModel;
    private UserEntity userEntity;
    private UserCategory userCategory;

    private UserDto userDto;

    @BeforeEach
    private void init(){
        userModel=UserModel.builder()
                .firstName("Test")
                .lastName("Test")
                .email("test@gmail.com")
                .phone("0152336652")
                .password("Hello")
                .category("VIP").build();

        userEntity=new UserEntity();
        userEntity.setFirstName("Test");
        userEntity.setLastName("Test");
        userEntity.setEmail("test@gmail.com");
        userEntity.setPhone("0152336652");
        userEntity.setPassword("Hello");

        userCategory=UserCategory.builder()
                .code("VIP")
                .dailyDebitLimit(1000.0).dailyCreditLimit(2000.0).build();

        userDto=new UserDto();
        userDto.setFirstName("Test");
        userDto.setLastName("Test");
        userDto.setEmail("test@gmail.com");
        userDto.setPhone("0152336652");
        userDto.setPassword("Hello");
        userDto.setCategory("VIP");

    }


    @DisplayName("Service: Add User Test")
    @Test
    public void givenUserModel_whenAddUser_thenReturnSavedObject() throws Exception {
        // given
        BDDMockito.given(aesCipher.encrypt(userModel.getPassword())).willReturn("Password");
        BDDMockito.given(userHelper.mapToEntity(userDto)).willReturn(userEntity);
        BDDMockito.given(userHelper.mapToModel(userEntity)).willReturn(userModel);
        BDDMockito.given(categoryService.getCategoryByCode(userModel.getCategory())).willReturn(userCategory);
        // when
        UserModel responseUserModel=userService.addUser(userDto);
        // then
        BDDMockito.verify(userRepository, Mockito.times(1))
                .save(Mockito.any(UserEntity.class));
        Assertions.assertThat(responseUserModel).isNotNull();
    }

    @DisplayName("Service: Add User Test - Throw Exception")
    @Test
    public void givenUserModel_whenAddUser_thenThrowsCategoryNotFound() throws Exception {
        // given
        BDDMockito.given(aesCipher.encrypt(userModel.getPassword())).willReturn("Password");
        BDDMockito.given(userHelper.mapToEntity(userDto)).willReturn(userEntity);
        BDDMockito.given(categoryService.getCategoryByCode(userModel.getCategory())).willReturn(null);
        // when
        org.junit.jupiter.api.Assertions.assertThrows(UserCategoryNotFound.class, ()-> userService.addUser(userDto));
        // then
        BDDMockito.verify(userRepository,Mockito.never()).save(userEntity);
    }

}