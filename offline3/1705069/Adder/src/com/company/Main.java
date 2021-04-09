package com.company;

import CharAdder.CharAdder;

public class Main {

    public static void main(String[] args) {
        CharAdder adder = new CharAdder("numbers.txt");
        System.out.println("Sum of characters = " + adder.calculateSum());
    }
}
