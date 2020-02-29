package by.javatr.atadurdyyew.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Account implements Serializable {
    private BigDecimal balance;
    private int accountId;
    private int userId;

    public Account(){
    }

    public Account(BigDecimal balance, int accountId, int userId) {
        this.balance = balance;
        this.accountId = accountId;
        this.userId = userId;
    }

    public Account(BigDecimal balance, int accountId) {
        this.balance = balance;
        this.accountId = accountId;
        userId = -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId &&
                userId == account.userId &&
                balance.equals(account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, accountId, userId);
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountId=" + accountId +
                ", userId=" + userId +
                '}';
    }
}
