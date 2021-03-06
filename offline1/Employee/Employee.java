package Employee;

import Bank.*;

public abstract class Employee {
    protected String name;
    public Bank bank;

    public Employee(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    public Double lookup(String name) {
        return bank.query(name);
    }

    public void approveLoan() {
        bank.approveLoan();
    }

    public void changeInterest(String name, Double newInterest) {
        System.err.println("You don’t have permission for this operation");
    }

    public void seeInternalFund() {
        System.err.println("You don’t have permission for this operation");
    }
}