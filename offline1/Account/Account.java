package Account;

import Account.FixedDepositAccount.FixedDepositAccountWithdrawException;
import Account.SavingsAccount.SavingsAccountWithdrawException;
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

    class InvalidFirstDepositException extends Exception {

        private static final long serialVersionUID = 1L;

        public InvalidFirstDepositException(String s) {
            super(s);
        }

    }

    class InvalidAmountException extends Exception {

        private static final long serialVersionUID = 1L;

        public InvalidAmountException(String s) {
            super(s);
        }

    }

    class InvalidLoanRequestException extends Exception {

        private static final long serialVersionUID = 1L;

        public InvalidLoanRequestException(String s) {
            super(s);
        }

    }

    public Account(Double minFirstDeposit, Double minDeposit, Double minWithdraw, Double maxWithdraw,
            Double minWithdrawalPeriod, Double maxLoan, Double depositInterest, Double serviceCharge, Bank bank,
            String name, Double firstDeposit) throws InvalidFirstDepositException {
        this.minFirstDeposit = minFirstDeposit;
        this.minDeposit = minDeposit;
        this.minWithdraw = minWithdraw;
        this.maxWithdraw = maxWithdraw;
        this.minWithdrawalPeriod = minWithdrawalPeriod;
        this.maxLoan = maxLoan;
        this.depositInterest = depositInterest;
        this.serviceCharge = serviceCharge;
        this.bank = bank;
        this.name = name;

        this.loanInterest = 10.0;
        this.loanBalance = 0.0;
        this.balance = 0.0;

        if (firstDeposit < minFirstDeposit) {
            throw new InvalidFirstDepositException("First deposit is lower than minimum allowable first deposit");

        } else {
            balance += firstDeposit;
        }

    }

    public String getName() {
        return this.name;
    }

    public void deposit(Double amount) throws InvalidAmountException {
        if (amount < minDeposit) {
            throw new InvalidAmountException(
                    "Deposit amount is less than minimum Deposit amount: " + minDeposit + "$ ;");
        }

        balance += amount;
    }

    public void withdraw(Double amount)
            throws InvalidAmountException, SavingsAccountWithdrawException, FixedDepositAccountWithdrawException {
        if (amount > maxWithdraw || amount < minWithdraw || amount > balance) {
            throw new InvalidAmountException("Invalid Withdraw amount; Current balance: " + queryDeposit() + "$");
        }
        balance -= amount;
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

    public Double getLoanBalance() {
        return loanBalance;
    }

    public Loan checkLoanRequest(String name, Double amount) throws InvalidLoanRequestException {
        if (amount > maxLoan)
            throw new InvalidLoanRequestException(
                    "The amount exceeds maximum value allowable for this type of account. Maximum allowable loan: "
                            + maxLoan + "$");

        return new Loan(amount, name);
    }
}
