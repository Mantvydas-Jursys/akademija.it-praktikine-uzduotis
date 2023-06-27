package com.mantvydas.restaurant.service;

import com.mantvydas.restaurant.model.Meal;

import java.util.List;

public interface MealService {

    Meal getMealByID(String mealID);

    List<Meal> getMealByNameFilter(String name);

    List<Meal> getAllMeals();

    List<String> getAllMealsCategories();

    boolean createMeal(Meal meal);

    void deleteMeal(String mealID);



}
