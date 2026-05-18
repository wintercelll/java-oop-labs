package ua.edu.sumdu.j2se.pr7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Юніт-тести для похідного класу {@link Pants}.
 */
class PantsTest {

    private Pants createValidPants() {
        return new Pants("Джинси", Size.M, "Синій", 950.0,
                Material.COTTON, "Levis", 12, 82, 110);
    }

    @Test
    void shouldCreateValidPants() {
        Pants p = createValidPants();
        assertEquals("Джинси", p.getName());
        assertEquals(82, p.getWaistSize());
        assertEquals(110, p.getInseamLength());
    }

    @Test
    void shouldBeInstanceOfClothes() {
        Pants p = createValidPants();
        assertTrue(p instanceof Clothes,
                "Pants має бути екземпляром Clothes (наслідування)");
    }

    @Test
    void shouldThrowExceptionWhenWaistSizeIsZero() {
        assertThrows(IllegalArgumentException.class, () ->
                new Pants("Джинси", Size.M, "Синій", 950.0,
                        Material.COTTON, "Levis", 12, 0, 110));
    }

    @Test
    void shouldThrowExceptionWhenInseamLengthIsNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new Pants("Джинси", Size.M, "Синій", 950.0,
                        Material.COTTON, "Levis", 12, 82, -1));
    }

    @Test
    void shouldThrowExceptionWhenBaseFieldInvalid() {
        // некоректне поле базового класу (порожня назва)
        assertThrows(IllegalArgumentException.class, () ->
                new Pants("", Size.M, "Синій", 950.0,
                        Material.COTTON, "Levis", 12, 82, 110));
    }

    @Test
    void shouldThrowExceptionWhenSetWaistSizeWithZero() {
        Pants p = createValidPants();
        assertThrows(IllegalArgumentException.class, () -> p.setWaistSize(0));
    }

    @Test
    void shouldContainBaseInfoInToString() {
        Pants p = createValidPants();
        String s = p.toString();
        assertTrue(s.contains("Pants"));
        assertTrue(s.contains("Джинси"));
        assertTrue(s.contains("82"));
        assertTrue(s.contains("110"));
    }
}