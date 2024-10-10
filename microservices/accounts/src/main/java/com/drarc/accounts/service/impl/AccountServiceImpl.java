package com.drarc.accounts.service.impl;

import com.drarc.accounts.dto.CustomerDto;
import com.drarc.accounts.repository.AccountsRepository;
import com.drarc.accounts.repository.CustomerRepository;
import com.drarc.accounts.service.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountsService {
    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AccountServiceImpl(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public void createAccount(CustomerDto customerDto) {
        // Logic to create account will go here
    }
}
