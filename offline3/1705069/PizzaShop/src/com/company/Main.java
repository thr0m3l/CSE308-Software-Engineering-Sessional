package com.company;

import java.util.Scanner;
import Pizza.*;
import Pizza.Decorator.OnionRings;
import Pizza.Decorator.PizzaDecorator;

public class Main {

    public static void main(String[] args) {
	    int choice;
	    Pizza pizza;

        System.out.println("Enter a choice");
        System.out.println("1. Pizza without anything");
        System.out.println("2. Pizza with appetizer");
        System.out.println("3. Combo Meal");

        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        if (choice == 1){
            System.out.println("1. Beef Pizza");
            System.out.println("2. Veggie Pizza");
            int pizzaChoice = sc.nextInt();
            if (pizzaChoice == 1) pizza = new BeefPizza();
            else if (pizzaChoice == 2) pizza = new VeggiePiza();
        } else if (choice == 2){
            System.out.println("Choose an appetizer");
            System.out.println("1. Onion Rings");
            System.out.println("2. French Fry");
            int apChoice = sc.nextInt();
            PizzaDecorator pizzaDecorator;
            if (apChoice == 1){
                pizzaDecorator = new OnionRings(pizza);
            }
        } else if (choice == 3){

        }
    }
}
