package com.mantvydas.restaurant.mapper;

import com.mantvydas.restaurant.model.Meal;
import com.mantvydas.restaurant.rest.dto.MealDto;

public class MealMapper {

    public static Meal mealDtoToMeal (MealDto mealDto) {
        return new Meal(mealDto.getMealCategory(),
                        mealDto.getName(),
                        mealDto.getDescription(),
                        mealDto.getQuantity(),
                        mealDto.getPrice());
    }
//Arrays.stream(MealCategory.values()).filter(mealCategory -> mealCategory.getName().equals(mealDto.getMealCategory())).findFirst().orElse
}
