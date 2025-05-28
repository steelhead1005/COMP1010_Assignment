package COMP1010.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Character> listofChar = new ArrayList<>();
    
    public static int readInputInt(String prompt, int numOptions) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                input = -1;
                System.out.println("Invalid input! Please try again.");
            }
        } while (input < 1 || input > numOptions);
        return input;
    }
    public static String readInputString(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
        
    }
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
    public static void pauseGame(String message) {
        System.out.println(message);
        scanner.nextLine();
    }
    public static void textSeperator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static void headingCreator(String heading) {
        textSeperator(30);
        System.out.println(heading);
        textSeperator(30);
    }
    public static void gameStart() {
        // add game name/dev names etc.
        headingCreator("You are standing in an open field west of a white house.");
        pauseGame("Press ENTER to start the game: ");
        headingCreator("Create 3 characters to fight with to begin the game: ");
        //while (listofChar.size() < 3) {
          // characterCreation();
        //}
        Character Char1 = new Character("Char1", 10, 10, 5, 6, 4);
        Char1.Race = new Race("race1", new StatMod(2, 2), new StatMod(4, 1));
        Char1.Class = new Class("class1");
        Char1.Equipment = new Equipment("weapon1", new StatMod(2, 2));
        Char1.identifier = 0;
        listofChar.add(Char1);

        Character Char2 = new Character("Char2", 10, 10, 5, 6, 4);
        Char2.Race = new Race("race1", new StatMod(2, 2), new StatMod(4, 1));
        Char2.Class = new Class("class1");
        Char2.Equipment = new Equipment("weapon1", new StatMod(2, 2));
        Char2.identifier = 0;
        listofChar.add(Char2);

        Character Char3 = new Character("Char3", 10, 10, 5, 6, 4);
        Char3.Race = new Race("race1", new StatMod(2, 2), new StatMod(4, 1));
        Char3.Class = new Class("class1");
        Char3.Equipment = new Equipment("weapon1", new StatMod(2, 2));
        Char3.identifier = 0;
        listofChar.add(Char3);

        // Create enemy team 
        ArrayList<Character> enemyTeam = new ArrayList<>(); // move up

        Character enemy1 = new Character("Goblin", 10, 10, 5, 6, 4);
        enemy1.Race = new Race("race1", new StatMod(2, 2), new StatMod(4, 1));
        enemy1.Class = new Class("class1");
        enemy1.Equipment = new Equipment("weapon1", new StatMod(2, 2));
        enemy1.identifier = 1;
        enemyTeam.add(enemy1);

        Character enemy2 = new Character("Kobold", 10, 12, 3, 7, 6);
        enemy2.Race = new Race("race2", new StatMod(1, 5), new StatMod(2, 2));
        enemy2.Class = new Class("class2");
        enemy2.Equipment = new Equipment("weapon2", new StatMod(2, 3));
        enemy2.identifier = 1;
        enemyTeam.add(enemy2);

        Character enemy3 = new Character("Witch", 10, 12, 3, 5, 6);
        enemy3.Race = new Race("race3", new StatMod(1, 5), new StatMod(2, 2));
        enemy3.Class = new Class("class3");
        enemy3.Equipment = new Equipment("weapon3", new StatMod(2, 3));
        enemy3.identifier = 1;
        enemyTeam.add(enemy3);

        ArrayList<Character> turnOrder = new ArrayList<>();
        turnOrder.addAll(listofChar);
        turnOrder.addAll(enemyTeam);
        Collections.sort(turnOrder, (a, b) -> Integer.compare(a.dexterity, b.dexterity));
        System.out.println(turnOrder);
        

        // start battle
        headingCreator("BATTLE STARTS!");
        System.out.println("Your team will now face: ");
        for (Character enemy : enemyTeam) {
            System.out.println("- " + enemy.name);
            }
        pauseGame("Press ENTER to begin the fight: ");
        
        Node n1 = battleOrderCreator(turnOrder);
        
        int roundCount = 1;
        int roundResult;
        System.out.println("Round 1!");
        while (true) {
            roundResult = battleLoop(n1, listofChar, enemyTeam);
            if (roundResult < 0) {
                break;
            }
            else {
                roundCount += roundResult;
                pauseGame("Round " + roundCount + "!\nPress ENTER to continue: ");
            }
        }

        if (roundResult == -1) {
            System.out.println("You Win!");
        }
        else {
            System.out.println("You Lose!");
        }
    }
    public static void characterCreation() {
        Character testChar = new Character(null, 0, 0, 0, 0, 0);
        Class testClass = new Class(null);
        Race testRace = new Race(null, null, null);
        Equipment testEquip = new Equipment(null,null);
        String numPostfix;
        if (listofChar.size() == 0) {
            numPostfix = "st";
        }
        else if (listofChar.size() == 1) {
            numPostfix = "nd";
        }
        else {
            numPostfix = "rd";
        }
        headingCreator("Create your " + (listofChar.size() + 1) + numPostfix + " character");

        testChar.name = getCharName();

        int rolledStats[] = rollStats();
        testChar.health = rolledStats[0];
        testChar.currenthp = testChar.health;
        testChar.strength = rolledStats[1];
        testChar.intelligence = rolledStats[2];
        testChar.dexterity = rolledStats[3];
        testChar.defence = rolledStats[4];

        ArrayList<Integer> raceStats = getRace();
        testRace.name = getRaceName(raceStats);
        testRace.stat1 = new StatMod(raceStats.get(1), raceStats.get(2));
        testRace.stat2 = new StatMod(raceStats.get(3), raceStats.get(4));
        raceStatMod(testChar, testRace.stat1, testRace.stat2);
        testChar.Race = testRace;

        Returnpair classRpair  = getClassName();
        testClass.name = classRpair.name;
        testChar.Class = testClass;

        Returnpair equipRpair = getEquip(classRpair.num);
        testEquip.name = equipRpair.name;
        testEquip.stat1 = equipRpair.stat1;
        equipStatMod(testChar, testEquip.stat1);
        testChar.Equipment = testEquip;
        testChar.identifier = 0;
  
        headingCreator("Your character is ready!");
        System.out.println("Character Name: " + testChar.name);
        System.out.println("Health: " + testChar.health);
        System.out.println("Strength: " + testChar.strength);
        System.out.println("Intelligence: " + testChar.intelligence);
        System.out.println("Dexterity: " + testChar.dexterity);
        System.out.println("Defence: " + testChar.defence);
        System.out.println("Race: " + testChar.Race);
        System.out.println("Class: " + testChar.Class);
        System.out.println("Equipment: " + testChar.Equipment);

        listofChar.add(testChar);

    }

    public static Node battleOrderCreator(ArrayList<Character> turnOrder) {
        Node n6 = new Node(turnOrder.get(5), null);
        Node n5 = new Node(turnOrder.get(4), n6);
        Node n4 = new Node(turnOrder.get(3), n5);
        Node n3 = new Node(turnOrder.get(2), n4);
        Node n2 = new Node(turnOrder.get(1), n3);
        Node n1 = new Node(turnOrder.get(0), n2);
        return n1;
    }

    public static int battleLoop(Node start, ArrayList<Character> listofChar, ArrayList<Character> enemyTeam) {
        int playerTeamHealth = listofChar.get(0).currenthp + listofChar.get(1).currenthp + listofChar.get(2).currenthp;
        int enemyTeamHealth = enemyTeam.get(0).currenthp + enemyTeam.get(1).currenthp + enemyTeam.get(2).currenthp;

        if (start == null) {
            return 1;
        }
        if (enemyTeamHealth == 0){
            return -1;
        }
        else if (playerTeamHealth == 0) {
            return -2;
        }

        if (start.data.currenthp <= 0) {
            start.data.identifier = 3;
        }
        if (start.data.identifier == 0) {
            System.out.println(start.data.name + "'s turn: " );
            System.out.println(start.data.name + " is on " + start.data.currenthp + " health: ");
            int battleChoice = readInputInt("Would you like to attack (1), defend (2) or heal (3): ", 3);
            switch (battleChoice) {
                case 1:
                    int attacktarget = readInputInt("Who would you like to attack " + enemyTeam.get(0).name + " (1), " + enemyTeam.get(1).name + " (2) or " 
                                                    + enemyTeam.get(2).name + " (3): ", 3);
                    Character.attack(start.data, enemyTeam.get(attacktarget - 1));
                    battleLoop(start.next, listofChar, enemyTeam);
                    break;
                case 2:
                    Character.defend(start.data);
                    battleLoop(start.next, listofChar, enemyTeam);
                    break;
                case 3:
                    Character.heal(start.data);
                    battleLoop(start.next, listofChar, enemyTeam);
                    break;
            }
        }
        else if (start.data.identifier == 1) {
            int battleChoice = (int)(Math.random() * 3 + 1);
            System.out.println(start.data.name + "'s turn: " );
            System.out.println(start.data.name + " is on " + start.data.currenthp + " health: ");
            switch (battleChoice) {
                case 1:
                    Character.attack(start.data, listofChar.get((int)(Math.random() * 3)));
                    battleLoop(start.next, listofChar, enemyTeam);
                    break;
                case 2:
                    Character.defend(start.data);
                    battleLoop(start.next, listofChar, enemyTeam);
                    break;
                case 3:
                    Character.heal(start.data);
                    battleLoop(start.next, listofChar, enemyTeam);
                    break;
            }
        }
        else {
            battleLoop(start.next, listofChar, enemyTeam);
        }
        return 1;
    }

    public static String getCharName() {
        String name;
        boolean nameConfirm = false;
        do{
            name = readInputString("Whats your characters name: ");
            headingCreator("Your name is " + name + ".\nIs that correct?");
            System.out.println("(1) Yes");
            System.out.println("(2) No");
            int input = readInputInt("->", 2);
            if (input == 1) {
                nameConfirm = true;
            }
        }while (!nameConfirm);
        return name;
    }

    public static int[] rollStats() {
        int[] stats = new int[5];
        pauseGame("Press ENTER to roll for health: ");
        int rolledHealth = (int)(Math.random() * 50 + 1);
        stats[0] = rolledHealth;
        System.out.println("You rolled: " + rolledHealth);
        pauseGame("Press ENTER to roll for strength: ");
        int rolledStrength = (int)(Math.random() * 10);
        stats[1] = rolledStrength;
        System.out.println("You rolled: " + rolledStrength);
        pauseGame("Press ENTER to roll for intelligence: ");
        int rolledInt = (int)(Math.random() * 10);
        stats[2] = rolledInt;
        System.out.println("You rolled: " + rolledInt);
        pauseGame("Press ENTER to roll for dexterity: ");
        int rolledDex = (int)(Math.random() * 10);
        stats[3] = rolledDex;
        System.out.println("You rolled: " + rolledDex);
        pauseGame("Press ENTER to roll for defence: ");
        int rolledDefence = (int)(Math.random() * 10);
        stats[4] = rolledDefence;
        System.out.println("You rolled: " + rolledDefence);
        return stats;
    }
    public static ArrayList<Integer> getRace(){
        int raceChoice = readInputInt("Choose a race: (1)'Human', (2)'Orc', (3)'Elf', (4)'Dwarf', (5)'Undead'", 5);
        ArrayList<Integer> raceArray = new ArrayList<Integer>(); // INDEXES: (0) = Race, (1) = First stat to mod, (2) = Amount to mod, (3) Second stat to mod, (4) Amount to mod
        raceArray.add(raceChoice);
        switch (raceChoice) {
            case 1:
                int[] hstats = humanStatChoice();
                Collections.addAll(raceArray, hstats[0], 1 , hstats[1], 1);
                return raceArray;
            case 2:
                Collections.addAll(raceArray, 2, 2, 3, -1);
                return raceArray;
            case 3:
                Collections.addAll(raceArray, 4, 2, 2, -1);
                return raceArray;
            case 4:
                Collections.addAll(raceArray, 5, 2, 4, -1);    
                return raceArray;
            case 5:
                Collections.addAll(raceArray, 3, 2, 5, -1);    
                return raceArray;
            default:
                return null; //Unreachable
        }
        
    }
    public static String getRaceName(ArrayList<Integer> list) {
        switch (list.get(0)) {
            case 1:
                return "Human";
            case 2:
                return "Orc";
            case 3:
                return "Elf";
            case 4:
                return "Dwarf";
            case 5:
                return "Undead";
            default:
                return null; // Unreachable
        }
    }
    public static int[] humanStatChoice() {
        int[] statChoice = new int[2];
        statChoice[0] = readInputInt("Pick the first stat to '+1': (1)'Health', (2)'Strength', (3)'Intelligence', (4)'Dexterity', (5)'Defence'", 5);
        statChoice[1] = readInputInt("Pick the second stat to '+1': (1)'Health', (2)'Strength', (3)'Intelligence', (4)'Dexterity', (5)'Defence'", 5);
        return statChoice;
    }
    public static void raceStatMod(Character player, StatMod stat1, StatMod stat2) {
        switch (stat1.statToMod) {
            case 1:
                player.health += stat1.valueOfMod;
                System.out.println("Your Health was changed by " + stat1.valueOfMod);
                break;
            case 2:
                player.strength += stat1.valueOfMod;
                System.out.println("Your Strength was changed by " + stat1.valueOfMod);
                break;
            case 3:
                player.intelligence += stat1.valueOfMod;
                System.out.println("Your Intelligence was changed by " + stat1.valueOfMod);
                break;
            case 4:
                player.dexterity += stat1.valueOfMod;
                System.out.println("Your Dexterity was changed by " + stat1.valueOfMod);
                break;
            case 5:
                player.defence += stat1.valueOfMod;
                System.out.println("Your Defence was changed by " + stat1.valueOfMod);
                break;
            default:
                break; //Unreachable
        }
        switch (stat2.statToMod) {
            case 1:
                player.health += stat2.valueOfMod;
                System.out.println("Your Health was changed by " + stat2.valueOfMod);
                break;
            case 2:
                player.strength += stat2.valueOfMod;
                System.out.println("Your Strength was changed by " + stat2.valueOfMod);
                break;
            case 3:
                player.intelligence += stat2.valueOfMod;
                System.out.println("Your Intelligence was changed by " + stat2.valueOfMod);
                break;
            case 4:
                player.dexterity += stat2.valueOfMod;
                System.out.println("Your Dexterity was changed by " + stat2.valueOfMod);
                break;
            case 5:
                player.defence += stat2.valueOfMod;
                System.out.println("Your Defence was changed by " + stat2.valueOfMod);
                break;
            default:
                break; //Unreachable
        }
    }
    public static Returnpair getClassName() {
        int classChoice = readInputInt("Choose a class: (1)'Paladin', (2)'Rogue', (3)'Druid', (4)'Wizard', (5)'Barbarian'", 5);
        switch (classChoice) {
            case 1:
                return new Returnpair("Paladin", 1);
            case 2:
                return new Returnpair("Rogue", 2);
            case 3:
                return new Returnpair("Druid", 3);
            case 4:
                return new Returnpair("Wizard", 4);
            case 5:
                return new Returnpair("Barbarian", 5);  
            default:
                return null; //Unreachable
        }
    }
    public static Returnpair getEquip(int classNum) {
        Returnpair equipPair = new Returnpair(null, null);
        switch (classNum) {
            case 1:
                int paladinEquip = readInputInt("Choose a Paladin Equipment: (1)'Holy Hammer', (2)'Divine Doublet', (3)'Flame of Faith'", 3);
                switch (paladinEquip) {
                    case 1:
                        equipPair.name = "Holy Hammer";
                        equipPair.stat1 = new StatMod(5, 4);
                        return equipPair;
                    case 2:
                        equipPair.name = "Divine Doublet";
                        equipPair.stat1 = new StatMod(2, 3);
                        return equipPair;
                    case 3:
                        equipPair.name = "Flame of Faith";
                        equipPair.stat1 = new StatMod(3, 3);
                        return equipPair;
                    }
            break;
            case 2:
                int rogueEquip = readInputInt("Choose a Rogue Equipment: (1)'Stealthy Shoes', (2)'Dangerous Dagger', (3)'Cunning Caltrops'", 3);
                switch (rogueEquip) {
                    case 1:
                        equipPair.name = "Stealthy Shoes";
                        equipPair.stat1 = new StatMod(4, 4);
                        return equipPair;
                    case 2:
                        equipPair.name = "Dangerous Dagger";
                        equipPair.stat1 = new StatMod(2, 3);
                        return equipPair;
                    case 3:
                        equipPair.name = "Cunning Caltrops";
                        equipPair.stat1 = new StatMod(5, 2);
                        return equipPair;
                    }
            break;
            case 3:
                int druidEquip = readInputInt("Choose a Druid Equipment: (1)'Faerie Flask', (2)'Brair Bindings', (3)'Willow Whistle'", 3);
                switch (druidEquip) {
                    case 1:
                        equipPair.name = "Faerie Flask";
                        equipPair.stat1 = new StatMod(1, 10);
                        return equipPair;
                    case 2:
                        equipPair.name = "Brair Bindings";
                        equipPair.stat1 = new StatMod(5, 3);
                        return equipPair;
                    case 3:
                        equipPair.name = "Willow Whistle";
                        equipPair.stat1 = new StatMod(4, 2);
                        return equipPair;
                    }
            break;
            case 4:
                int wizardEquip = readInputInt("Choose a Wizard Equipment: (1)'Crystal Cauldron', (2)'Glowing Gemstone', (3)'Arcane Amulet'", 3);
                switch (wizardEquip) {
                    case 1:
                        equipPair.name = "Crystal Cauldron";
                        equipPair.stat1 = new StatMod(3, 4);
                        return equipPair;
                    case 2:
                        equipPair.name = "Glowing Gemstone";
                        equipPair.stat1 = new StatMod(4, 2);
                        return equipPair;
                    case 3:
                        equipPair.name = "Arcane Amulet";
                        equipPair.stat1 = new StatMod(1, 5);
                        return equipPair;
                    }
            break;
            case 5:
                int barbarianEquip = readInputInt("Choose a Barbarian Equipment: (1)'Rage Remedy', (2)'Brutal Broadaxe', (3)'Savage Shield'", 3);
                switch (barbarianEquip) {
                    case 1:
                        equipPair.name = "Rage Remedy";
                        equipPair.stat1 = new StatMod(1, 10);
                        return equipPair;
                    case 2:
                        equipPair.name = "Glowing Gemstone";
                        equipPair.stat1 = new StatMod(2, 5);
                        return equipPair;
                    case 3:
                        equipPair.name = "Savage Shield";
                        equipPair.stat1 = new StatMod(5, 4);
                        return equipPair;
                    }
            break;    
            default:
                break; //Unreachable
        }
        return equipPair;
    }
    public static void equipStatMod(Character player, StatMod stat1) {
        switch (stat1.statToMod) {
            case 1:
                player.health += stat1.valueOfMod;
                System.out.println("Your Health was changed increased " + stat1.valueOfMod);
                break;
            case 2:
                player.strength += stat1.valueOfMod;
                System.out.println("Your Strength was changed increased " + stat1.valueOfMod);
                break;
            case 3:
                player.intelligence += stat1.valueOfMod;
                System.out.println("Your Intelligence was changed increased " + stat1.valueOfMod);
                break;
            case 4:
                player.dexterity += stat1.valueOfMod;
                System.out.println("Your Dexterity was changed increased " + stat1.valueOfMod);
                break;
            case 5:
                player.defence += stat1.valueOfMod;
                System.out.println("Your Defence was changed increased " + stat1.valueOfMod);
                break;
            default:
                break; //Unreachable
        }
    }
    public static void combatRound(Character attacker, Character defender) {
        int attackPower = attacker.strength;
        int defensePower = defender.defence;
        int dice = (int)(Math.random() * 6);
        int damage = Math.max(0, attackPower - defensePower + dice);

        defender.currenthp -= damage;
        System.out.println(attacker.name + " attacks " + defender.name + " for " + damage + " damage!");

        if (defender.currenthp <= 0) {
            System.out.println(defender.name + " has been defeated!");
        } else {
            System.out.println(defender.name + " has " + defender.currenthp + " HP remaining.");
        }
    }

}


