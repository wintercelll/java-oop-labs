package ua.edu.sumdu.j2se.pr7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Юніт-тести для похідного класу {@link Shirts}.
 */
class ShirtsTest {

    private Shirts createValidShirts() {
        return new Shirts("Поло", Size.S, "Білий", 650.0,
                Material.COTTON, "Adidas", 20, false, true);
    }

    @Test
    void shouldCreateValidShirts() {
        Shirts s = createValidShirts();
        assertEquals("Поло", s.getName());
        assertFalse(s.isLongSleeve());
        assertTrue(s.isHasCollar());
    }

    @Test
    void shouldBeInstanceOfClothes() {
        Shirts s = createValidShirts();
        assertTrue(s instanceof Clothes,
                "Shirts має бути екземпляром Clothes (наслідування)");
    }

    @Test
    void shouldThrowExceptionWhenBaseFieldInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                new Shirts("Поло", Size.S, "Білий", -100,
                        Material.COTTON, "Adidas", 20, false, true));
    }

    @Test
    void shouldUpdateSleeveAndCollarViaSetters() {
        Shirts s = createValidShirts();
        s.setLongSleeve(true);
        s.setHasCollar(false);
        assertTrue(s.isLongSleeve());
        assertFalse(s.isHasCollar());
    }

    @Test
    void shouldContainBaseInfoInToString() {
        Shirts s = createValidShirts();
        String text = s.toString();
        assertTrue(text.contains("Shirts"));
        assertTrue(text.contains("Поло"));
        assertTrue(text.contains("комірець") || text.contains("hasCollar"));
    }
}