package com.example.springboot.Exercise_5.Service;

import com.example.springboot.Exercise_5.Ingredient;
import com.example.springboot.Exercise_5.Repository.IngridientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final IngridientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngridientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found with id: " + id));
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        Ingredient existingIngredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found with id: " + id));

        existingIngredient.setName(ingredient.getName());
        existingIngredient.setVegetarian(ingredient.isVegetarian());
        existingIngredient.setVegan(ingredient.isVegan());
        existingIngredient.setGlutenFree(ingredient.isGlutenFree());
        existingIngredient.setLactoseFree(ingredient.isLactoseFree());

        return ingredientRepository.save(existingIngredient);
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
