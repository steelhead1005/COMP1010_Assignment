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
        return "|Name: " + name + "| Health: " + health + "| Strength: " + strength + "| Intelligence: " + intelligence + "| Dexterity: " + dexterity + "| Defence: " + defence + "|";
    }
}

class Race {
    String name;
    int statMod1;
    int statMod2;
}
class Class {
    String name;
    Equipment weapon;
}

class Equipment {
    String name;
    int statMod;
}
