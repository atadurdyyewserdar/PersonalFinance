package by.javatr.atadurdyyew.dao.convertor;

import by.javatr.atadurdyyew.bean.Operation;
import by.javatr.atadurdyyew.exception.ConvertorException;

import java.math.BigDecimal;
import java.util.Iterator;

public class OperationConvertor {
    public static String convert(Operation operation) throws ConvertorException {
        if (operation == null) {
            throw new ConvertorException("Data is null, can't convert");
        }
        String res;
        res = String.valueOf(operation.getId()) + ',' +
                operation.getAccountId() + ','
                + operation.getOperationName() + ','
                + operation.getValue().toString();
        return res;
    }

    public static Operation convert(String data) throws ConvertorException {
        if (data == null) {
            throw new ConvertorException("Data is null, can't convert");
        }
        String[] str = data.split(",");
        if (str.length != 4) {
            throw new ConvertorException("Error while converting, wrong parameter");
        }
        Operation operation = new Operation();
        try {
            operation.setId(Integer.parseInt(str[0]));
            operation.setAccountId(Integer.parseInt(str[1]));
            operation.setOperationName(str[2]);
            operation.setValue(new BigDecimal(str[3]));
        } catch (NumberFormatException ex) {
            throw new ConvertorException("Error while converting data, wrong data");
        }
        return operation;
    }

    public static String convert(Iterator<Operation> iterator) throws ConvertorException {
        if (iterator == null) {
            throw new ConvertorException("Data is null, can't convert");
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().toString());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
