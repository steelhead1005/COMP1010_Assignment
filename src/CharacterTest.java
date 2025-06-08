import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;


public class CharacterTest {
    @Test
    public void testAttackCalc() {
        int attackPower = 10;
        int defencePower = 10;
        for(int i = 0; i < 1000; i++) {
            assertTrue((Character.attackCalc(attackPower, defencePower) <= 6));
            assertTrue((Character.attackCalc(attackPower, defencePower) >= 0));
        }

        attackPower = 10;
        defencePower = 0;
        for(int i = 0; i < 1000; i++) {
            assertTrue((Character.attackCalc(attackPower, defencePower) <= 16));
            assertTrue((Character.attackCalc(attackPower, defencePower) >= 10));
        }

        attackPower = 0;
        defencePower = 10;
        for(int i = 0; i < 1000; i++) {
            assertEquals(0, Character.attackCalc(attackPower, defencePower));;
        }
        attackPower = 0;
        defencePower = 1000;
        assertEquals(0, Character.attackCalc(attackPower, defencePower));

        attackPower = 9;
        defencePower = 2;
        for(int i = 0; i < 1000; i++) {
            assertTrue((Character.attackCalc(attackPower, defencePower) <= 13));
            assertTrue((Character.attackCalc(attackPower, defencePower) >= 7));
        }
        attackPower = 5;
        defencePower = 10;
        for(int i = 0; i < 1000; i++) {
            assertTrue((Character.attackCalc(attackPower, defencePower) <= 1));
            assertTrue((Character.attackCalc(attackPower, defencePower) >= 0));
        }
    }

    @Test
    public void testDice() {
        int dice = Character.dice(6);
        for(int i = 0; i < 1000; i++) {
            assertTrue((dice <= 6));
            assertTrue((dice >= 0));
        }
    }

    @Test
    public void testOverHealCheck() {
        Character testPatient = new Character(null, 10, 0, 0, 0, 0);
        testPatient.currenthp = 10;
        Character.overHealCheck(testPatient, 10);
        assertEquals(10, testPatient.currenthp);

        testPatient.currenthp = 8;
        Character.overHealCheck(testPatient, 10);
        assertEquals(10, testPatient.currenthp);

        testPatient.currenthp = 1;
        Character.overHealCheck(testPatient, 8);
        assertEquals(9, testPatient.currenthp);

        testPatient.health = 100;
        testPatient.currenthp = 23;
        Character.overHealCheck(testPatient, 42);
        assertEquals(65, testPatient.currenthp);
    }

    @Test
    public void testStatMod() {
        Character testChar = new Character(null, 0, 0, 0, 0, 0);
        StatMod testStatMod = new StatMod(5, 1);
        testChar.statMod(testStatMod);
        assertAll( 
            () -> assertEquals(0, testChar.health),
            () -> assertEquals(0, testChar.strength),
            () -> assertEquals(0, testChar.intelligence),
            () -> assertEquals(0, testChar.dexterity),
            () -> assertEquals(1, testChar.defence)
        );

        testStatMod = new StatMod(3, 2);
        testChar.statMod(testStatMod);
        assertAll( 
            () -> assertEquals(0, testChar.health),
            () -> assertEquals(0, testChar.strength),
            () -> assertEquals(2, testChar.intelligence),
            () -> assertEquals(0, testChar.dexterity),
            () -> assertEquals(1, testChar.defence)
        );

        testStatMod = new StatMod(1, 12);
        testChar.statMod(testStatMod);
        assertAll( 
            () -> assertEquals(12, testChar.health),
            () -> assertEquals(0, testChar.strength),
            () -> assertEquals(2, testChar.intelligence),
            () -> assertEquals(0, testChar.dexterity),
            () -> assertEquals(1, testChar.defence)
        );

        testStatMod = new StatMod(5, -1);
        testChar.statMod(testStatMod);
        assertAll( 
            () -> assertEquals(12, testChar.health),
            () -> assertEquals(0, testChar.strength),
            () -> assertEquals(2, testChar.intelligence),
            () -> assertEquals(0, testChar.dexterity),
            () -> assertEquals(0, testChar.defence)
        );

        testStatMod = new StatMod(1, -4);
        testChar.statMod(testStatMod);
        assertAll( 
            () -> assertEquals(8, testChar.health),
            () -> assertEquals(0, testChar.strength),
            () -> assertEquals(2, testChar.intelligence),
            () -> assertEquals(0, testChar.dexterity),
            () -> assertEquals(0, testChar.defence)
        );

        testStatMod = new StatMod(6, 100);
        testChar.statMod(testStatMod);
        assertAll( 
            () -> assertEquals(8, testChar.health),
            () -> assertEquals(0, testChar.strength),
            () -> assertEquals(2, testChar.intelligence),
            () -> assertEquals(0, testChar.dexterity),
            () -> assertEquals(0, testChar.defence)
        );
        
        testStatMod = new StatMod(0, -63);
        testChar.statMod(testStatMod);
        assertAll( 
            () -> assertEquals(8, testChar.health),
            () -> assertEquals(0, testChar.strength),
            () -> assertEquals(2, testChar.intelligence),
            () -> assertEquals(0, testChar.dexterity),
            () -> assertEquals(0, testChar.defence)
        );
    }
}
