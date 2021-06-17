package Account;

import Account.SavingsAccount.SavingsAccountWithdrawException;
import Bank.Bank;

public class FixedDepositAccount extends Account {
    public FixedDepositAccount(Bank bank, String name, Double firstDeposit) throws Exception {

        super(100000.0, 50000.0, 0.0, Double.MAX_VALUE, 1.0, 100000.0, 15.0, 500.0, bank, name, firstDeposit);

    }

    class FixedDepositAccountWithdrawException extends Exception {

        private static final long serialVersionUID = 1L;

        public FixedDepositAccountWithdrawException(String s) {
            super(s);
        }

    }

    @Override
    public void withdraw(Double amount)
            throws InvalidAmountException, SavingsAccountWithdrawException, FixedDepositAccountWithdrawException {
        if (bank.getTime() - super.createdOn < minWithdrawalPeriod) {
            throw new FixedDepositAccountWithdrawException("The account has not reached maturity of one year");

        }
        super.withdraw(amount);

    }
}