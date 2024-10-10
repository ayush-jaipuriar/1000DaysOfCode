package com.drarc.accounts.mapper;

import com.drarc.accounts.dto.AccountsDto;
import com.drarc.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapAccountToDto(Accounts accounts) {
        return new AccountsDto(accounts.getAccountNumber(), accounts.getAccountType(), accounts.getBranchAddress());
    }

    public static Accounts mapAccountDtoToAccount(AccountsDto accountsDto) {
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
