package cl.jagerbomb.unittest.repositories;

import cl.jagerbomb.unittest.models.Bank;

import java.util.List;

public interface BankRepository {
    List<Bank> findAll();
    Bank findById(Long id);
    void update(Bank bank);
}
