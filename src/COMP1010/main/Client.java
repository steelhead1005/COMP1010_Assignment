package COMP1010.main;

import java.util.ArrayList;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> listofChar = new ArrayList<>();
        GameLogic.headingCreator("You are standing in an open field west of a white house.");
        GameLogic.pauseGame("Press ENTER to start the game: ");
        GameLogic.headingCreator("Create 3 characters to fight with to begin the game: ");
        while (true) {
            Character testChar = new Character(null, 0, 0, 0, 0, 0);
            Class testClass = new Class(null);
            Race testRace = new Race(null, null, null);
            Equipment testEquip = new Equipment(null);
            testChar.name = GameLogic.readInputString("Whats your characters name: ");
            GameLogic.pauseGame("Press ENTER to roll for health: ");
            int rolledHealth = (int)(Math.random() * 50 + 1);
            testChar.health = rolledHealth;
            System.out.println("You rolled: " + rolledHealth);
            GameLogic.pauseGame("Press ENTER to roll for strength: ");
            int rolledStrength = (int)(Math.random() * 10);
            testChar.strength = rolledStrength;
            System.out.println("You rolled: " + rolledStrength);
            GameLogic.pauseGame("Press ENTER to roll for intelligence: ");
            int rolledInt = (int)(Math.random() * 10);
            testChar.intelligence = rolledInt;
            System.out.println("You rolled: " + rolledInt);
            GameLogic.pauseGame("Press ENTER to roll for dexterity: ");
            int rolledDex = (int)(Math.random() * 10);
            testChar.dexterity = rolledDex;
            System.out.println("You rolled: " + rolledDex);
            GameLogic.pauseGame("Press ENTER to roll for defence: ");
            int rolledDefence = (int)(Math.random() * 10);
            testChar.defence = rolledDefence;
            System.out.println("You rolled: " + rolledDefence);
            int raceChoice = GameLogic.readInputInt("Choose a race: (1)'Human', (2)'Orc', (3)'Elf', (4)'Dwarf', (5)'Undead'", 5);
            // This will need to be abstracted away to another file
            switch (raceChoice) {
                case 1:
                    testRace.name = "Human";
                    int stat1 = GameLogic.readInputInt("Pick the first stat to '+1': (1)'Health', (2)'Strength', (3)'Intelligence', (4)'Dexterity', (5)'Defence'", 5);
                    int stat2 = GameLogic.readInputInt("Pick the second stat to '+1': (1)'Health', (2)'Strength', (3)'Intelligence', (4)'Dexterity', (5)'Defence'", 5);
                    StatMod hStat1 = new StatMod(stat1, 1);
                    StatMod hStat2 = new StatMod(stat2, 1);
                    String nameStat1;
                    String nameStat2;
                    switch (stat1) {
                        case 1:
                            testChar.health += 1;
                            nameStat1 = "Health";
                            break;
                        case 2:
                            testChar.strength += 1;
                            nameStat1 = "Strength";
                            break;
                        case 3:
                            testChar.intelligence += 1;
                            nameStat1 = "Intelligence";
                            break;
                        case 4:
                            testChar.dexterity += 1;
                            nameStat1 = "Dexterity";
                            break;
                        case 5:
                            testChar.defence += 1;
                            nameStat1 = "Defence";
                            break;
                        default:
                            nameStat1 = null;
                            break;
                    }
                    switch (stat2) {
                        case 1:
                            testChar.health += 1;
                            nameStat2 = "Health";
                            break;
                        case 2:
                            testChar.strength += 1;
                            nameStat2 = "Strength";
                            break;
                        case 3:
                            testChar.intelligence += 1;
                            nameStat2 = "Intelligence";
                            break;
                        case 4:
                            testChar.dexterity += 1;
                            nameStat2 = "Dexterity";
                            break;
                        case 5:
                            testChar.defence += 1;
                            nameStat2 = "Defence";
                            break;
                        default:
                            nameStat2 = null;
                            break;
                    }
                    if (stat1 == stat2){
                        System.out.printf("Your %s increased by 2.%n", nameStat1);
                    }
                    else {
                        System.out.printf("Your %s increased by 1 and your %s increased by 1.%n", nameStat1, nameStat2);
                    }
                    break;
                case 2:
                    testRace.name = "Orc";
                    StatMod oStat1 = new StatMod(2, 2);
                    StatMod oStat2 = new StatMod(3, -1);
                    testChar.strength += 2;
                    testChar.intelligence -= 1;
                    System.out.println("Your Strength increased by 2 and your Intelligence decreased by 1.");
                    break;
                case 3:
                    testRace.name = "Elf";
                    StatMod eStat1 = new StatMod(4, 2);
                    StatMod eStat2 = new StatMod(2, -1);
                    testChar.dexterity += 2;
                    testChar.strength -= 1;
                    System.out.println("Your Dexterity increased by 2 and your Strength decreased by 1.");
                    break;
                case 4:
                    testRace.name = "Dwarf";
                    StatMod dStat1 = new StatMod(5, 2);
                    StatMod dStat2 = new StatMod(4, -1);
                    testChar.defence += 2;
                    testChar.dexterity -= 1;
                    System.out.println("Your Defence increased by 2 and your Dexterity decreased by 1.");
                    break;
                case 5:
                    testRace.name = "Undead";
                    StatMod uStat1 = new StatMod(3, 2);
                    StatMod uStat2 = new StatMod(5, -1);
                    testChar.intelligence += 2;
                    testChar.defence -= 1;
                    System.out.println("Your Intelligence increased by 2 and your Defence decreased by 1.");
                    break;
                default:
                    break;
            }
            testChar.Race = testRace;
            int classChoice = GameLogic.readInputInt("Choose a class: (1)'Paladin', (2)'Rogue', (3)'Druid', (4)'Wizard', (5)'Barbarian'", 5);
            // This will need to be abstracted away to another file
            switch (classChoice) {
                case 1:
                    testClass.name = "Paladin";
                    int paladinEquip = GameLogic.readInputInt("Choose a Paladin Equipment: (1)'Holy Hammer', (2)'Divine Doublet', (3)'Flame of Faith'", 3);
                    switch (paladinEquip) {
                        case 1:
                            testEquip.name = "Holy Hammer";
                            break;
                        case 2:
                            testEquip.name = "Divine Doublet";
                            break;
                        case 3:
                            testEquip.name = "Flame of Faith";
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    testClass.name = "Rogue";
                    int rogueEquip = GameLogic.readInputInt("Choose a Rogue Equipment: (1)'Stealthy Shoes', (2)'Dangerous Dagger', (3)'Cunning Caltrops'", 3);
                    switch (rogueEquip) {
                        case 1:
                            testEquip.name = "Stealthy Shoes";
                            break;
                        case 2:
                            testEquip.name = "Dangerous Dagger";
                            break;
                        case 3:
                            testEquip.name = "Cunning Caltrops";
                            break;
                        default:
                            break;
                    }
                    break;  
                case 3:
                    testClass.name = "Druid";
                    int druidEquip = GameLogic.readInputInt("Choose a Druid Equipment: (1)'Faerie Flask', (2)'Brair Bindings', (3)'Willow Whistle'", 3);
                    switch (druidEquip) {
                        case 1:
                            testEquip.name = "Faerie Flask";
                            break;
                        case 2:
                            testEquip.name = "Brair Bindings";
                            break;
                        case 3:
                            testEquip.name = "Willow Whistle";
                            break;
                        default:
                            break;
                    }
                    break;
        
                case 4:
                    testClass.name = "Wizard";
                    int wizEquip = GameLogic.readInputInt("Choose a Wizard Equipment: (1)'Crystal Cauldron', (2)'Glowing Gemstone', (3)'Arcane Amulet'", 3);
                    switch (wizEquip) {
                        case 1:
                            testEquip.name = "Crystal Cauldron";
                            break;
                        case 2:
                            testEquip.name = "Glowing Gemstone";
                            break;
                        case 3:
                            testEquip.name = "Arcane Amulet";
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    testClass.name = "Barbarian";
                    int barbEquip = GameLogic.readInputInt("Choose a Barbarian Equipment: (1)'Rage Remedy', (2)'Brutal Broadaxe', (3)'Savage Shield'", 3);
                    switch (barbEquip) {
                        case 1:
                            testEquip.name = "Rage Remedy";
                            break;
                        case 2:
                            testEquip.name = "Brutal Broadaxe";
                            break;
                        case 3:
                            testEquip.name = "Savage Shield";
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
            listofChar.add(testChar);
            GameLogic.pauseGame("Character Created! Press enter to create the next character or start the game: ");
            if (listofChar.size() == 3) {
                System.out.println("Your team is fully assembled!");
                break;
            }

        }
        System.out.println(listofChar.get(0).toName() + listofChar.get(1).toName() + listofChar.get(2).toName());
        scanner.close();
    }
}

