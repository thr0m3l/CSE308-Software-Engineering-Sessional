package Bank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import Account.*;
import Employee.*;

class InvalidUserException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidUserException(String s) {
        super(s);
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

        // Initializes all the employees
        employees.put("MD", new ManagingDirector("MD", this));
        employees.put("O1", new Officer("O1", this));
        employees.put("O2", new Officer("O2", this));
        employees.put("C1", new Cashier("C1", this));
        employees.put("C2", new Cashier("C2", this));
        employees.put("C3", new Cashier("C3", this));
        employees.put("C4", new Cashier("C4", this));
        employees.put("C5", new Cashier("C5", this));

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
                accounts.put(name, new StudentAccount(this, name, amount));
            } else if (type.equals("Fixed")) {
                accounts.put(name, new FixedDepositAccount(this, name, amount));
            } else if (type.equals("Savings")) {
                accounts.put(name, new SavingsAccount(this, name, amount));
            }
        } catch (Exception e) {
            System.err.println("Account creation failed: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void requestLoan(String name, Double amount) {
        try {
            Account acc = findAccount(name);
            Loan loan = acc.checkLoanRequest(name, amount);
            loanRequests.add(loan);
            System.out.println("Loan request successful. Sent for approval");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void approveLoan() {

        for (Loan loan : loanRequests) {
            try {
                Account acc = findAccount(loan.name);
                acc.approveLoan(loan.amount);
                System.out.println("Loan for " + loan.name + " approved");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        loanRequests.clear();

    }

    public void deposit(String name, Double amount) {
        try {
            Account acc = findAccount(name);
            acc.deposit(amount);
            System.out.println("Deposited: " + amount + "$ ; " + "Current Balance: " + acc.queryDeposit() + "$ ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(String name, Double amount) {
        try {
            Account acc = findAccount(name);
            acc.withdraw(amount);
            System.out.println("Withdrawn: " + amount + "$ ; " + "Current Balance: " + acc.queryDeposit() + "$ ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void query(String name) {
        Account acc = null;

        try {
            acc = findAccount(name);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out
                .println("Current balance: " + acc.queryDeposit() + "$ ; Loan balance: " + acc.getLoanBalance() + "$");

    }

    public void yearEnd() {
        this.time++;
        Collection<Account> accountList = accounts.values();

        for (Account acc : accountList) {
            acc.yearEnd();
        }

        System.out.println("1 year passed");
    }

    public Account findAccount(String name) throws Exception {
        if (name == null) {
            throw new InvalidUserException("Invalid Account! Please open an valid account first");
        } else {
            Account acc = null;
            acc = accounts.get(name);

            if (acc == null) {
                throw new InvalidUserException("Unable to find account");
            } else
                return acc;

        }
    }

    public Employee findEmployee(String name) throws Exception {
        if (name == null) {
            throw new InvalidUserException("Invalid Employee ID!");
        } else {
            Employee emp = null;
            emp = employees.get(name);

            if (emp != null) {
                String msg = loanRequests.isEmpty() == true ? "" : "There are loan requests pending";
                System.out.println(name + " active. " + msg);
            }
            return emp;
        }
    }

    public void changeInterest(String type, Double newInterest) {
        Collection<Account> accountList = accounts.values();

        for (Account acc : accountList) {
            if (acc.getClass().getName().equals(type)) {
                acc.setInterest(newInterest);
            }
        }
    }

    public Double getInternalFund() {
        return internalFund;
    }

    public Integer getTime() {
        return time;
    }

}