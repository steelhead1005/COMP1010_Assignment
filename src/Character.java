//The character class is made to represent the players stats
class Character {
    String name;//Name of Character 
    int health;//How much health the chracter will have
    int currenthp;//Current Health points of the character
    int strength;//Strength trait to change damage
    int intelligence;//Intelligence trait for healing 
    int dexterity;//Trait for speed(eg Dodging)
    int defence;//Trait for damage mitgation
    int identifier;
    int defenceBuff;//Defence increase buff 
    Object Race;
    Object Class;
    Object Equipment;
// Constructor to transfer the stats for the character
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
        return name + " the " + Race + " " + Class;
    }
    public String toName() {
        return name + ", ";
    }
    //Changes the stats based on the Stat momd Object 
    public void statMod(StatMod mod) {
        String posOrNeg;
        if(mod.valueOfMod < 0) {
            posOrNeg = "decreased";
        }
        else{
            posOrNeg = "increased";
        }
        switch (mod.statToMod) {
            case 1:
                this.health += mod.valueOfMod; //Health modifcation 
                System.out.println("Your Health was " + posOrNeg + " by " + Math.abs(mod.valueOfMod));
                break;
            case 2:
                this.strength += mod.valueOfMod; //Strength modifcation 
                System.out.println("Your Strength was " + posOrNeg + " by " + Math.abs(mod.valueOfMod));
                break;
            case 3:
                this.intelligence += mod.valueOfMod; //Intelligence modification
                System.out.println("Your Intelligence was " + posOrNeg + " by " + Math.abs(mod.valueOfMod));
                break;
            case 4:
                this.dexterity += mod.valueOfMod; //Dexterity modification
                System.out.println("Your Dexterity was " + posOrNeg + " by " + Math.abs(mod.valueOfMod));
                break;
            case 5:
                this.defence += mod.valueOfMod; //Defence modification
                System.out.println("Your Defence was " + posOrNeg + " by " + Math.abs(mod.valueOfMod));
                break;
            default:
                break; //Unreachable
        }
    }
    
    //Autheticates the damage of an attack from one charcater to the other
    public static void attack(Character attacker, Character defender) {
        int attackPower = attacker.strength;
        int defencePower = defender.defence;
        int damage = attackCalc(attackPower, defencePower);

        if (defender.currenthp - damage <= 0) {
            defender.currenthp = 0;
            System.out.println(attacker.name + " attacks " + defender.name + " for " + damage + " damage!");//display the damage in text
            GameLogic.pauseGame(defender.name + " is now DEAD!\nPress ENTER to continue: ");//displaying the death of a character
            if(GameLogic.playerTeam.contains(defender)) {
                GameLogic.playerTeam.remove(defender);
            }
            else{
                GameLogic.enemyTeam.remove(defender);
            }
        }
        else {
            defender.currenthp -= damage;
            System.out.println(attacker.name + " attacks " + defender.name + " for " + damage + " damage!");
            GameLogic.pauseGame(defender.name + " is now on " + defender.currenthp + " health: \nPress ENTER to continue: ");//current status of game 
        }
    }
    public static int attackCalc(int attackPower, int defencePower){
        int dice = dice(6); //Dice roll
        int damage = Math.max(0, attackPower - defencePower + dice);// The damage of the attack 
        return damage;
    }
    //code for chance to increase defence of character 
    public static void defend(Character defender) {
        int dice = dice(6);
        defender.defence += dice;

        System.out.println(defender.name + " raised their defence by " + dice + " for 1 round!");//text to inform player of defence increase
        GameLogic.pauseGame("Press ENTER to continue: ");//The proccedure to move to next step 
        defender.defenceBuff = dice;//buff 
    }
    public static int dice(int n) {
        int dice = (int)(Math.random() * n);
        return dice;
    }
    //Character healing 
    public static void heal(Character patient) {
        int healAmount = dice(6) + patient.intelligence;//Healing Amount calculation 
        overHealCheck(patient, healAmount);

        System.out.println(patient.name + " healed for " + healAmount + "!");//informing player of healing being done 
        GameLogic.pauseGame("Press ENTER to continue: ");//Next step button 
    }
    public static void overHealCheck(Character patient, int healAmount) {
        if (patient.currenthp + healAmount > patient.health) {
            healAmount = patient.health - patient.currenthp;//Overhealing prevention 
            patient.currenthp = patient.health;//add up the new healing to current hp 
        }
        else {
            patient.currenthp += healAmount;
        }
    }
}
//Class made to represent the different races choosable within the game 
class Race {
    String name;//Name of the Race
    StatMod stat1;//Stat that comes with certain race
    StatMod stat2;//Second stats that comes with certain race 
    
    public Race (String name, StatMod stat1, StatMod stat2) {
        this.name = name;
        this.stat1 = stat1;//intialising the stats to the race class
        this.stat2 = stat2;
    }
    public String toString() {
        return name;
    }
}
//This class is for thr different Roles the playable charater can be given 
class Class {
    String name;//Classfication of the class
    Equipment weapon;//Weapon associated with chosen class
    public Class (String name) {
        this.name = name;//initialisation 
    }
    public String toString() {
        return name;
    }
}
//The equipment class that asscoiates certain equipment wiht certain stats 
class Equipment{
    public String name;//name of equipment 
    public StatMod stat1;//stats modificcation for equipment 
    public Equipment (String name, StatMod stat1) {
        this.name = name;
        this.stat1 = stat1;
    }
    public String toString() {
        return name;
    }
}
//statmod class is for modifying the charcater attributes 
class StatMod {
    int statToMod;
    int valueOfMod;//value of modification 
    String statName;
    public StatMod (int statToMod, int valueOfMod) {
        this.statToMod = statToMod;
        this.valueOfMod = valueOfMod;
    }
    //returns the name of the stats based on the identity 
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
//return class used for storing data
class Returnpair {
    public String name;
    public int num;
    public StatMod stat1;

    public Returnpair(String name, int num) {
        this.name = name;//
        this.num = num;
    }
    public Returnpair(String name, StatMod stat1) {
        this.name = name;
        this.stat1 = stat1;
    }
}
//node class is for linked list structure 
class Node {
    public Character data; // stored character data
    public Node next;//Goes to the next node 

    public Node(Character data, Node next) {//initialisation 
        this.data = data;
        this.next = next;
    }
}
