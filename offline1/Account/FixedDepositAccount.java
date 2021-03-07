package Account;

import Bank.Bank;

public class FixedDepositAccount extends Account {
    public FixedDepositAccount(Bank bank, String name, Double firstDeposit) {

        super(100000.0, 50000.0, 0.0, Double.MAX_VALUE, 1.0, 100000.0, 15.0, 500.0, bank, name, firstDeposit);

    }

    @Override
    public void withdraw(Double amount) {
        if (bank.getTime() - super.createdOn < minWithdrawalPeriod) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("The account has not reached maturity of one year");
            }
        }
        super.withdraw(amount);

    }
}