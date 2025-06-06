package com.drarc.accounts.service;

import com.drarc.accounts.dto.CustomerDetailsDto;
import com.drarc.accounts.dto.CustomerDto;

public interface IAccountsService {
    void createAccount(CustomerDto customerDto);
    CustomerDetailsDto fetchAccount(String mobileNumber);
}
