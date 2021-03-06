package Employee;

import Bank.Bank;

public class ManagingDirector extends Employee {

    public ManagingDirector(String name, Bank bank) {
        super(name, bank);
    }

    @Override
    public void changeInterest(String name, Double newInterest) {
        bank.changeInterest(name, newInterest);
    }

}
