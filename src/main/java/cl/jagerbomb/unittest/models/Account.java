package cl.jagerbomb.unittest.models;

import cl.jagerbomb.unittest.exceptions.InsufficientMoneyException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String user;
    private BigDecimal balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(user, account.user) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, balance);
    }

    public void debito(BigDecimal amount) {
        BigDecimal newBalance = this.balance.subtract(amount);
        if(newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new InsufficientMoneyException("Dinero insuficiente en la cuenta.");
        }
        this.balance = newBalance;
    }

    public void credito(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }
}
