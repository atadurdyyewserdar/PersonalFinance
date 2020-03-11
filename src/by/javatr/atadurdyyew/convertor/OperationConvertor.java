package by.javatr.atadurdyyew.convertor;

import by.javatr.atadurdyyew.bean.Account;
import by.javatr.atadurdyyew.bean.Operation;

import java.math.BigDecimal;
import java.util.Iterator;

public class OperationConvertor {
    public static String convert(Operation operation) {
        String res;
        res = String.valueOf(operation.getId()) + ',' +
                operation.getAccountId() + ','
                + operation.getOperationName() + ','
                +operation.getValue().toString();
        return res;
    }
    public static Operation convert(String data){
        String[] str = data.split(",");
        Operation operation = new Operation();
        operation.setId(Integer.parseInt(str[0]));
        operation.setAccountId(Integer.parseInt(str[1]));
        operation.setOperationName(str[2]);
        operation.setValue(new BigDecimal(str[3]));
        return operation;
    }

    public static String convert(Iterator<Operation> iterator){
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next().toString());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
