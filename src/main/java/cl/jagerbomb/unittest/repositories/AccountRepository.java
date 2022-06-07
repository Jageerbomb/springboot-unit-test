package cl.jagerbomb.unittest.repositories;

import cl.jagerbomb.unittest.models.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
    Account findById(Long id);
    void update(Account account);
}
