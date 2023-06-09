package com.example.springboot.Exercise_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MealRequest {
    /**
     * Exercise 1: Create a GetMapping that returns a list of meals
     * <p>
     * 1 - Annotate a new class with the @RestController annotation.
     * 2 - Create a new endpoint "/meals" using the @GetMapping annotation.
     * 3 - In the method, return a list of Meal objects.
     */

    @GetMapping("/meals")
    public List<Meal> getMeals() {
        return Meal.mealList();
    }

    /**
     * Exercise 2: Create a GetMapping that returns a meal by name
     *
     * 1 - Annotate a new class with the @RestController annotation.
     * 2 - Create a new endpoint "/meal/{name}" using the @GetMapping annotation.
     * 3 - In the method, add a query parameter "name" using the @PathVariable annotation.
     * 4 - Return a Meal object with the corresponding name.
     */

    @GetMapping("/meal/{name}") //* Sostituisci -> /{name} con -> "/Spagetti alla carbonara" o un'altra pietanza che trovi nella calasse Meal.
    public Meal getMealByName(@PathVariable("name") String name) {
        Meal.mealList();
        for (Meal meal : Meal.mealList()) {
            if (meal.getNameMeal().equalsIgnoreCase(name)) {  //* equalsIgnoreCase = ingora differenze di carattere
                return meal;
            }
        }
        return null;
    }

    /**
     * Exercise 3: Create a GetMapping that returns a meal by any word of description
     *
     * 1 - Annotate a new class with the @RestController annotation.
     * 2 - Create a new endpoint "/meal/description-match/{phrase}" using the @GetMapping annotation.
     * 3 - In the method, add a query parameter "description" using the @PathVariable annotation.
     * 4 - Return a Meal object with the corresponding description.
     */

    @GetMapping("/meal/description-match/{phrase}") //* Sostituisci -> /{pharse} con -> "/pollo" o un'altra descrizione che trovi nella calasse Meal.
    public Meal getMealByDescription(@PathVariable("phrase") String phrase) {
        Meal.mealList();
        for (Meal meal : Meal.mealList()) {
            if (meal.getDescriptionMeal().toLowerCase().contains(phrase.toLowerCase())) {
                return meal;
            }
        }
        return null;
    }

    /**
     * Exercise 4: Create a GetMapping that returns a meal by price range
     *
     * 1 - Annotate a new class with the @RestController annotation.
     * 2 - Create a new endpoint "/meal/price" using the @GetMapping annotation.
     * 3 - In the method, add two query parameters "min" and "max" using the @RequestParam annotation.
     * 4 - Return a list of Meal objects with prices within the specified range.
     */

    @GetMapping("/meal/price") //* Inserire in Postman -> /meal/price?min=10.00&max=20.00
    public List<Meal> getMealsByPriceRange(@RequestParam("min") double minPrice, @RequestParam("max") double maxPrice) {
        Meal.mealList();
        List<Meal> mealsInRange = new ArrayList<>();
        for (Meal meal : Meal.mealList()) {
            if (meal.getPriceMeal() >= minPrice && meal.getPriceMeal() <= maxPrice) {
                mealsInRange.add(meal);
            }
        }
        return mealsInRange;
    }
}
