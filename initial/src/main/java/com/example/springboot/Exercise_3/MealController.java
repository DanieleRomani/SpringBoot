//package com.example.springboot.Exercise_3;
//
//import com.example.springboot.Exercise_2.Meal;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class MealController {
//    ArrayList <Meal> meals = new ArrayList<>();
//
//    public MealController() {
//        meals.add(new Meal("Spaghetti alla carbonara", "spaghetti, uova, pancetta, pecorino", 12.00));
//        meals.add(new Meal("Pizza Margherita", "Pomodoro, Mozzarella", 8.00));
//        meals.add(new Meal("Insalata di pollo", "insalata, maionese, pollo", 15.00));
//    }
//
//    /**
//     * Exercise 1: Create a PutMapping to add a new meal
//     * <p>
//     * 1 - Create a new endpoint "/meal" using the @PostMapping annotation.
//     * 2 - In the method, add a RequestBody for the new Meal object.
//     * 3 - Add the new meal to the list of meals.
//     */
//
//    @GetMapping("/mealsList")
//    /** Metodo per verificare la lista in Postman */
//    public List<Meal> getMeals() {
//        return meals;
//    }
//
//    @PostMapping("/meal")
//    public ResponseEntity<String> addMeal(@RequestBody Meal newMeal) {
//        meals.add(newMeal);
//        return ResponseEntity.ok("New meal added");
//    }
//
//    // Rchiesta POST in postman -> Modify body JSON - RAW
//
//    /** @PostConstruct // per aggiungere direttamente alla tabella DB meal il nuovo meal
//    public void addDefaultMeal() {
//    Meal pastaAlPesto = new Meal("Pasta al pesto", "Basilico, pinoli, grana", 12.00);
//    meals.add(pastaAlPesto);
//    }*/
//
//
//    /**
//     * Exercise 2: Create a PostMapping to update a meal by name
//     * <p>
//     * 1 - Create a new endpoint "/meal/{name}" using the @PutMapping annotation.
//     * 2 - In the method, add a PathVariable for the name and a RequestBody for the updated Meal object.
//     * 3 - Update the meal with the corresponding name using the information from the RequestBody.
//     */
//
//    @PutMapping("/put/meal/{name}")
//    /**
//     * Metodo Modifica pasto.
//     * Sostituire il {name} con il nome ESATTO del meal da Modificare nella richiesta postman.
//     * Verifica con una Get request il corpo RAW JSON da modificare e copiarlo nel terminale postman aggiungendo relative modifiche.
//     */
//    public ResponseEntity<String> updateMeal(@PathVariable String name, @RequestBody Meal updatedMeal) {
//        for (Meal meal : meals) {
//            if (meal.getNameMeal().equals(name)) {
//                meal.setNameMeal(updatedMeal.getNameMeal());
//                meal.setDescriptionMeal(updatedMeal.getDescriptionMeal());
//                meal.setPriceMeal(updatedMeal.getPriceMeal());
//                return ResponseEntity.ok("Meal updated");
//            }
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    /**
//     * Exercise 3: Create a DeleteMapping to delete a meal by name
//     * <p>
//     * 1 - Create a new endpoint "/meal/{name}" using the @DeleteMapping annotation.
//     * 2 - In the method, add a PathVariable for the name.
//     * 3 - Delete the meal with the corresponding name.
//     */
//
//    @DeleteMapping("/delete/meal/{name}")
//    /**
//     * Metodo Elimina pasto
//     * sostituire il {name} con il nome ESATTO del meal da eliminare nella richiesta postman.
//     * Verifica con una Get request il corpo RAW JSON da modificare e copialo nel terminale postman Modificando il nome del pasto da eliminare.
//     */
//    public ResponseEntity<String> deleteMeal(@PathVariable String name) {
//        for (Meal meal : meals) {
//            if (meal.getNameMeal().equals(name)) {
//                meals.remove(meal);
//                return ResponseEntity.ok("Meal deleted");
//            }
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    /**
//     * Exercise 4: Create a DeleteMapping to delete all meals above a certain price
//     * <p>
//     * 1 - Create a new endpoint "/meal/price/{price}" using the @DeleteMapping annotation.
//     * 2 - In the method, add a PathVariable for the price.
//     * 3 - Delete all meals with a price above the price from the PathVariable.
//     */
//
//    @DeleteMapping("/delete/meal/price/{price}")
//    /**
//     * Metodo Elimina pasto dal prezzo
//     * sostituire il {name} con il nome ESATTO del meal da eliminare nella richiesta postman.
//     * Verifica con una Get request il corpo RAW JSON.
//     */
//    public ResponseEntity<String> deleteMealsAbovePrice(@PathVariable double price) {
//        List<Meal> mealsToRemove = new ArrayList<>();
//        for (Meal meal : meals) {
//            if (meal.getPriceMeal() > price) {
//                mealsToRemove.add(meal);
//            }
//        }
//        meals.removeAll(mealsToRemove);
//        return ResponseEntity.ok("Meal to remove");
//    }
//
//    /**
//     * Exercise 5: Create a PutMapping to update the price of a meal by name
//     * <p>
//     * 1 - Create a new endpoint "/meal/{name}/price" using the @PutMapping annotation.
//     * 2 - In the method, add a PathVariable for the name and a RequestBody for the updated price.
//     * 3 - Update the price of the meal with the corresponding name using the information from the RequestBody.
//     */
//
//    @PutMapping("/update/meal/{name}/price")
//    /**
//     * Metodo Modifica pasto.
//     * Sostituire il {name} con il nome ESATTO del meal da Modificare nella richiesta postman.
//     * Verifica con una Get request il corpo RAW JSON da modificare e copiarlo nel terminale postman aggiungendo relative modifiche.
//     */
//    public ResponseEntity<String> updateMealPrice(@PathVariable String name, @RequestBody Double updatedPrice) {
//        for (Meal meal : meals) {
//            if (meal.getNameMeal().equals(name)) {
//                meal.setPriceMeal(updatedPrice);
//                return ResponseEntity.ok("Meal price updated");
//            }
//        }
//        return ResponseEntity.notFound().build();
//
//    }
//}
