package Account;

public class FixedDepositAccount extends Account {
    public FixedDepositAccount(String name, Double firstDeposit) throws Exception {
        super.minFirstDeposit = 100000.0;
        super.minDeposit = 50000.0;
        super.minWithdraw = 0.0;
        super.maxWithdraw = 10000.0;
        super.minWithdrawalPeriod = 1.0;
        super.maxLoan = 100000.0;
        super.loanInterest = 10.0;
        super.depositInterest = 15.0;
        super.createdOn = 0.0;
        super.serviceCharge = 500.0;
        super.name = name;
        super.balance = 0.0;

        if (firstDeposit < super.minFirstDeposit) {
            throw new Exception("First deposit is lower than minimum allowable first deposit");
        }

        super.deposit(firstDeposit);

        System.out.println(
                "Fixed Deposit account for " + super.name + " created; Initial Balance: " + super.balance + "$");
    }

    @Override
    public void withdraw(Double amount) throws Exception {
        if (amount > maxWithdraw || amount < minWithdraw) {
            throw new Exception("Invalid Withdraw Amount");
        }

    }
}