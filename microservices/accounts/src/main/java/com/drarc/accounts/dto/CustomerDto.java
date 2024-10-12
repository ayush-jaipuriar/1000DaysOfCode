package com.drarc.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CustomerDto {
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    @Schema(description = "Full name of the customer", example = "Ayush Jaipuriar")
    private String name;

    @Email(message = "Email is not of valid format")
    @Schema(description = "Valid email of the customer", example = "ayush@gmail.com")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    @Schema(description = "Mobile number of the customer", example = "9876543210")
    private String mobileNumber;

    AccountsDto accountsDto;
}
