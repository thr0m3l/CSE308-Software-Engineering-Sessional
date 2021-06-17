package Editor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Editor editor = null;

        while(true){
            String[] command = sc.nextLine().split(" ");

            if (command[0].equalsIgnoreCase("exit")){
                break;
            } else if (command[0].equalsIgnoreCase("open")){
                editor = Editor.getEditor();
            } else if (command[0].equalsIgnoreCase("set")){
                editor.setLanguage(command[1]);
            }
        }
        sc.close();
    }
}
