import Component.*;
import Mediator.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Organization> organizations = new ArrayList<>();
        Organization jpdc = new JPDC();
        Organization jrta = new JRTA();
        Organization jtrc = new JTRC();
        Organization jwsa = new JWSA();
        organizations.add(jpdc);
        organizations.add(jrta);
        organizations.add(jtrc);
        organizations.add(jwsa);
        Mediator mediator = new JCC();


        Scanner scanner = new Scanner(System.in);

        while (true){
            String token[] = scanner.nextLine().split(" ");

            if (token[0].equalsIgnoreCase("init")){
                mediator.init(organizations);
            } else if (token[0].equalsIgnoreCase("JWSA")){
                if (token[1].equalsIgnoreCase("SERVE")){
                    jwsa.serveRequest();
                } else {
                    jwsa.sendRequest(token[1]);
                }

            } else if (token[0].equalsIgnoreCase("JRTA")){
                if (token[1].equalsIgnoreCase("SERVE")){
                    jrta.serveRequest();
                } else {
                    jrta.sendRequest(token[1]);
                }
            } else if (token[0].equalsIgnoreCase("JTRC")){
                if (token[1].equalsIgnoreCase("SERVE")){
                    jtrc.serveRequest();
                } else {
                    jtrc.sendRequest(token[1]);
                }
            } else if (token[0].equalsIgnoreCase("JPDC")){
                if (token[1].equalsIgnoreCase("SERVE")){
                    jpdc.serveRequest();
                } else {
                    jpdc.sendRequest(token[1]);
                }
            }
        }

    }

}
