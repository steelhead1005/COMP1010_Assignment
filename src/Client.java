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
        System.out.print("Press ENTER to roll for health: ");
        scanner.nextLine();
        int rolledHealth = (int)(Math.random() * 50 + 1);
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
        System.out.println("Choose a race: 'Human', 'Orc', 'Elf', 'Dwarf', 'Undead'");
        String raceCheck = scanner.nextLine();
        // This will need to be abstracted away to another file
        switch (raceCheck) {
            case "Human": case "human": case "H": case "h":
                testRace.name = raceCheck;
                System.out.println("Pick 2 stats to +1: 'Health', 'Strength', 'Intelligence', 'Dexterity', 'Defence'");
                String nameStat1 = scanner.nextLine();
                String nameStat2 = scanner.nextLine();
                StatMod hStat1 = new StatMod(nameStat1, 1);
                StatMod hStat2 = new StatMod(nameStat2, 1);
                if (hStat1.statToMod == "Health" || hStat2.statToMod == "Health") {
                    testChar.health += 1;
                }
                if (hStat1.statToMod == "Strength" || hStat2.statToMod == "Strength") {
                    testChar.strength += 1;
                }
                if (hStat1.statToMod == "Intelligence" || hStat2.statToMod == "Intelligence") {
                    testChar.intelligence += 1;
                }
                if (hStat1.statToMod == "Dexterity" || hStat2.statToMod == "Dexterity") {
                    testChar.dexterity += 1;
                }
                if (hStat1.statToMod == "Defence" || hStat2.statToMod == "Defence") {
                    testChar.defence += 1;
                }
                System.out.printf("Your %s increased by 1 and your %s increased by 1.%n", nameStat1, nameStat2);
                break;
            case "Orc": case "orc": case "O": case "o":
                testRace.name = raceCheck;
                StatMod oStat1 = new StatMod("Strength", 2);
                StatMod oStat2 = new StatMod("Intelligence", -1);
                testChar.strength += 2;
                testChar.intelligence -= 1;
                System.out.println("Your Strength increased by 2 and your Intelligence decreased by 1.");
                break;
            case "Elf": case "elf": case "E": case "e":
                testRace.name = raceCheck;
                StatMod eStat1 = new StatMod("Dexterity", 2);
                StatMod eStat2 = new StatMod("Strength", -1);
                testChar.dexterity += 2;
                testChar.strength -= 1;
                System.out.println("Your Dexterity increased by 2 and your Strength decreased by 1.");
                break;
            case "Dwarf": case "dwarf": case "D": case "d":
                testRace.name = raceCheck;
                StatMod dStat1 = new StatMod("Defence", 2);
                StatMod dStat2 = new StatMod("Dexterity", -1);
                testChar.defence += 2;
                testChar.dexterity -= 1;
                System.out.println("Your Defence increased by 2 and your Dexterity decreased by 1.");
                break;
            case "Undead": case "undead": case "U": case "u":
                testRace.name = raceCheck;
                StatMod uStat1 = new StatMod("Intelligence", 2);
                StatMod uStat2 = new StatMod("Defence", -1);
                testChar.intelligence += 2;
                testChar.defence -= 1;
                System.out.println("Your Intelligence increased by 2 and your Defence decreased by 1.");
                break;
            default:
                break;
        }
        testChar.Race = testRace;
        System.out.println("Choose a class: 'Paladin', 'Rogue', 'Druid', 'Wizard', 'Barbarian'");
        String classCheck = scanner.nextLine();
        // This will need to be abstracted away to another file
        switch (classCheck) {
            case "Paladin": case "paladin": case "P": case "p":
                testClass.name = "Paladin";
                System.out.println("Choose a Paladin Equipment: 'Holy Hammer', 'Divine Doublet', 'Flame of Faith'");
                String paladinEquip = scanner.nextLine();
                switch (paladinEquip) {
                    case "Holy Hammer": case "holy hammer": case "H": case "h":
                        testEquip.name = "Holy Hammer";
                        break;
                    case "Divine Doublet": case "divine doublet": case "D": case "d":
                        testEquip.name = "Divine Doublet";
                        break;
                    case "Flame of Faith": case "flame of faith": case "F": case "f":
                        testEquip.name = "Flame of Faith";
                        break;
                    default:
                        break;
                }
                break;
            case "Rogue": case "rogue": case "R": case "r":
                testClass.name = "Rogue";
                System.out.println("Choose a Rogue Equipment: 'Stealthy Shoes', 'Dangerous Dagger', 'Cunning Caltrops'");
                String rogueEquip = scanner.nextLine();
                switch (rogueEquip) {
                    case "Stealthy Shoes": case "stealthy shoes": case "S": case "s":
                        testEquip.name = "Stealthy Shoes";
                        break;
                    case "Dangerous Dagger": case "dangerous dagger": case "D": case "d":
                        testEquip.name = "Dangerous Dagger";
                        break;
                    case "Cunning Caltrops": case "cunning caltrops": case "C": case "c":
                        testEquip.name = "Cunning Caltrops";
                        break;
                    default:
                        break;
                }
                break;
            case "Barbarian": case "barbarian": case "B": case "b":
                testClass.name = "Barbarian";
                System.out.println("Choose a Barbarian Equipment: 'Rage Remedy', 'Brutal Broadaxe', 'Savage Shield'");
                String barbEquip = scanner.nextLine();
                switch (barbEquip) {
                    case "Rage Remedy": case "rage remedy": case "R": case "r":
                        testEquip.name = "Rage Remedy";
                        break;
                    case "Brutal Broadaxe": case "brutal broadaxe": case "B": case "b":
                        testEquip.name = "Brutal Broadaxe";
                        break;
                    case "Savage Shield": case "savage shield": case "S": case "s":
                        testEquip.name = "Savage Shield";
                        break;
                    default:
                        break;
                }
                break;
                
            case "Druid": case "druid": case "D": case "d":
                testClass.name = "Druid";
                System.out.println("Choose a Druid Equipment: 'Faerie Flask', 'Brair Bindings', 'Willow Whistle'");
                String druidEquip = scanner.nextLine();
                switch (druidEquip) {
                    case "Faerie Flask": case "faerie flask": case "F": case "f":
                        testEquip.name = "Faerie Flask";
                        break;
                    case "Brair Bindings": case "brair bindings": case "B": case "b":
                        testEquip.name = "Brair Bindings";
                        break;
                    case "Willow Whistle": case "willow whistle": case "W": case "w":
                        testEquip.name = "Willow Whistle";
                        break;
                    default:
                        break;
                }
                break;
    
            case "Wizard": case "wizard": case "W": case "w":
                testClass.name = classCheck;
                System.out.println("Choose a Wizard Equipment: 'Crystal Cauldron', 'Glowing Gemstone', 'Arcane Amulet'");
                String wizEquip = scanner.nextLine();
                switch (wizEquip) {
                    case "Crystal Cauldron": case "crystal cauldron": case "C": case "c":
                        testEquip.name = "Crystal Cauldron";
                        break;
                    case "Glowing Gemstone": case "glowing gemstome": case "G": case "g":
                        testEquip.name = "Glowing Gemstone";
                        break;
                    case "Arcane Amulet": case "arcane amulet": case "A": case "a":
                        testEquip.name = "Arcane Amulet";
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
        System.out.println(testChar);
        scanner.close();
    }
}
