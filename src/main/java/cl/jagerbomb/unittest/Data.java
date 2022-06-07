package cl.jagerbomb.unittest;

import cl.jagerbomb.unittest.models.Account;
import cl.jagerbomb.unittest.models.Bank;

import java.math.BigDecimal;

public class Data {
    public static final Account ACCOUNT_1 = new Account(1L, "Jose", new BigDecimal("8000"));
    public static final Account ACCOUNT_2 = new Account(2L, "Miguel", new BigDecimal("4000"));
    public static final Account ACCOUNT_3 = new Account(3L, "Daniel", new BigDecimal("7000"));
    public static final Account ACCOUNT_4 = new Account(4L, "Tomas", new BigDecimal("3000"));
    public static final Account ACCOUNT_5 = new Account(5L, "James", new BigDecimal("1000"));

    public static final Bank BANK = new Bank(5L, "James", 0);
}
