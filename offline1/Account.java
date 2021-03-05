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

    protected Bank bank;
    protected String name;

    public String getName() {
        return this.name;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public abstract void withdraw(Double amount);

    public void requestLoan(Double amount) {

        if (amount > maxLoan)
            return;
        loanInterest = 10.0;
        bank.requestLoan(this, amount);

    }

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
}
