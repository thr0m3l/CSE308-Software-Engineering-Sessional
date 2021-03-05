import java.util.ArrayList;
import java.util.HashMap;

class Loan {
    public Double amount;
    public String name;

    public Loan(Double amount, String name) {
        this.amount = amount;
        this.name = name;
    }
}

public class Bank {
    // Eager Initialization
    private static Bank _bank = new Bank();

    private Double internalFund;
    private HashMap<String, Account> accounts = new HashMap<String, Account>();
    private ArrayList<Loan> loanRequests = new ArrayList<Loan>();

    private Bank() {
        // Singleton Pattern
        this.internalFund = 1000000.0;
    }

    public static Bank getBank() {
        return _bank;
    }

    public void createAccount(String name, String type, Double amount) {
        if (accounts.containsKey(name)) {
            System.err.println("Account already exists");
            return;
        }

        try {
            if (type.equals("Student")) {
                accounts.put(name, new StudentAccount(name, amount));
            } else if (type.equals("Fixed Deposit")) {
                // TODO: Fixed Deposit
            } else if (type.equals("Savings")) {
                // TODO: Fixed Deposit
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void requestLoan(Account acc, Double amount) {
        loanRequests.add(new Loan(amount, acc.getName()));
    }

    public void approveLoan() {

    }

}