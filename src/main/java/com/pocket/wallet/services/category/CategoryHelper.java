package com.pocket.wallet.services.category;

import com.pocket.wallet.entity.UserCategory;
import com.pocket.wallet.models.UserCategoryModel;
import com.pocket.wallet.services.IBasicHelper;
import org.springframework.stereotype.Component;

@Component
public class CategoryHelper implements IBasicHelper<UserCategory, UserCategoryModel> {


    @Override
    public UserCategory mapToEntity(UserCategoryModel model) {
       return UserCategory.builder()
                .code(model.getCode())
                .dailyDebitLimit(model.getDailyDebitLimit())
                .dailyCreditLimit(model.getDailyCreditLimit())
                .weeklyDebitLimit(model.getWeeklyDebitLimit())
                .weeklyCreditLimit(model.getWeeklyCreditLimit())
                .monthlyDebitLimit(model.getMonthlyDebitLimit())
                .monthlyCreditLimit(model.getMonthlyCreditLimit())
                .build();
    }

    @Override
    public UserCategoryModel mapToModel(UserCategory entity) {
        return UserCategoryModel.builder()
                .code(entity.getCode())
                .dailyDebitLimit(entity.getDailyDebitLimit())
                .dailyCreditLimit(entity.getDailyCreditLimit())
                .weeklyDebitLimit(entity.getWeeklyDebitLimit())
                .weeklyCreditLimit(entity.getWeeklyCreditLimit())
                .monthlyDebitLimit(entity.getMonthlyDebitLimit())
                .monthlyCreditLimit(entity.getMonthlyCreditLimit())
                .build();
    }
}
