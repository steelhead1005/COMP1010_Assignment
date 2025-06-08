import static org.junit.Assert.*;
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
}
