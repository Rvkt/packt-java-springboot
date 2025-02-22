package io.rvkt.property_management.controller;


import io.rvkt.property_management.dto.CalculatorDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/sub/{num111}/{num2}")//Map the values of url to java variables by Path variable method
    public Double substract(@PathVariable("num111") Double num1, @PathVariable("num2") Double num2){
        Double result = null;
        if(num1>num2){
            result = num1-num2;
        }else{
            result = num2-num1;
        }
        return result;
    }


    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO) {
        System.out.println("Received DTO: " + calculatorDTO);

        if (calculatorDTO == null) {
            System.out.println("DTO is null");
            return ResponseEntity.badRequest().body(null);
        }

        System.out.println("Num1: " + calculatorDTO.getNum1());
        System.out.println("Num2: " + calculatorDTO.getNum2());
        System.out.println("Num3: " + calculatorDTO.getNum3());
        System.out.println("Num4: " + calculatorDTO.getNum4());

        if (calculatorDTO.getNum1() == null || calculatorDTO.getNum2() == null ||
                calculatorDTO.getNum3() == null || calculatorDTO.getNum4() == null) {
            System.out.println("One or more fields are null");
            return ResponseEntity.badRequest().body(null);
        }

        Double result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        System.out.println("Result: " + result);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
