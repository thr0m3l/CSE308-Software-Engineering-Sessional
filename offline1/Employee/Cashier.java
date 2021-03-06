package Employee;

import Bank.Bank;

public class Cashier extends Employee {

    public Cashier(String name, Bank bank) {
        super(name, bank);
    }

    public void approveLoan() {
        System.err.println("You don’t have permission for this operation");
    }

}
