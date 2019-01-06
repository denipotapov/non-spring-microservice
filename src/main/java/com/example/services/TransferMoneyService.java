package com.example.services;

import com.example.entities.db.Account;
import com.example.entities.rest.TransferMoneyPayload;
import com.example.exceptions.AccountNotFoundException;
import com.example.exceptions.DifferentTransferCurrenciesException;
import com.example.exceptions.InsufficientFundsException;
import com.example.repositories.AccountRepository;

public class TransferMoneyService {

    private AccountRepository accountRepository;

    public TransferMoneyService() {
        accountRepository = new AccountRepository();
    }

    public void transfer(TransferMoneyPayload payload) throws InsufficientFundsException, DifferentTransferCurrenciesException, AccountNotFoundException {

        Account accountFrom = accountRepository.findByIdAndLock(payload.getFromAccount());

        if (accountFrom.getBalance().getAmount() < payload.getAmount()) {
            accountRepository.rollback();
            throw new InsufficientFundsException();
        }

        Account accountTo = accountRepository.findByIdAndLock(payload.getToAccount());

        if (!accountFrom.getCurrency().equals(accountTo.getCurrency())) {
            accountRepository.rollback();
            throw new DifferentTransferCurrenciesException();
        }

        int balanceFrom = accountFrom.getBalance().getAmount();
        int balanceTo = accountTo.getBalance().getAmount();
        accountFrom.getBalance().setAmount(balanceFrom - payload.getAmount());
        accountTo.getBalance().setAmount(balanceTo + payload.getAmount());

        accountRepository.commit();
        accountRepository.closeSession();

    }

}
