package com.example.demo.Employees;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {
    @NotNull
    @Size(min = 2, message = "the idshould NOT less then 2")
    private String ID;


    @NotNull
    @Size(min = 4, message = "the name should be between 4")
    private String Name;


    @NotNull
    @Min(value = 25, message = "age should be 25 or above")
    private int Age;

    @NotEmpty
    @Pattern(regexp = "supervisor|coordinator")
   private String Position;


    @AssertFalse(message =" MUST BE FALSE")
   private boolean Onleave;


    @NotEmpty
    @PastOrPresent
    private Data EmplymentYear;


   @NotEmpty(message = "annualLeave Cannot be null")
    @PositiveOrZero
   private int AnnualLeave;
}
