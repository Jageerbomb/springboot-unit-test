package cl.jagerbomb.unittest;

import cl.jagerbomb.unittest.repositories.AccountRepository;
import cl.jagerbomb.unittest.repositories.BankRepository;
import cl.jagerbomb.unittest.services.AccountService;
import cl.jagerbomb.unittest.services.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UnitTestApplicationTest {

    AccountRepository accountRepository;
    BankRepository bankRepository;

    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        bankRepository = mock(BankRepository.class);
        accountService = new AccountServiceImpl(accountRepository, bankRepository);
    }

    @Test
    void contextLoads() {
        when(accountRepository.findById(1L)).thenReturn(Data.ACCOUNT_1);
        when(accountRepository.findById(2L)).thenReturn(Data.ACCOUNT_2);
        when(bankRepository.findById(1L)).thenReturn(Data.BANK);

        BigDecimal originBalance = accountService.reviewBalance(1L);
        BigDecimal destinyBalance = accountService.reviewBalance(2L);

        assertEquals("8000", originBalance.toPlainString());
        assertEquals("4000", destinyBalance.toPlainString());

        accountService.transfer(1L, 2L, new BigDecimal("100"), 1L);

        assertEquals("7900", originBalance.toPlainString());
        assertEquals("4100", destinyBalance.toPlainString());
    }

}