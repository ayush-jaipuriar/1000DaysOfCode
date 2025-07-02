package com.drarc.accounts.controller;

import com.drarc.accounts.constants.AccountsConstants;
import com.drarc.accounts.dto.AccountsContactInfoDto;
import com.drarc.accounts.dto.CustomerDetailsDto;
import com.drarc.accounts.dto.CustomerDto;
import com.drarc.accounts.dto.ResponseDto;
import com.drarc.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@EnableConfigurationProperties(AccountsContactInfoDto.class)
@Tag(name = "CR REST APIs for Accounts", description = "CRUD REST APIs to CREATE and FETCH Bank Account Details")
public class AccountsController {

    private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);

    @Autowired
    private Environment environment;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private IAccountsService accountsService;

    @Autowired
    private AccountsContactInfoDto accountsContactInfoDto;

    @PostMapping("/create")
    @Operation(summary = "Create Account REST API", description = "REST API to create a new Customer and Account in Bank")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<ResponseDto> createAccount(@RequestHeader("ayush-drarc-correlation-id") String correlationId, @Valid @RequestBody CustomerDto customerDto) {
        logger.debug("ayush-drarc-correlation-id found: {} ", correlationId);
        accountsService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.STATUS_MESSAGE_201));
    }

    @GetMapping("/fetch")
    @Operation(summary = "Fetch Account REST API", description = "REST API to fetch Customer and Account Details using Mobile Number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<CustomerDetailsDto> fetchAccountDetails(@RequestHeader("ayush-drarc-correlation-id") String correlationId, @RequestParam @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits") String mobileNumber) {
        logger.debug("ayush-drarc-correlation-id found: {} ", correlationId);
        CustomerDetailsDto customerDetailsDto = accountsService.fetchAccount(mobileNumber, correlationId);
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);
    }

    @GetMapping("/build-info")
    @Operation(summary = "Get build information", description = "Get the build information deployed into accounts microservice")
    public ResponseEntity<String> getBuildInfo(@RequestHeader("ayush-drarc-correlation-id") String correlationId) {
        logger.debug("ayush-drarc-correlation-id found: {} ", correlationId);
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/java-version")
    @Operation(summary = "Get java version", description = "Get the java version details that are installed in the accounts microservice")
    public ResponseEntity<String> getMavenVersion(@RequestHeader("ayush-drarc-correlation-id") String correlationId) {
        logger.debug("ayush-drarc-correlation-id found: {} ", correlationId);
        String javaVersion = environment.getProperty("JAVA_HOME");
        return ResponseEntity.status(HttpStatus.OK).body(javaVersion);
    }

    @GetMapping("/contact-info")
    @Operation(summary = "Get contact info", description = "Returns contact information for support related to Accounts Microservice")
    public ResponseEntity<AccountsContactInfoDto> getContactInfo(@RequestHeader("ayush-drarc-correlation-id") String correlationId) {
        logger.debug("ayush-drarc-correlation-id found: {} ", correlationId);
        return ResponseEntity.status(HttpStatus.OK).body(accountsContactInfoDto);
    }


}
