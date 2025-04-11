package com.example.Exp8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String showForm(@RequestParam(value = "number", required = false) Integer number) {
        String result = "";
        if (number != null) {
            if (number < 0) {
                result = "<div class='alert alert-danger mt-4' role='alert'>"
                        + "Factorial is not defined for negative numbers!" +
                        "</div>";
            } else {
                long factorial = 1;
                for (int i = 1; i <= number; i++) {
                    factorial *= i;
                }
                result = "<div class='alert alert-success mt-4' role='alert'>"
                        + "Factorial of " + number + " is: " + factorial +
                        "</div>";
            }
        }

        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Factorial Calculator</title>" +
                "<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>"
                +
                "</head>" +
                "<body class='bg-light d-flex align-items-center justify-content-center' style='height: 100vh;'>" +
                "<div class='container text-center'>" +
                "<div class='card shadow-sm p-4' style='max-width: 400px; margin: auto;'>" +
                "<h1 class='text-primary mb-4'>Factorial Calculator</h1>" +
                "<form method='get' action='/'>" +
                "<div class='mb-3'>" +
                "<input type='number' name='number' class='form-control' placeholder='Enter a number' required>" +
                "</div>" +
                "<button type='submit' class='btn btn-primary w-100'>Calculate</button>" +
                "</form>" +
                result +
                "</div>" +
                "</div>" +
                "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>" +
                "</body>" +
                "</html>";
    }
}
