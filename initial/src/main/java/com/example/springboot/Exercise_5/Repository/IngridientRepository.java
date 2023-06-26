package com.example.springboot.Exercise_5.Repository;

import com.example.springboot.Exercise_5.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface IngridientRepository extends JpaRepository<Ingredient, Long> {
    }

