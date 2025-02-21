package io.rvkt.property_management.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") // Class-level mapping for calculator operations
public class CalculatorController {

    /**
     * Adds three numbers and returns the result.
     * <p>
     * Example API call: GET /api/v1/calculator/add/5?num1=10&num2=20
     *
     * @param num1 First number (from query parameter)
     * @param num2 Second number (from query parameter)
     * @param num3 Third number (from path variable)
     * @return Sum of num1, num2, and num3
     */
    @GetMapping("/add/{num3}")
    public Double add(
            @RequestParam("num1") Double num1,
            @RequestParam("num2") Double num2,
            @PathVariable("num3") Double num3) {
        return num1 + num2 + num3; // Fixed: Now adding num3 as well
    }
}
