package Account;

import Bank.Bank;

public class SavingsAccount extends Account {

    public SavingsAccount(Bank bank, String name, Double firstDeposit) {

        super(0.0, 0.0, 0.0, Double.MAX_VALUE, 0.0, 10000.0, 10.0, 500.0, bank, name, firstDeposit);

    }

    @Override
    public void withdraw(Double amount) {
        if (super.balance - amount < 1000) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println(
                        "A savings account cannot withdraw if the withdrawal results in a deposit of less than 1,000$.");
            }
        }
        super.withdraw(amount);
    }

}