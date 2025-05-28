package COMP1010.main;

class Character {
    String name;
    int health;
    int currenthp;
    int strength;
    int intelligence;
    int dexterity;
    int defence;
    int identifier;
    Object Race;
    Object Class;
    Object Equipment;

    public Character(String name, int health, int strength, int intelligence, int dexterity, int defence) {
        this.name = name;
        this.health = health;
        this.currenthp = health;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.defence = defence;
    }
    public String toString() {
        return name + " " + dexterity;
    }
    public String toName() {
        return name + ", ";
    }

    public void statMod(StatMod mod) {
        switch (mod.statToMod) {
            case 1:
                this.health += mod.valueOfMod;
                break;
            case 2:
                this.strength += mod.valueOfMod;
                break;
            case 3:
                this.intelligence += mod.valueOfMod;
                break;
            case 4:
                this.dexterity += mod.valueOfMod;
                break;
            case 5:
                this.defence += mod.valueOfMod;
                break;
            default:
                // Unknown stat, do nothing
                break;
        }
    }
    public static void attack(Character attacker, Character defender) {
        int attackPower = attacker.strength;
        int defencePower = defender.defence;
        int dice = (int)(Math.random() * 6);
        int damage = Math.max(0, attackPower - defencePower + dice);

        if (defender.currenthp - damage <= 0) {
            defender.currenthp = 0;
            System.out.println(attacker.name + " attacks " + defender.name + " for " + damage + " damage!");
            GameLogic.pauseGame(defender.name + " is now DEAD!\nPress ENTER to continue: ");
        }
        else {
            defender.currenthp -= damage;
            System.out.println(attacker.name + " attacks " + defender.name + " for " + damage + " damage!");
            GameLogic.pauseGame(defender.name + " is now on " + defender.currenthp + " health: \nPress ENTER to continue: ");
        }
    }
    public static int defend(Character defender) {
        int dice = (int)(Math.random() * 6);
        defender.defence += dice;

        System.out.println(defender.name + " raised their defence by " + dice + " for 1 round!");
        GameLogic.pauseGame("Press ENTER to continue: ");
        return dice;
    }
    public static void heal(Character patient) {
        int dice = (int)(Math.random() * 6) + patient.intelligence;
        if (patient.currenthp + dice > patient.health) {
            dice = patient.health - patient.currenthp;
            patient.currenthp = patient.health;
        }
        else {
            patient.currenthp += dice;
        }

        System.out.println(patient.name + " healed for " + dice + "!");
        GameLogic.pauseGame("Press ENTER to continue: ");
    }
}

class Race {
    String name;
    StatMod stat1;
    StatMod stat2;
    
    public Race (String name, StatMod stat1, StatMod stat2) {
        this.name = name;
        this.stat1 = stat1;
        this.stat2 = stat2;
    }
    public String toString() {
        return name;
    }
}
class Class {
    String name;
    Equipment weapon;
    public Class (String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Equipment{
    public String name;
    public StatMod stat1;
    public Equipment (String name, StatMod stat1) {
        this.name = name;
        this.stat1 = stat1;
    }
    public String toString() {
        return name + stat1;
    }
}

class StatMod {
    int statToMod;
    int valueOfMod;
    String statName;
    public StatMod (int statToMod, int valueOfMod) {
        this.statToMod = statToMod;
        this.valueOfMod = valueOfMod;
    }
    public String getStatName() {
        switch (this.statToMod) {
            case 1:
                return "Health";
            case 2:
                return "Strength";
            case 3:
                return "Intelligence";
            case 4:
                return "Dexterity";
            case 5:
                return "Defence";
            default:
                return null; //Unreachable
        }
    }
    public String toString() {
        return " (+" + valueOfMod + " " + getStatName() + ")";
    }
}
class Returnpair {
    public String name;
    public int num;
    public StatMod stat1;

    public Returnpair(String name, int num) {
        this.name = name;
        this.num = num;
    }
    public Returnpair(String name, StatMod stat1) {
        this.name = name;
        this.stat1 = stat1;
    }
}
class Node {
    public Character data;
    public Node next;

    public Node(Character data, Node next) {
        this.data = data;
        this.next = next;
    }
}
