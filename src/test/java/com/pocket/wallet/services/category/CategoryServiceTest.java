package com.pocket.wallet.services.category;

import com.pocket.wallet.entities.UserCategory;
import com.pocket.wallet.repositories.UserCategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private UserCategoryRepository userCategoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private UserCategory userCategory;


    @BeforeEach
    public void init(){
        userCategory=UserCategory.builder()
                .code("TEST")
                .dailyDebitLimit(1000.0).dailyCreditLimit(2000.0).build();
    }

    @DisplayName("Service: GetByCode Test")
    @Test
    void givenCode_whenGetByCode_thenReturnEntity() {
        // given
        BDDMockito.given(userCategoryRepository.getByCode(userCategory.getCode())).willReturn(userCategory);
        // when
        UserCategory savedCategory=categoryService.getCategoryByCode(userCategory.getCode());
        // then
        Assertions.assertThat(savedCategory).isNotNull();

    }
}