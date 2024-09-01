package com.anton.springbanking.mapper;

import com.anton.springbanking.dto.AccountDto;
import com.anton.springbanking.entity.Account;

public class AccountMapper {

    public static Account mapperToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }
    public static AccountDto mapperToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
