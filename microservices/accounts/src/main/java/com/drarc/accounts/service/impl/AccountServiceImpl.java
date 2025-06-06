package com.drarc.accounts.service.impl;

import com.drarc.accounts.dto.CustomerDetailsDto;
import com.drarc.accounts.dto.CustomerDto;
import com.drarc.accounts.dto.LoansDto;
import com.drarc.accounts.entity.Accounts;
import com.drarc.accounts.entity.Customer;
import com.drarc.accounts.exception.CustomerAlreadyExistsException;
import com.drarc.accounts.exception.ResourceNotFoundException;
import com.drarc.accounts.mapper.AccountsMapper;
import com.drarc.accounts.mapper.CustomerMapper;
import com.drarc.accounts.repository.AccountsRepository;
import com.drarc.accounts.repository.CustomerRepository;
import com.drarc.accounts.service.IAccountsService;
import com.drarc.accounts.service.client.LoansFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements IAccountsService {
    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;
    private final LoansFeignClient loansFeignClient;

    // Constructor-based dependency injection for the repositories
    @Autowired
    public AccountServiceImpl(AccountsRepository accountsRepository, CustomerRepository customerRepository, LoansFeignClient loansFeignClient) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
        this.loansFeignClient = loansFeignClient;
    }

    // Method to create an account for a customer
    @Override
    public void createAccount(CustomerDto customerDto) {
        // Check if a customer with the given mobile number already exists
        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (existingCustomer.isPresent()) {
            // Throw exception if customer already exists
            throw new CustomerAlreadyExistsException("Customer already registered with the given mobile number");
        }

        // Convert the CustomerDto to a Customer entity using a mapper class
        Customer customer = CustomerMapper.mapToCustomerEntity(customerDto);

        // Save the new customer entity to the repository
        customerRepository.save(customer);

        // Create an account entity and associate it with the newly created customer
        Accounts accounts = new Accounts();
        // Generate a random account number
        accounts.setAccountNumber(generateAccountNumber());
        accounts.setAccountType("Savings");  // Set account type as "Savings"
        accounts.setBranchAddress("Hyderabad"); // Set the branch address
        accounts.setCustomerId(customer.getCustomerId());  // Associate the account with the customer

        // Save the account entity to the repository
        accountsRepository.save(accounts);
    }

    // Private method to generate a random 10-digit account number
    private Long generateAccountNumber() {
        return 1000000000L + new Random().nextInt(999999999); // Random generation of a unique account number
    }

    // Method to fetch the account details for a customer based on their mobile number
    @Override
    public CustomerDetailsDto fetchAccount(String mobileNumber) {
        // Fetch the customer by mobile number, or throw a ResourceNotFoundException if not found
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        // Fetch the account associated with the customer ID, or throw a ResourceNotFoundException if not found
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        // Convert the Customer entity to a CustomerDto
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer);

        // Convert the Accounts entity to an AccountsDto and set it inside CustomerDto
        customerDto.setAccountsDto(AccountsMapper.mapAccountToDto(accounts));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        customerDetailsDto.setCustomer(customerDto);
        if(loansDtoResponseEntity != null) {
            customerDetailsDto.setLoans(loansDtoResponseEntity.getBody());
        }

        // Return the populated CustomerDetailsDto
        return customerDetailsDto;
    }
}
