package cl.jagerbomb.unittest.services;

import cl.jagerbomb.unittest.models.Account;

import java.math.BigDecimal;

public interface AccountService {
    Account findById(Long id);
    int reviewTotalTransfer(Long idBank);
    BigDecimal reviewBalance(Long accountId);
    void transfer(Long originAccountNumber, Long destinyAccountNumber, BigDecimal amount, Long bankId);
}
