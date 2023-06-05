package com.example.springboot.Exercise_1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FirstController {

    /**
     * Exercise 1: Create a GetMapping that returns a basic "string" as a response
     * <p>
     * 1 - Create a new endpoint "/hello" using the @GetMapping annotation.
     * 2 - In the method, return a simple string such as "Hello World!".
     */
    @GetMapping("/hello")
    public String index() {
        return "Hello Gianpa! This is my first message on springboot";
    }

    /**
     * Exercise 2: Create a GetMapping that returns a ResponseEntity as a response
     * <p>
     * 1 - Create a new endpoint "/greeting" using the @GetMapping annotation.
     * 2 - In the method, return a ResponseEntity object with a string message such as "Good Afternoon!".
     * 3 - You can also set the HTTP status code in the ResponseEntity, such as "200 OK".
     */
    @GetMapping("/greeting")
    public ResponseEntity<String> getGreetingMessage() {
        String message = "Good Afternoon!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    /** Exercise 3: Create a new class with a GetMapping that returns a ResponseEntity a
     *
     * 1 - Annotate a new class with the @RestController annotation.
     * 2 - Create a new endpoint "/info" using the @GetMapping annotation.
     * 3 - In the method, return a ResponseEntity with 200 OK
     *
     * @ClassInfo
     */

    /** Exercise 4: Create a GetMapping that returns 400 - Bad request or 200 - OK based on a random boolean
     *
     * 1 - Annotate a new class with the @RestController annotation.
     * 2 - Create a new endpoint "/random" using the @GetMapping annotation.
     * 3 - In the method, return a ResponseEntity with 200 OK or 400 Bad Request based on the result of new Random().nextBoolean()
     * @ClassRandom
     */

}


