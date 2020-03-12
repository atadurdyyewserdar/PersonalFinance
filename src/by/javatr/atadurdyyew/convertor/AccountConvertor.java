package by.javatr.atadurdyyew.convertor;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.bean.User;
import by.javatr.atadurdyyew.exception.ConvertorException;

import java.math.BigDecimal;

public class AccountConvertor {
    public static String convert(Account account) throws ConvertorException {
        if (account == null) {
            throw new ConvertorException("Account null, can't convert");
        }
        return String.valueOf(account.getAccountId()) +
                ',' +
                account.getUserId() +
                ',' +
                account.getBalance();
    }

    public static Account convert(String data) throws ConvertorException {
        if (data == null) {
            throw new ConvertorException("Data is null, can't convert");
        }
        String[] str = data.split(",");
        if (str.length != 3) {
            throw new ConvertorException("Error while converting, wrong parameter");
        }
        Account account = new Account();
        try {
            account.setAccountId(Integer.parseInt(str[0]));
            account.setUserId(Integer.parseInt(str[1]));
            account.setBalance(new BigDecimal(str[2]));
        } catch (NumberFormatException ex) {
            throw new ConvertorException("Error converting data, wrong parameter");
        }
        return account;
    }
}
