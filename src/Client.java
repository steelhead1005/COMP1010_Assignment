import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Character testChar = new Character(null, 0, 0, 0, 0, 0);
        Class testClass = new Class(null);
        Race testRace = new Race(null, null, null);
        Equipment testEquip = new Equipment(null);
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
                System.out.println("Choose a Paladin Equipment: 'Holy Hammer', 'Divine Doublet', 'Flame of Faith'");
                String paladinEquip = scanner.nextLine();
                switch (paladinEquip) {
                    case "Holy Hammer":
                        testEquip.name = paladinEquip;
                        break;
                    case "Divine Doublet":
                        testEquip.name = paladinEquip;
                        break;
                    case "Flame of Faith":
                        testEquip.name = paladinEquip;
                        break;
                    default:
                        break;
                }
                break;
            case "Rogue":
                testClass.name = classCheck;
                System.out.println("Choose a Rogue Equipment: 'Stealthy Shoes', 'Dangerous Dagger', 'Cunning Caltrops'");
                String rogueEquip = scanner.nextLine();
                switch (rogueEquip) {
                    case "Stealthy Shoes":
                        testEquip.name = rogueEquip;
                        break;
                    case "Dangerous Dagger":
                        testEquip.name = rogueEquip;
                        break;
                    case "Cunning Caltrops":
                        testEquip.name = rogueEquip;
                        break;
                    default:
                        break;
                }
                break;
            case "Barbarian":
                testClass.name = classCheck;
                System.out.println("Choose a Barbarian Equipment: 'Rage Remedy', 'Brutal Broadaxe', 'Savage Shield'");
                String barbEquip = scanner.nextLine();
                switch (barbEquip) {
                    case "Rage Remedy":
                        testEquip.name = barbEquip;
                        break;
                    case "Brutal Broadaxe":
                        testEquip.name = barbEquip;
                        break;
                    case "Savage Shield":
                        testEquip.name = barbEquip;
                        break;
                    default:
                        break;
                }
                break;
                
            case "Druid":
                testClass.name = classCheck;
                System.out.println("Choose a Druid Equipment: 'Faerie Flask', 'Brair Bindings', 'Willow Whistle'");
                String druidEquip = scanner.nextLine();
                switch (druidEquip) {
                    case "Faerie Flask":
                        testEquip.name = druidEquip;
                        break;
                    case "Brair Bindings":
                        testEquip.name = druidEquip;
                        break;
                    case "Willow Whistle":
                        testEquip.name = druidEquip;
                        break;
                    default:
                        break;
                }
                break;
    
            case "Wizard":
                testClass.name = classCheck;
                System.out.println("Choose a Wizard Equipment: 'Crystal Cauldron', 'Glowing Gemstone', 'Arcane Amulet'");
                String wizEquip = scanner.nextLine();
                switch (wizEquip) {
                    case "Rage Remedy":
                        testEquip.name = wizEquip;
                        break;
                    case "Brutal Broadaxe":
                        testEquip.name = wizEquip;
                        break;
                    case "Savage Shield":
                        testEquip.name = wizEquip;
                        break;
                    default:
                        break;
                }
                break;
            default:
               break;
        }
        testChar.Class = testClass;
        testChar.Equipment = testEquip;
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
