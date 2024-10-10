package com.drarc.accounts.service.impl;

import com.drarc.accounts.dto.CustomerDto;
import com.drarc.accounts.entity.Accounts;
import com.drarc.accounts.entity.Customer;
import com.drarc.accounts.exception.CustomerAlreadyExistsException;
import com.drarc.accounts.mapper.CustomerMapper;
import com.drarc.accounts.repository.AccountsRepository;
import com.drarc.accounts.repository.CustomerRepository;
import com.drarc.accounts.service.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

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
        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with the given mobile number");
        }
        // Covert Customer DTO to Entity
        Customer customer = CustomerMapper.mapToCustomerEntity(customerDto);

        // Save Customer to repository
        customerRepository.save(customer);

        // Create and save account
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(generateAccountNumber());
        accounts.setAccountType("Savings");
        accounts.setBranchAddress("Hyderabad");
        accounts.setCustomerId(customer.getCustomerId());
        accountsRepository.save(accounts);
    }

    private Long generateAccountNumber() {
        return 1000000000L + new Random().nextInt(999999999); // Example logic for generating account number
    }
}
