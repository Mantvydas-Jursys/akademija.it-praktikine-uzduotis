package com.mantvydas.restaurant.rest;

import com.mantvydas.restaurant.mapper.MealMapper;
import com.mantvydas.restaurant.mapper.MenuMapper;
import com.mantvydas.restaurant.model.Meal;
import com.mantvydas.restaurant.model.MealCategory;
import com.mantvydas.restaurant.model.Menu;
import com.mantvydas.restaurant.rest.dto.MealDto;
import com.mantvydas.restaurant.rest.dto.MenuDto;
import com.mantvydas.restaurant.service.MealService;
import com.mantvydas.restaurant.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

import static com.mantvydas.restaurant.config.SwaggerConfig.BEARER_KEY_SECURITY_SCHEME;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/meal")
public class MealController {

    private final MealService mealService;

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping("/get-meals-filtered/{nameFilter}")
    public ResponseEntity<List<Meal>> getMealByNameFilter (@PathVariable String nameFilter) {
        return ResponseEntity.ok(mealService.getMealByNameFilter(nameFilter));
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping("/get-meals")
    public ResponseEntity<List<Meal>> getAllMeals () {
        return ResponseEntity.ok(mealService.getAllMeals());
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping("/get-meal-categories")
    public ResponseEntity<List<String>> getAllMealCategories () {
        return ResponseEntity.ok(mealService.getAllMealsCategories());
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @PostMapping("/create-meal")
    public void createMeal (@RequestBody MealDto mealDtoToCreate) {
        mealService.createMeal(MealMapper.mealDtoToMeal(mealDtoToCreate));
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @DeleteMapping("/delete-meal/{mealID}")
    public void deleteMeal (@PathVariable String mealID) {
        mealService.deleteMeal(mealID);
    }
}

