import Client.Client;
import Client.Observer;
import Client.User;
import Server.StockPlatform;

import java.util.Scanner;

public class Main {

	public static boolean isLoggedIn = false;
	public static User user = null;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean admin = false;
		System.out.println("Access level? U/A");
		String isAdmin = scanner.nextLine();
		if (isAdmin.equalsIgnoreCase("A")){
			admin = true;
		}
		Client client = new Client("localhost",8818, admin);
		Thread t = new Thread(client);
		t.start();



		while (true){
			String msg = scanner.nextLine();
			client.send(msg);
			try{
				Thread.sleep(100);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
