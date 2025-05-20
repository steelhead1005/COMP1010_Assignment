import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Character testChar = new Character(null, 0, 0, 0, 0, 0);
        Class testClass = new Class(null);
        Race testRace = new Race(null, null, null);
        System.out.println("Whats your characters name: ");
        testChar.name = scanner.nextLine();
        System.out.println("Choose a race: 'Human', 'Orc', 'Elf', 'Dwarf', 'Undead'");
        String raceCheck = scanner.nextLine();
        switch (raceCheck) {
            case "Human":
                testRace.name = raceCheck;
                break;
            case "Orc":
                testRace.name = raceCheck;
                break;
            case "Elf":
                testRace.name = raceCheck;
                break;
            case "Dwarf":
                testRace.name = raceCheck;
                break;
            case "Undead":
                testRace.name = raceCheck;
                break;
            default:
                break;
        }
        testChar.Race = testRace;
        System.out.println("Choose a class: 'Paladin', 'Rogue', 'Druid', 'Wizard', 'Barbarian'");
        String classCheck = scanner.nextLine();
        switch (classCheck) {
            case "Paladin":
                testClass.name = classCheck;
                System.out.println("Choose a Paladin Equipment: 'Holy Hammer', 'Divine ___', 'Flame of Faith'");
                String paladinEquip = scanner.nextLine();
                switch (paladinEquip) {
                    case "Holy Hammer":
                        testClass.name = paladinEquip;
                        break;
                    case "Divine ___":
                        testClass.name = paladinEquip;
                        break;
                    case "Flame of Faith":
                        testClass.name = paladinEquip;
                        break;
                    default:
                        break;
                }
                break;
            case "Rogue":
                testClass.name = classCheck;
                System.out.println("Choose a Rogue Equipment: 'Stealthy Shoes', 'Dangerous Dagger', 'Cunning Cudgel'");
                String rogueEquip = scanner.nextLine();
                switch (rogueEquip) {
                    case "Stealthy Shoes":
                        testClass.name = rogueEquip;
                        break;
                    case "Dangerous Dagger":
                        testClass.name = rogueEquip;
                        break;
                    case "Cunning Cudgel":
                        testClass.name = rogueEquip;
                        break;
                    default:
                        break;
                break;
            case "Barbarian":
                testClass.name = classCheck;
                System.out.println("Choose a Barbarian Equipment: 'Raging __', '");
                break;
            case "Druid":
                testClass.name = classCheck;
                break;
            case "Wizard":
                testClass.name = classCheck;
                break;
            default:
                break;
        }
        testChar.Class = testClass;
        System.out.print("Press ENTER to roll for health: ");
        scanner.nextLine();
        int rolledHealth = (int)(Math.random() * 101);
        testChar.health = rolledHealth;
        System.out.println("You rolled: " + rolledHealth);
        System.out.print("Press ENTER to roll for strength: ");
        scanner.nextLine();
        int rolledStrength = (int)(Math.random() * 10);
        testChar.strength = rolledStrength;
        System.out.println("You rolled: " + rolledStrength);
        System.out.print("Press ENTER to roll for intelligence: ");
        scanner.nextLine();
        int rolledInt = (int)(Math.random() * 10);
        testChar.intelligence = rolledInt;
        System.out.println("You rolled: " + rolledInt);
        System.out.print("Press ENTER to roll for dexterity: ");
        scanner.nextLine();
        int rolledDex = (int)(Math.random() * 10);
        testChar.dexterity = rolledDex;
        System.out.println("You rolled: " + rolledDex);
        System.out.print("Press ENTER to roll for defence: ");
        scanner.nextLine();
        int rolledDefence = (int)(Math.random() * 10);
        testChar.defence = rolledDefence;
        System.out.println("You rolled: " + rolledDefence);
        System.out.println(testChar);
        scanner.close();
    }
}
