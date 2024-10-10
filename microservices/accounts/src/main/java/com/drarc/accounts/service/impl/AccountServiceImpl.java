package com.drarc.accounts.service.impl;

import com.drarc.accounts.dto.CustomerDto;
import com.drarc.accounts.entity.Accounts;
import com.drarc.accounts.entity.Customer;
import com.drarc.accounts.exception.CustomerAlreadyExistsException;
import com.drarc.accounts.exception.ResourceNotFoundException;
import com.drarc.accounts.mapper.AccountsMapper;
import com.drarc.accounts.mapper.CustomerMapper;
import com.drarc.accounts.repository.AccountsRepository;
import com.drarc.accounts.repository.CustomerRepository;
import com.drarc.accounts.service.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("anonymous");

        // Save Customer to repository
        customerRepository.save(customer);

        // Create and save account
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(generateAccountNumber());
        accounts.setAccountType("Savings");
        accounts.setBranchAddress("Hyderabad");
        accounts.setCustomerId(customer.getCustomerId());
        accounts.setCreatedAt(LocalDateTime.now());
        accounts.setCreatedBy("anonymous");
        accountsRepository.save(accounts);
    }

    private Long generateAccountNumber() {
        return 1000000000L + new Random().nextInt(999999999); // Example logic for generating account number
    }
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(()-> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer);
        customerDto.setAccountsDto(AccountsMapper.mapAccountToDto(accounts));
        return customerDto;
    }
}
