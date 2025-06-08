What problem your application solves

	This application aims to simulate a turn-based combat RPG. What the program will do is allow players to select a team of 3 characters each of which can 	have a 	different race, class, and weapon. These characters  stats are randomly generated and will be able to modify their stats based on their race and 	class weapon. The stats play a vital role in character creation as they determine a variety of factors which are described below:
	Health - determines how many points of damage a player can take before dying. 
	Strength - determines how much damage a character can do. 
	Intelligence - determines how much healing a character can do. 
	Dexterity - determines how fast a character is. Also determines the turn order of the characters.
	Defence - determines how much damage a character mitigates when being attacked. 

	The races they can choose from are:
	Human - 2x +1 stat increases.
	Orc - +2 to strength and -1 to intelligence
	Elf - +2 to dexterity and -1 to strength
	Dwarf - +2 to defence and -1 to dexterity
	Undead - +2 intelligence and -1 to defence

	The player may choose from any of the below classes and are allowed to pick a single weapon from that class pool. The weapons associated with each class 	are shown below:
	Paladin
		Holy Hammer - +4 defence
		Divine Doublet - +3 strength
		Flame of Faith - +3 intelligence

	Rogue
		Stealthy shoes - +4 dexterity
		Dangerous Dagger - +3 strength
		Cunning Caltrops - +2 defence

	Druid
		Faerie Flask - +10 health
		Briar Bindings - +3 defence
		Willow Whistle - +2 dexterity

	Wizard
		Crystal Cauldron - +4 intelligence
		Glowing Gemstone - +2 dexterity
		Arcane Amulet - +5 health

	Barbarian
		Rage Remedy - +10 health
		Brutal Broadaxe - +5 strength
		Savage Shield - +4 defence

	During the creation of characters, players can opt to import a class build with samples given as test0, test1 and test2. After the 3 characters have been created, the players can choose to export their classes to be used in future use. This will save their race, class and weapon but not their stats. 			Stats are randomised each time a player starts the game.

	Once the characters have been created, the turn-based combat starts where the 3 created characters will face 3 enemies; a Goblin, a Kobold and a Witch. The pick order 	is determined by everyone's dexterity value. 

	Once the Round has commenced. The player or enemy can chose to either attack, defend, or heal. This cycle will continue until either all 3 enemies are dead or all 3 	characters are dead in which the player will receive a "You Win!" or "You Lose!" respectively. 



A description of the structure of your program

	The program is structured into 6 different files:
	BuildIO.java - the file that handles the importing/exporting character data to/from files. 
	Character.java - the file that contains the data and logic for characters including races, classes and equipment
 	CharacterTest.java - test file to confirm the Character.java file is working correctly.
	Client.java - the file that allows the game to run.
	GameLogic.java - the file that handles the core game mechanics including inputs, character creation, turn order and the battle loop. 
	GameLogicTest.java - test file to confirm the GameLogic.java file is working correctly.
 
How to run the program

	- Ensure you have Java installed on your computer.
	- Unzip the file and note its location.
	- Open the folder COMP1010_Assignment in vscode.
	- if prompted, select "trust the workspace".
	- select the Client.java file and press the run button at the top.
	- The game will start in the terminal at the bottom of vscode.
	- if you wish to import builds, ensure the test0, test1, and test 2 are located at the same level as the src folder. 

Task allocation 

	Gabe 25% - Game Logic, Character data and Game Loop
	Jai 25% - 
	Jalib 25% - 
	Harrison 25% - Ideas for classes, stats, weapon modifiers and class weapon modifiers. Documentation and File IO.

UML Diagrams

	Class diagram
![alt text](CharacterUML.png "Character UML Diagram") 
![alt text](RaceUML.png "Race UML Diagram")

	Sequence diagram for one turn (attacking)
 ![alt text](SequenceDiagram.png "Sequence Diagram")
 
	State diagram
 ![alt text](StateDiagram.png "State Diagram")

Analysis of two methods

	Method 1: rollStat() in GameLogic.java
		public static int[] rollStats() {
			primitive integer array created with 5 array points.
			pause game used to allow user to know they are rolling for stats.
			5 Math.random calls to create the randomised stat
			stat is then stored within each of  array element. 
			return stats.
		}

	This is simple and effective, using a primitive array to reduce memory compared to using an Arraylist whilst also minimising the time it takes to run by running only 5 Math.random 	calls.
	
	Alternative approach: ArrayList
		public static ArrayList<integer> rollStatsList() {
			Create a new integer ArrayList.
			Use a for loop to do the following:
			pauseGame to allow the user to know they are rolling for stats
			a Math.random call to roll for the stat
			add the stat to the array list
			continue for loop to loop over other stats.
			return stats.
		}
	This method allows for easier resizing if more character stats are required but a lot more memory is used to create the Integer objects and calling for the ArrayList. 
	Overall, the method in the game works much better as the character stats were predefined by us and we save more memory. 

	Method 2: 
	
	

	
