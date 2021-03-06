import java.util.Scanner;
import Bank.Bank;
import Employee.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getBank();
        Scanner sc = new Scanner(System.in);
        String[] tokens;
        String activeAccount = null;

        Employee activeEmployee = null;

        String command = new String("");
        while (!command.equals("exit")) {
            System.out.print(">> ");

            command = sc.nextLine();
            tokens = command.split(" ");

            if (tokens[0].equals("Create")) {
                bank.createAccount(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                activeAccount = tokens[1];
            } else if (tokens[0].equals("Deposit")) {
                bank.deposit(activeAccount, Double.parseDouble(tokens[1]));
            } else if (tokens[0].equals("Query")) {
                try {
                    System.out.println("Current balance: " + bank.query(activeAccount) + "$");
                } catch (Exception e) {
                    System.err.println("Invalid user");
                }
            } else if (tokens[0].equals("Close")) {
                if (activeAccount != null)
                    System.out.println("Transaction closed for " + activeAccount);
                else if (activeEmployee != null)
                    System.out.println("Operations closed for " + activeEmployee.getName());

                activeAccount = null;
                activeEmployee = null;

            } else if (tokens[0].equals("Open")) {
                try {
                    activeEmployee = bank.findEmployee(tokens[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (activeEmployee == null)
                    activeAccount = tokens[1];

            } else if (tokens[0].equals("Withdraw")) {
                bank.withdraw(activeAccount, Double.parseDouble(tokens[1]));
            } else if (tokens[0].equals("INC")) {
                bank.yearEnd();
            } else if (tokens[0].equals("Request")) {
                try {
                    bank.requestLoan(activeAccount, Double.parseDouble(tokens[1]));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.err.println("Loan Request failed");
                    e.printStackTrace();
                }
            }

            // Employee commands
            try {
                if (tokens[0].equals("See")) {
                    activeEmployee.seeInternalFund();
                } else if (tokens[0].equals("Approve")) {
                    activeEmployee.approveLoan();
                } else if (tokens[0].equals("Lookup")) {
                    activeEmployee.lookup(tokens[1]);
                } else if (tokens[0].equals("Change")) {
                    activeEmployee.changeInterest(tokens[1], Double.parseDouble(tokens[2]));
                }
            } catch (NullPointerException e) {
                System.err.print("Please open an Employee account first");
            }
        }
        sc.close();
    }
}