import Client.Client;
import Client.Observer;
import Client.User;
import Server.StockPlatform;

import java.util.Scanner;

public class Main {

	public static boolean isLoggedIn = false;
	public static User user = null;

	public static void main(String[] args) {
		Client client = new Client("localhost",8818);
		Thread t = new Thread(client);
		t.start();

		Scanner scanner = new Scanner(System.in);

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
