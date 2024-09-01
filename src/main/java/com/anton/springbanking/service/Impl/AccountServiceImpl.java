package com.anton.springbanking.service.Impl;

import com.anton.springbanking.dto.AccountDto;
import com.anton.springbanking.entity.Account;
import com.anton.springbanking.mapper.AccountMapper;
import com.anton.springbanking.repository.AccountRepository;
import com.anton.springbanking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    public AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapperToAccount(accountDto);
        Account save = accountRepository.save(account);
        return AccountMapper.mapperToAccountDto(save);
    }

    @Override
    public AccountDto getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account doesn't exist"));
        return AccountMapper.mapperToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account doesn't exist"));

        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        Account save = accountRepository.save(account);
        return AccountMapper.mapperToAccountDto(save);
    }

    @Override
    public AccountDto withdraw(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account doesn't exist"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient amount");
        }

        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        Account save = accountRepository.save(account);
        return AccountMapper.mapperToAccountDto(save);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> all = accountRepository.findAll();
        return all.stream()
                .map((account)-> AccountMapper
                .mapperToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account doesn't exist"));

        accountRepository.delete(account);
    }
}
