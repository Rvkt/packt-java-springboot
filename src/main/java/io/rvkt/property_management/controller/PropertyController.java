package io.rvkt.property_management.controller;

import org.springframework.web.bind.annotation.*;


// Marks this class as a REST controller, handling HTTP requests
@RestController

// Base URL for all endpoints in this controller
@RequestMapping("/api/v1")

public class PropertyController {

    /**
     * Endpoint to return a simple greeting message.
     * Accessible via GET request at /api/v1/hello
     *
     * @return A greeting string "Hello"
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello ";
    }
}
