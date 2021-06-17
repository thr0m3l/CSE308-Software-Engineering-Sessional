package com.company;

import Device.Enumerations.Connection;
import Device.Microcontroller.Microcontroller;
import Package.PackageBuilderDirector;
import WebFramework.WebFramework;
import WebFramework.WebFrameworkFactory;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Integer choice;
        String pack = "";
        Scanner sc = new Scanner(System.in);
        String command;
        String[] tokens;
        Microcontroller mc = null;

        while(true){
            System.out.println("Available commands :");
            System.out.println(">> build package_name");
            System.out.println(">> set connection_type");
            System.out.println(">> get framework_name");
            System.out.println(">> exit\n");

            command = sc.nextLine();
            tokens = command.split(" ");

            if (tokens[0].equalsIgnoreCase("build")){
                PackageBuilderDirector builderDirector = new PackageBuilderDirector(tokens[1]);
                mc = builderDirector.buildPackage();
                System.out.println(mc);
            }
            else if (tokens[0].equalsIgnoreCase("set")){
                Connection conn = null;

                if(tokens[1].equalsIgnoreCase("Wifi")){
                    conn = Connection.WIFI;
                } else if (tokens[1].equalsIgnoreCase("GSM")){
                    conn = Connection.GSM;
                } else if (tokens[1].equalsIgnoreCase("Ethernet")){
                    conn = Connection.Ethernet;
                }


                try {
                    mc.setConnection(conn);
                    System.out.println(mc);
                } catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }
            else if (tokens[0].equalsIgnoreCase("get")){
                WebFrameworkFactory frameworkFactory = new WebFrameworkFactory();
                WebFramework framework = frameworkFactory.getFramework(tokens[1]);
                System.out.println(framework);
            }
            else if (tokens[0].equalsIgnoreCase("exit")){
                break;
            }
        }
        sc.close();

    }
}
