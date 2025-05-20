class Character {
    String name;
    int health;
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
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.defence = defence;
    }
    public String toString() {
        return "|Name: " + name + "| Race: " + Race + "| Health: " + health + "| Strength: " + strength + "| Intelligence: " + intelligence + "| Dexterity: " + dexterity + "| Defence: " + defence + "|";
    }
}

class Race {
    String name;
    String statMod1;
    String statMod2;
    
    public Race (String name, String statMod1, String statMod2) {
        this.name = name;
        this.statMod1 = statMod1;
        this.statMod2 = statMod2;
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
    int statMod;
}
