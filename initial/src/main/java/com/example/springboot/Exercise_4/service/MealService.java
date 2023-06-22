package com.example.springboot.Exercise_4.service;

import com.example.springboot.Exercise_2.Meal;
import com.example.springboot.Exercise_4.DAO.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class MealService {
    public List<Meal> getMealList() {
        return mealDao.getMeals();
    }
    private MealDao mealDao;

    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }
    public void addMeal(Meal meal) {
        mealDao.addMeal(meal);
    }
    public void deleteMeal(String mealName){
        mealDao.removeMeal(mealName);
    }
    public void updateMeal(Meal meal){
        mealDao.updateMeal(meal);
    }

}
