package com.example.springboot.Exercise_5.Repository;

import com.example.springboot.Exercise_5.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    //Puoi aggiungere le Query
}