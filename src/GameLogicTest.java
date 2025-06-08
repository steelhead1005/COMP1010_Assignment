import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class GameLogicTest {
    

    @Test
    public void testgetRaceName() {
        String testName = GameLogic.getRaceName(0);
        assertNull(testName);

        testName = GameLogic.getRaceName(1);
        assertEquals("Human", testName);

        testName = GameLogic.getRaceName(2);
        assertEquals("Orc", testName);

        testName = GameLogic.getRaceName(3);
        assertEquals("Elf", testName);

        testName = GameLogic.getRaceName(4);
        assertEquals("Dwarf", testName);

        testName = GameLogic.getRaceName(5);
        assertEquals("Undead", testName);

        testName = GameLogic.getRaceName(6);
        assertNull(testName);
    }

    @Test
    public void testRaceStatMod() {
        Character testChar = new Character(null, 0, 0, 0, 0, 0);
        StatMod testStatMod = new StatMod(1, 1);
        StatMod testStatMod2 = new StatMod(3, 2);
        GameLogic.raceStatMod(testChar, testStatMod, testStatMod2);
        assertAll( 
            () -> assertEquals(1, testChar.health),
            () -> assertEquals(0, testChar.strength),
            () -> assertEquals(2, testChar.intelligence),
            () -> assertEquals(0, testChar.dexterity),
            () -> assertEquals(0, testChar.defence)
        );
    }

    @Test
    public void testEquipStatMod() {
        Character testChar = new Character(null, 0, 0, 0, 0, 0);
        StatMod testStatMod = new StatMod(1, 1);
        GameLogic.equipStatMod(testChar, testStatMod);
        assertAll( 
            () -> assertEquals(1, testChar.health),
            () -> assertEquals(0, testChar.strength),
            () -> assertEquals(0, testChar.intelligence),
            () -> assertEquals(0, testChar.dexterity),
            () -> assertEquals(0, testChar.defence)
        );
    }
}
