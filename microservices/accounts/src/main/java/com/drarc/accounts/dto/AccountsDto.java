package com.drarc.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class AccountsDto {
    @Pattern(regexp = "\\d{10}", message = "Account number must be 10 digits")
    @Schema(description = "Account Number of the Customer", example = "9876543210")
    private Long accountNumber;

    @NotEmpty(message = "Account Type cannot be null or empty")
    @Schema(description = "Account Type of the Customer", example = "SAVINGS")
    private String accountType;

    @NotEmpty(message = "Branch Address cannot be null or empty")
    @Schema(description = "Branch Address of the customer", example = "Ranchi")
    private String branchAddress;
}
