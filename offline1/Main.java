import java.util.Scanner;
import Bank.Bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getBank();
        Scanner sc = new Scanner(System.in);
        String[] tokens;
        String activeAccount = null;

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
                bank.query(activeAccount);
            } else if (tokens[0].equals("Close")) {
                activeAccount = null;
            } else if (tokens[0].equals("Open")) {
                activeAccount = tokens[1];
            }
        }
        sc.close();
    }
}