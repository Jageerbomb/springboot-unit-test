package cl.jagerbomb.unittest.services.impl;

import cl.jagerbomb.unittest.models.Account;
import cl.jagerbomb.unittest.models.Bank;
import cl.jagerbomb.unittest.repositories.AccountRepository;
import cl.jagerbomb.unittest.repositories.BankRepository;
import cl.jagerbomb.unittest.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private BankRepository bankRepository;

    public AccountServiceImpl(AccountRepository accountRepository, BankRepository bankRepository) {
        this.accountRepository = accountRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public int reviewTotalTransfer(Long bankId) {
        Bank bank = bankRepository.findById(bankId);
        return bank.getTotalTransfer();
    }

    @Override
    public BigDecimal reviewBalance(Long accountId) {
        Account account = accountRepository.findById(accountId);
        return account.getBalance();
    }

    @Override
    public void transfer(Long originAccountNumber, Long destinyAccountNumber, BigDecimal amount) {
        Bank bank = bankRepository.findById(1L);
        int totalTransfer = bank.getTotalTransfer();
        bank.setTotalTransfer(++totalTransfer);
        bankRepository.update(bank);

        Account originAccount = accountRepository.findById(originAccountNumber);
        originAccount.debito(amount);
        accountRepository.update(originAccount);

        Account destinyAccount = accountRepository.findById(destinyAccountNumber);
        destinyAccount.credito(amount);
        accountRepository.update(destinyAccount);
    }
}
