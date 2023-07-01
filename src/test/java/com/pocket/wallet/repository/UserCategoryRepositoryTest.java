package com.pocket.wallet.repository;

import com.pocket.wallet.entity.UserCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserCategoryRepositoryTest {

    @Autowired
    private UserCategoryRepository userCategoryRepository;

    private UserCategory userCategory;

    @BeforeEach
    public void init(){
        userCategory=UserCategory.builder()
                .code("TEST")
                .dailyDebitLimit(1000.0).dailyCreditLimit(2000.0).build();
    }

    @DisplayName("Save category test")
    @Test
    public void givenCategory_whenSaving_thenReturnSavedObject(){
        // given

        //when
        UserCategory savedCategory=userCategoryRepository.save(userCategory);
        // then
        Assertions.assertThat(savedCategory).isNotNull();
        Assertions.assertThat(savedCategory.getId()).isGreaterThan(0);
    }

    @DisplayName("getByCode Test")
    @Test
    public void givenCategoryCode_whenGetByCode_thenReturnCategoryEntity(){
        // given
        userCategoryRepository.save(userCategory);
        // when
        UserCategory savedCategory=userCategoryRepository.getByCode(userCategory.getCode());
        // then
        Assertions.assertThat(savedCategory).isNotNull();
        Assertions.assertThat(savedCategory.getDailyDebitLimit()).isEqualTo(1000.0);
    }


}