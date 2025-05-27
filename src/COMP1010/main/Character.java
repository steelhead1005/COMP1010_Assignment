package COMP1010.main;

class Character {
    String name;
    int health;
    int currenthp;
    int strength;
    int intelligence;
    int dexterity;
    int defence;
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
        return "|Name: " + name + "| Race: " + Race + "| Class: " + Class + "| Equipment: " + Equipment + "| Health: " + health + "| Strength: " + strength
                + "| Intelligence: " + intelligence + "| Dexterity: " + dexterity + "| Defence: " + defence + "|";
    }
    public String toName() {
        return name + ", ";
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

class Equipment {
    String name;
    StatMod stat1;
    public Equipment (String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class StatMod {
    int statToMod;
    int valueOfMod;
    public StatMod (int statToMod, int valueOfMod) {
        this.statToMod = statToMod;
        this.valueOfMod = valueOfMod;
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
