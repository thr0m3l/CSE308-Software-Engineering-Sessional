package Account;

public class SavingsAccount extends Account {

    public SavingsAccount(String name, Double firstDeposit) throws Exception {
        super.minFirstDeposit = 0.0;
        super.minDeposit = 50000.0;
        super.minWithdraw = 0.0;
        super.maxWithdraw = 10000.0;
        super.minWithdrawalPeriod = 0.0;
        super.maxLoan = 1000.0;
        super.loanInterest = 10.0;
        super.depositInterest = 5.0;
        super.createdOn = 0.0;
        super.serviceCharge = 0.0;
        super.name = name;
        super.balance = 0.0;

        if (firstDeposit < super.minFirstDeposit) {
            throw new Exception("First deposit is lower than minimum allowable first deposit");
        }

        super.deposit(firstDeposit);

        System.out.println("Savings account for " + super.name + " created; Initial Balance: " + super.balance + "$");
    }

    @Override
    public void withdraw(Double amount) throws Exception {
        if (amount > maxWithdraw || amount < minWithdraw) {

        }
    }

}