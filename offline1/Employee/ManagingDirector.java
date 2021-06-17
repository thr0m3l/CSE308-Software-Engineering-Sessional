package Employee;

import Bank.Bank;

public class ManagingDirector extends Employee {

    public ManagingDirector(String name, Bank bank) {
        super(name, bank);
    }

    @Override
    public void changeInterest(String type, Double newInterest) {
        bank.changeInterest(type, newInterest);
    }

    @Override
    public void seeInternalFund() {
        System.out.println("Internal fund: " + bank.getInternalFund() + "$");
    }

}
