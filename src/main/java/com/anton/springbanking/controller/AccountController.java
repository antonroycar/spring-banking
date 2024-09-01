package com.anton.springbanking.controller;

import com.anton.springbanking.dto.AccountDto;
import com.anton.springbanking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    public AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get Account
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id){
        return new ResponseEntity<>(accountService.getAccount(id), HttpStatus.OK);
    }

    // Deposit
    @PutMapping("/{id}/deposit")
    ResponseEntity<AccountDto> deposit (@PathVariable Long id,
                                        @RequestBody Map<String, Double> request){
        return new ResponseEntity<>(accountService.deposit(id, request.get("amount")), HttpStatus.OK);
    }

    // Withdraw
    @PutMapping("/{id}/withdraw")
    ResponseEntity<AccountDto> withdraw (@PathVariable Long id,
                                        @RequestBody Map<String, Double> request){
        return new ResponseEntity<>(accountService.withdraw(id, request.get("amount")), HttpStatus.OK);
    }

    // Get All Acounts
    @GetMapping
    ResponseEntity<List<AccountDto>> getAllAcounts (){
        List<AccountDto> allAccounts = accountService.getAllAccounts();
        return ResponseEntity.ok(allAccounts);
    }

    // Detele Account
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteAccount (@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Detele Account Successfully");
    }

}
