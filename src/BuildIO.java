import java.io.*;
import java.util.ArrayList;

public class BuildIO {
    public static void exportCharacter(Character character, String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("name="+ character.name);
        writer.newLine();
        writer.write("health="+ character.health);
        writer.newLine();
        writer.write("strength="+ character.strength);
        writer.newLine();
        writer.write("intelligence="+ character.intelligence);
        writer.newLine();
        writer.write("dexterity="+ character.dexterity);
        writer.newLine();
        writer.write("defence="+ character.defence);
        writer.newLine();
        writer.write("class="+ character.Class);
        writer.newLine();
        writer.write("race="+ character.Race);
        writer.newLine();
        writer.write("equipment="+ character.Equipment);
        writer.newLine();
        writer.close();
        System.out.println("Character " + character.name + " was successfully exported.");
    }

    public static Character importCharacter(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String name ="", Race= "", Class = "", Equipment="", line;
        while ((line =reader.readLine()) != null) {
            String[] parts = line.split("=");
            switch (parts[0]) {
                case "name": name = parts[1]; break;
                case "race": Race = parts[1]; break;
                case "class": Class = parts[1]; break;
                case "equipment": Equipment = parts[1]; break;
            }
        }

        reader.close();

        int health = (int)(Math.random() * 50 + 1); 
        int strength =(int)(Math.random() * 10);
        int intelligence =(int)(Math.random() * 10); 
        int dexterity =(int)(Math.random() * 10);
        int defence=(int)(Math.random() * 10); 

        ArrayList<Integer> raceStats = new ArrayList<>();
        Race importedRace = new Race(null, null, null);
        String normalisedRace = Race.split(" \\(")[0].trim();
        switch (normalisedRace) {
            case "Human":
                importedRace.name = normalisedRace;
                raceStats = GameLogic.getRaceStats(1);
                break;
            case "Orc":
                importedRace.name = normalisedRace;
                raceStats = GameLogic.getRaceStats(2);
                break;
            case "Elf":
                importedRace.name = normalisedRace;
                raceStats = GameLogic.getRaceStats(3);
                break;
            case "Dwarf":
                importedRace.name = normalisedRace;
                raceStats = GameLogic.getRaceStats(4);
                break;
            case "Undead":
                importedRace.name = normalisedRace;
                raceStats = GameLogic.getRaceStats(5);
                break;
            default:
                break;
        }
        Class importedClass = new Class(null);
        Equipment importedEquipment = new Equipment(null, null);
        String normalisedEquipment = Equipment.split(" \\(")[0].trim();
        String normalisedClass = Class.split(" \\(")[0].trim();
        switch (normalisedClass) {
            case "Paladin":
                importedClass.name = normalisedClass;
                switch(normalisedEquipment) {
                    case "Holy Hammer":
                        importedEquipment.name = normalisedEquipment;
                        defence +=4;
                        break;
                    case "Divine Doublet":
                        importedEquipment.name = normalisedEquipment;
                        strength+=3;
                        break;
                    case "Flame of Faith":
                        importedEquipment.name = normalisedEquipment;
                        intelligence +=3;
                        break;
                }
                break;
            case "Rogue":
                importedClass.name = normalisedClass;
                switch(normalisedEquipment) {
                    case "Stealthy Shoes":
                        importedEquipment.name = normalisedEquipment;
                        dexterity +=4;
                        break;
                    case "Dangerous Dagger":
                        importedEquipment.name = normalisedEquipment;
                        strength +=3;
                        break;
                    case "Cunning Caltrops":
                        importedEquipment.name = normalisedEquipment;
                        defence +=2;
                        break;
                }
                break;
            case "Druid":
                importedClass.name = normalisedClass;
                switch(normalisedEquipment) {
                    case "Faerie Flask":
                        importedEquipment.name = normalisedEquipment;
                        health +=10;
                        break;
                    case "Brair Bindings":
                        importedEquipment.name = normalisedEquipment;
                        defence +=3;
                        break;
                    case "Willow Whistle":
                        importedEquipment.name = normalisedEquipment;
                        dexterity +=2;
                        break;
                }
                break;
            case "Wizard":
                importedClass.name = normalisedClass;
                switch(normalisedEquipment) {
                    case "Crystal Cauldron":
                        importedEquipment.name = normalisedEquipment;
                        intelligence +=4;
                        break;
                    case "Glowing Gemstone":
                        importedEquipment.name = normalisedEquipment;
                        dexterity +=2;
                        break;
                    case "Arcane Amulet":
                        importedEquipment.name = normalisedEquipment;
                        health +=5;
                        break;
                }
                break;
            case "Barbarian":
                importedClass.name = normalisedClass;
                switch(normalisedEquipment) {
                    case "Rage Remedy":
                        importedEquipment.name = normalisedEquipment;
                        health +=10;
                        break;
                    case "Brutal Broadaxe":
                        importedEquipment.name = normalisedEquipment;
                        strength +=5;
                        break;
                    case "Savage Shield":
                        importedEquipment.name = normalisedEquipment;
                        defence +=4;
                        break;
                }
                break;
            default:
                break;//Unreachable
        }
        // return new Character(name, health, strength, intelligence, dexterity, defence);
        Character importedCharacter = new Character(name, health, strength, intelligence, dexterity, defence);
        importedRace.stat1 = new StatMod(raceStats.get(1), raceStats.get(2));
        importedRace.stat2 = new StatMod(raceStats.get(3), raceStats.get(4));
        importedCharacter.statMod(importedRace.stat1);
        importedCharacter.statMod(importedRace.stat2);
        importedCharacter.Race = importedRace;
        importedCharacter.Class = importedClass;
        importedCharacter.Equipment = importedEquipment;
        importedCharacter.currenthp = importedCharacter.health;
        importedCharacter.identifier = 0;
        System.out.println("Character " + importedCharacter.name + " was successfully imported.");
        System.out.println("Character Name: " + importedCharacter.name);
        System.out.println("Health: " + importedCharacter.health);
        System.out.println("Strength: " + importedCharacter.strength);
        System.out.println("Intelligence: " + importedCharacter.intelligence);
        System.out.println("Dexterity: " + importedCharacter.dexterity);
        System.out.println("Defence: " + importedCharacter.defence);
        System.out.println("Race: " + importedCharacter.Race);
        System.out.println("Class: " + importedCharacter.Class);
        System.out.println("Equipment: " + importedCharacter.Equipment);
        return importedCharacter;
        //GameLogic.playerTeam.add(importedCharacter);


    }



}   

