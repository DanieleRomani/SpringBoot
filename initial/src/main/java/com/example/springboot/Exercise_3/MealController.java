package com.example.springboot.Exercise_3;

import com.example.springboot.Exercise_2.Meal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MealController {

    /**
     * Exercise 1: Create a PutMapping to add a new meal
     * <p>
     * 1 - Create a new endpoint "/meal" using the @PostMapping annotation.
     * 2 - In the method, add a RequestBody for the new Meal object.
     * 3 - Add the new meal to the list of meals.
     */

    private List<Meal> meals = new ArrayList<>();

    @GetMapping("/mealsList")
    /** Metodo per verificare la lista in Postman*/
    public List<Meal> getMeals() {
        return meals;
    }

    @PostMapping("/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal newMeal) {
        meals.add(newMeal);
        return ResponseEntity.ok("New meal added");
    }

    /** @PostConstruct // per aggiungere direttamente alla tabella DB meal il nuovo meal
    public void addDefaultMeal() {
    Meal pastaAlPesto = new Meal("Pasta al pesto", "Basilico, pinoli, grana", 12.00);
    meals.add(pastaAlPesto);
    }*/


    /**
     * Exercise 2: Create a PostMapping to update a meal by name
     * <p>
     * 1 - Create a new endpoint "/meal/{name}" using the @PutMapping annotation.
     * 2 - In the method, add a PathVariable for the name and a RequestBody for the updated Meal object.
     * 3 - Update the meal with the corresponding name using the information from the RequestBody.
     */

    @PutMapping("/meal/{name}")  //
    public ResponseEntity<String> updateMeal(@PathVariable String name, @RequestBody Meal updatedMeal) {
        for (Meal meal : meals) {
            if (meal.getNameMeal().equals(name)) {
                meal.setNameMeal(updatedMeal.getNameMeal());
                meal.setDescriptionMeal(updatedMeal.getDescriptionMeal());
                meal.setPriceMeal(updatedMeal.getPriceMeal());
                return ResponseEntity.ok("Meal updated");
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Exercise 3: Create a DeleteMapping to delete a meal by name
     * <p>
     * 1 - Create a new endpoint "/meal/{name}" using the @DeleteMapping annotation.
     * 2 - In the method, add a PathVariable for the name.
     * 3 - Delete the meal with the corresponding name.
     */

    @DeleteMapping("/meal/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String name) {
        for (Meal meal : meals) {
            if (meal.getNameMeal().equals(name)) {
                meals.remove(meal);
                return ResponseEntity.ok("Meal deleted");
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Exercise 4: Create a DeleteMapping to delete all meals above a certain price
     * <p>
     * 1 - Create a new endpoint "/meal/price/{price}" using the @DeleteMapping annotation.
     * 2 - In the method, add a PathVariable for the price.
     * 3 - Delete all meals with a price above the price from the PathVariable.
     */

    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<String> deleteMealsAbovePrice(@PathVariable double price) {
        List<Meal> mealsToRemove = new ArrayList<>();
        for (Meal meal : meals) {
            if (meal.getPriceMeal() > price) {
                mealsToRemove.add(meal);
            }
        }
        meals.removeAll(mealsToRemove);
        return ResponseEntity.ok("Meal to remove");
    }

    /**
     * Exercise 5: Create a PutMapping to update the price of a meal by name
     * <p>
     * 1 - Create a new endpoint "/meal/{name}/price" using the @PutMapping annotation.
     * 2 - In the method, add a PathVariable for the name and a RequestBody for the updated price.
     * 3 - Update the price of the meal with the corresponding name using the information from the RequestBody.
     */

    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> updateMealPrice(@PathVariable String name, @RequestBody Double updatedPrice) {
        for (Meal meal : meals) {
            if (meal.getNameMeal().equals(name)) {
                meal.setPriceMeal(updatedPrice);
                return ResponseEntity.ok("Meal price updated");
            }
        }
        return ResponseEntity.notFound().build();

    }
}
