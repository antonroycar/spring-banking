package com.anton.springbanking.service;

import com.anton.springbanking.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount (AccountDto accountDto);

    AccountDto getAccount (Long id);

    AccountDto deposit (Long id, Double amount);

    AccountDto withdraw (Long id, Double amount);

    List<AccountDto> getAllAccounts ();

    void deleteAccount (Long id);
}
