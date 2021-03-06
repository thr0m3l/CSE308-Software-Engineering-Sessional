package Account;

import Bank.*;

public abstract class Account {
    protected Double minFirstDeposit;
    protected Double minDeposit;

    protected Double minWithdraw;
    protected Double maxWithdraw;
    protected Double minWithdrawalPeriod;

    protected Double balance;
    protected Double loanBalance;
    protected Double createdOn;

    protected Double maxLoan;
    protected Double loanInterest;

    protected Double depositInterest;
    protected Double serviceCharge;

    public Bank bank;
    protected String name;

    public String getName() {
        return this.name;
    }

    public void deposit(Double amount) throws Exception {
        if (amount < minDeposit) {
            throw new Exception("Deposit failed");
        }

        if (balance == null) {
            balance = 0.0;
        }
        balance += amount;
    }

    public abstract void withdraw(Double amount) throws Exception;

    public void approveLoan(Double amount) {
        loanBalance += amount;
        balance += amount;
    }

    public Double queryDeposit() {
        return balance;
    }

    public void loanInterest() {
        balance -= loanBalance * (loanInterest / 100);
    }

    public void depositInterest() {
        balance += balance * (depositInterest / 100);
    }

    public void serviceCharge() {
        balance -= serviceCharge;
    }

    public void yearEnd() {
        depositInterest();
        loanInterest();
        serviceCharge();
    }

    public Double getMaxLoan() {
        return maxLoan;
    }

    public void setInterest(Double newInterest) {
        depositInterest = newInterest;
    }
}
