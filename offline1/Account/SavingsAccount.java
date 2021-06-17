package Account;

import Account.FixedDepositAccount.FixedDepositAccountWithdrawException;
import Bank.Bank;

public class SavingsAccount extends Account {

    public SavingsAccount(Bank bank, String name, Double firstDeposit) throws Exception {

        super(0.0, 0.0, 0.0, Double.MAX_VALUE, 0.0, 10000.0, 10.0, 500.0, bank, name, firstDeposit);

    }

    class SavingsAccountWithdrawException extends Exception {

        private static final long serialVersionUID = 1L;

        public SavingsAccountWithdrawException(String s) {
            super(s);
        }

    }

    @Override
    public void withdraw(Double amount)
            throws InvalidAmountException, SavingsAccountWithdrawException, FixedDepositAccountWithdrawException {
        if (super.balance - amount < 1000) {

            throw new SavingsAccountWithdrawException(
                    "A savings account cannot withdraw if the withdrawal results in a deposit of less than 1,000$.");

        }
        super.withdraw(amount);
    }

}