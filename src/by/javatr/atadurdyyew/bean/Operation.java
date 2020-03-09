package by.javatr.atadurdyyew.bean;

import java.math.BigDecimal;
import java.util.Objects;

public class Operation {
    int id;
    String operationName;
    BigDecimal value;
    int accountId;


    public Operation(){
    }

    public Operation(int id, String operationName, BigDecimal value, int accountId) {
        this.id = id;
        this.operationName = operationName;
        this.value = value;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return id == operation.id &&
                accountId == operation.accountId &&
                operationName.equals(operation.operationName) &&
                value.equals(operation.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, operationName, value, accountId);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", operationName='" + operationName + '\'' +
                ", value=" + value +
                ", accountId=" + accountId +
                '}';
    }
}
