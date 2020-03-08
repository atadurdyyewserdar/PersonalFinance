package by.javatr.atadurdyyew.convertor;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.bean.User;

import java.math.BigDecimal;

public class AccountConvertor {
    public static String convert(Account account) {
        return String.valueOf(account.getAccountId()) +
                ',' +
                account.getUserId() +
                ',' +
                account.getBalance();
    }
    public static Account convert(String data){
        String[] str = data.split(",");
        Account account = new Account();
        account.setAccountId(Integer.parseInt(str[0]));
        account.setUserId(Integer.parseInt(str[1]));
        account.setBalance(new BigDecimal(str[2]));
        return account;
    }
}
