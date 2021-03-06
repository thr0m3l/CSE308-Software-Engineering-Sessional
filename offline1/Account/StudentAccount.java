package Account;

public class StudentAccount extends Account {
    public StudentAccount(String name, Double firstDeposit) throws Exception {
        super.minFirstDeposit = 0.0;
        super.minDeposit = 0.0;
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
        super.loanBalance = 0.0;

        if (firstDeposit < super.minFirstDeposit) {
            throw new Exception("First deposit is lower than minimum allowable first deposit");
        }

        super.deposit(firstDeposit);

        System.out.println("Student account for " + super.name + " created; Initial Balance: " + super.balance + "$");
    }

    @Override
    public void withdraw(Double amount) throws Exception {
        if (amount > maxWithdraw || amount < minWithdraw || amount > balance) {
            throw new Exception("Withdraw failed");
        }
        balance -= amount;
    }
}