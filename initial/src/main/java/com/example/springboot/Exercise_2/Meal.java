package com.example.springboot.Exercise_2;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private String nameMeal;
    private String descriptionMeal;
    private double priceMeal;

    public Meal(String nameMeal, String descriptionMeal, double priceMeal) {
        this.nameMeal = nameMeal;
        this.descriptionMeal = descriptionMeal;
        this.priceMeal = priceMeal;
    }

    public String getNameMeal() {
        return nameMeal;
    }

    public void setNameMeal(String nameMeal) {
        this.nameMeal = nameMeal;
    }

    public String getDescriptionMeal() {
        return descriptionMeal;
    }

    public void setDescriptionMeal(String descriptionMeal) {
        this.descriptionMeal = descriptionMeal;
    }

    public double getPriceMeal() {
        return priceMeal;
    }

    public void setPriceMeal(double priceMeal) {
        this.priceMeal = priceMeal;
    }


    public static List<Meal> mealList() {
        ArrayList <Meal> meals = new ArrayList<>();
        meals.add(new Meal("Spaghetti alla carbonara", "spaghetti, uova, pancetta, pecorino", 12.00));
        meals.add(new Meal("Pizza Margherita", "Pomodoro, Mozzarella", 8.00));
        meals.add(new Meal("Insalata di pollo", "insalata, maionese, pollo", 15.00));
        return meals;
    }
}

