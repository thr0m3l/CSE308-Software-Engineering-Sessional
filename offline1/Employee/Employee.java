package Employee;

import Bank.*;

public abstract class Employee {
    protected String name;
    public Bank bank;

    public Employee(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    public void lookup(String name) {
        System.out.println(name + "'s Account Balance: " + bank.query(name) + "$");
    }

    public void approveLoan() {
        bank.approveLoan();
    }

    public void changeInterest(String type, Double newInterest) {
        System.err.println("You don’t have permission for this operation");
    }

    public void seeInternalFund() {
        System.err.println("You don’t have permission for this operation");
    }

    public String getName() {
        return name;
    }
}