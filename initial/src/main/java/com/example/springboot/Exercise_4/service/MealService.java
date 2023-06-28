package com.example.springboot.Exercise_4.service;

import com.example.springboot.Exercise_2.Meal;
import com.example.springboot.Exercise_4.DAO.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class MealService {

    private MealDao mealDao;

    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public List<Meal> getMealList() {
        return mealDao.getMeals();
    }

    public void addMeal(Meal meal) {
        if (meal == null) {
            throw new IllegalArgumentException("meal cannot be null");
        }
        mealDao.addMeal(meal);
    }

    public void updateMeal(String name, Meal updatedMeal) {
        Meal meal = getMealByName(name);
        if (meal != null) {
            meal.setNameMeal(updatedMeal.getNameMeal());
            meal.setDescriptionMeal(updatedMeal.getDescriptionMeal());
            meal.setPriceMeal(updatedMeal.getPriceMeal());
        }
    }


    public void deleteMeal(String name) {
        mealDao.removeMeal(name);
    }

    public void deleteMealsAbovePrice(double price) {
        List<Meal> mealsToRemove = new ArrayList<>();
        for (Meal meal : mealDao.getMeals()) {
            if (meal.getPriceMeal() > price) {
                mealsToRemove.add(meal);
            }
        }
        mealDao.getMeals().removeAll(mealsToRemove);
    }

    public void updateMealPrice(String name, double updatedPrice) {
        Meal existingMeal = getMealByName(name);
        if (existingMeal != null) {
            existingMeal.setPriceMeal(updatedPrice);
            mealDao.updateMeal(existingMeal);
        }
    }

    private Meal getMealByName(String name) {
        for (Meal meal : mealDao.getMeals()) {
            if (meal.getNameMeal().equals(name)) {
                return meal;
            }
        }
        return null;
    }
}
