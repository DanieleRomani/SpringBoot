package com.example.springboot.Exercise_1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Random {
    /** Exercise 4: Create a GetMapping that returns 400 - Bad request or 200 - OK based on a random boolean
     *
     * 1 - Annotate a new class with the @RestController annotation.
     * 2 - Create a new endpoint "/random" using the @GetMapping annotation.
     * 3 - In the method, return a ResponseEntity with 200 OK or 400 Bad Request based on the result of new Random().nextBoolean()
     */
    @GetMapping("/random")
    public ResponseEntity<String> getRandomResult() {
        boolean isSuccess = new java.util.Random().nextBoolean();

        if (isSuccess) {
            String successMessage = "Request success.";
            return ResponseEntity.status(HttpStatus.OK).body(successMessage);
        } else {
            String errorMessage = "Request fail.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

}
