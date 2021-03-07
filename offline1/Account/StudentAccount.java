package Account;

import Bank.Bank;

public class StudentAccount extends Account {
    public StudentAccount(Bank bank, String name, Double firstDeposit) {

        super(0.0, 0.0, 0.0, 10000.0, 0.0, 1000.0, 5.0, 0.0, bank, name, firstDeposit);

        System.out.println("Student account for " + super.name + " created; Initial Balance: " + super.balance + "$ ;");
    }

}