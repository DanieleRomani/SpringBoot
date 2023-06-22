package com.example.springboot.Exercise_4.DAO;

import com.example.springboot.Exercise_2.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealDao {
    ArrayList<Meal> meals = new ArrayList<>();
    public void MealDao() {
        meals.add(new Meal("Spaghetti alla carbonara", "spaghetti, uova, pancetta, pecorino", 12.00));
        meals.add(new Meal("Pizza Margherita", "Pomodoro, Mozzarella", 8.00));
        meals.add(new Meal("Insalata di pollo", "insalata, maionese, pollo", 15.00));
    }

    public void addMeal (Meal meal) {
        this.meals.add(meal);
    }

    public void removeMeal (String nameMeal) {
        this.meals.removeIf(meal -> meal.getNameMeal().equals(nameMeal));
    }

    public void updateMeal (Meal meal) {
        this.meals.removeIf(m -> m.getNameMeal().equals(meal.getNameMeal()));
        this.meals.add(meal);
    }

    public List<Meal> getMeals () {
        return this.meals;
    }


}




