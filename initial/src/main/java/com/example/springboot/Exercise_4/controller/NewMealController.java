package com.example.springboot.Exercise_4.controller;

import com.example.springboot.Exercise_2.Meal;
import com.example.springboot.Exercise_4.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewMealController {
    private MealService mealService;

    @Autowired
    public NewMealController(MealService mealservice) {
        this.mealService = mealservice;
    }

    @GetMapping("/mealsList")
    public List<Meal> getMeals() {
        return mealService.getMealList();
    }

    @PostMapping("/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal newMeal) {
        mealService.addMeal(newMeal);
        return ResponseEntity.ok("New meal added");
    }

    @PutMapping("/put/meal/{name}")
    public ResponseEntity<String> updateMeal(@PathVariable String name, @RequestBody Meal updatedMeal) {
        for (Meal meal : mealService.getMealList()) {
            if (meal.getNameMeal().equals(name)) {
                meal.setNameMeal(updatedMeal.getNameMeal());
                meal.setDescriptionMeal(updatedMeal.getDescriptionMeal());
                meal.setPriceMeal(updatedMeal.getPriceMeal());
                return ResponseEntity.ok("Meal updated");
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/meal/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String name) {
        for (Meal meal : mealService.getMealList()) {
            if (meal.getNameMeal().equals(name)) {
                mealService.getMealList().remove(meal);
                return ResponseEntity.ok("Meal deleted");
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/meal/price/{price}")
    public ResponseEntity<String> deleteMealsAbovePrice(@PathVariable double price) {
        List<Meal> mealsToRemove = new ArrayList<>();
        for (Meal meal : mealService.getMealList()) {
            if (meal.getPriceMeal() > price) {
                mealsToRemove.add(meal);
            }
        }
        mealService.getMealList().removeAll(mealsToRemove);
        return ResponseEntity.ok("Meal to remove");
    }

    @PutMapping("/update/meal/{name}/price")
    public ResponseEntity<String> updateMealPrice(@PathVariable String name, @RequestBody Double updatedPrice) {
        for (Meal meal : mealService.getMealList()) {
            if (meal.getNameMeal().equals(name)) {
                meal.setPriceMeal(updatedPrice);
                return ResponseEntity.ok("Meal price updated");
            }
        }
        return ResponseEntity.notFound().build();

    }
}