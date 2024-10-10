package com.drarc.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CustomerDto {
    private String name;
    private String email;
    private String mobileNumber;

    AccountsDto accountsDto;
}
