package Bank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import Account.*;
import Employee.*;

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

    private HashMap<String, Employee> employees = new HashMap<>();

    private Integer time;

    private Bank() {
        // Singleton Pattern
        this.internalFund = 1000000.0;
        time = 0;
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
                accounts.put(name, new FixedDepositAccount(name, amount));
            } else if (type.equals("Savings")) {
                accounts.put(name, new SavingsAccount(name, amount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void requestLoan(String name, Double amount) throws Exception {
        if (name == null) {
            System.err.println("Invalid Account! Please open an valid account first");
        } else {
            Account acc = accounts.get(name);
            if (amount <= acc.getMaxLoan()) {
                loanRequests.add(new Loan(amount, name));
                System.out.println("Loan request successful, sent for approval");
            } else {
                throw new Exception("Please enter a valid loan amount");
            }
        }
    }

    public void approveLoan(String activeEmployee) {
        // TODO: Loan Approval Logic
    }

    public void deposit(String name, Double amount) {
        try {
            Account acc = findAccount(name);
            acc.deposit(amount);
            System.out.println("Deposited: " + amount + "$ ; " + "Current Balance: " + acc.queryDeposit() + "$ ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdraw(String name, Double amount) {
        try {
            Account acc = findAccount(name);
            acc.withdraw(amount);
            System.out.println("Withdrawn: " + amount + "$ ; " + "Current Balance: " + acc.queryDeposit() + "$ ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void query(String name) {
        try {
            Account acc = findAccount(name);
            System.out.println("Current balance: " + acc.queryDeposit() + "$");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void yearEnd() {
        time++;
        Collection<Account> accountList = accounts.values();

        for (Account acc : accountList) {
            acc.yearEnd();
        }
    }

    public Account findAccount(String name) throws Exception {
        if (name == null) {
            throw new Exception("Invalid Account! Please open an valid account first");
        } else {
            Account acc = null;
            acc = accounts.get(name);

            if (acc == null) {
                throw new Exception("Unable to find account");
            } else
                return acc;

        }
    }

}