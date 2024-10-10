package com.drarc.accounts.controller;

import com.drarc.accounts.constants.AccountsConstants;
import com.drarc.accounts.dto.CustomerDto;
import com.drarc.accounts.dto.ResponseDto;
import com.drarc.accounts.service.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountsController {

    @Autowired
    private IAccountsService accountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        // Business logic will be added here later
        accountsService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.STATUS_MESSAGE_201));
    }


}
