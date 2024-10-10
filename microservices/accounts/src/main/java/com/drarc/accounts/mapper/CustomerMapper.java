package com.drarc.accounts.mapper;

import com.drarc.accounts.dto.CustomerDto;
import com.drarc.accounts.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer) {
        return new CustomerDto(customer.getName(), customer.getEmail(), customer.getMobileNumber(), null);
    }

    public static Customer mapToCustomerEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

}
