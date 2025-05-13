import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Character testChar = new Character(null, 0, 0, 0, 0, 0);
        System.out.println("Whats your characters name: ");
        testChar.name = scanner.nextLine();
        System.out.print("Press ENTER to roll for health: ");
        scanner.nextLine();
        int rolledHealth = (int)(Math.random() * 101);
        testChar.health = rolledHealth;
        System.out.println("You rolled: " + rolledHealth);
        System.out.print("Press ENTER to roll for strength: ");
        scanner.nextLine();
        int rolledStrength = (int)(Math.random() * 101);
        testChar.strength = rolledStrength;
        System.out.println("You rolled: " + rolledStrength);
        System.out.print("Press ENTER to roll for intelligence: ");
        scanner.nextLine();
        int rolledInt = (int)(Math.random() * 101);
        testChar.intelligence = rolledInt;
        System.out.println("You rolled: " + rolledInt);
        System.out.print("Press ENTER to roll for dexterity: ");
        scanner.nextLine();
        int rolledDex = (int)(Math.random() * 101);
        testChar.dexterity = rolledDex;
        System.out.println("You rolled: " + rolledDex);
        System.out.print("Press ENTER to roll for defence: ");
        scanner.nextLine();
        int rolledDefence = (int)(Math.random() * 101);
        testChar.defence = rolledDefence;
        System.out.println("You rolled: " + rolledDefence);
        System.out.println(testChar);
    }
}
