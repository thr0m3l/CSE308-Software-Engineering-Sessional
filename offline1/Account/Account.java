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

    public Account(Double minFirstDeposit, Double minDeposit, Double minWithdraw, Double maxWithdraw,
            Double minWithdrawalPeriod, Double maxLoan, Double depositInterest, Double serviceCharge, Bank bank,
            String name, Double firstDeposit) {
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
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("First deposit is lower than minimum allowable first deposit");
            }
        } else {
            balance += firstDeposit;
        }

    }

    public String getName() {
        return this.name;
    }

    public void deposit(Double amount) {
        if (amount < minDeposit) {
            try {
                throw new Exception("Deposit failed");
            } catch (Exception e) {
                System.err.println("Deposit amount is less than minimum Deposit amount: " + minDeposit + "$ ;");
            }
        }

        balance += amount;
    }

    public void withdraw(Double amount) {
        if (amount > maxWithdraw || amount < minWithdraw || amount <= balance) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid Withdraw amount; Current balance: " + queryDeposit() + "$");
            }
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
}
