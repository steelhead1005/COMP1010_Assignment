package COMP1010.main;

import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        GameLogic.gameStart();
        System.out.println("Your team is: " + GameLogic.listofChar.get(0).toName() + GameLogic.listofChar.get(1).toName() + GameLogic.listofChar.get(2).toName());
        scanner.close();
        System.out.println("Updated Github");
    }
}

