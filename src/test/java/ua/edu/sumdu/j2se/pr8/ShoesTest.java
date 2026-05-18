package ua.edu.sumdu.j2se.pr8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Юніт-тести для похідного класу {@link Shoes}.
 */
class ShoesTest {

    private Shoes createValidShoes() {
        return new Shoes("Кросівки", Size.M, "Білий", 2200.0,
                Material.POLYESTER, "Nike", 15, 25, "running");
    }

    @Test
    void shouldCreateValidShoes() {
        Shoes s = createValidShoes();
        assertEquals("Кросівки", s.getName());
        assertEquals(25, s.getHeelHeight());
        assertEquals("running", s.getShoeType());
    }

    @Test
    void shouldBeInstanceOfClothes() {
        Shoes s = createValidShoes();
        assertTrue(s instanceof Clothes,
                "Shoes має бути екземпляром Clothes");
    }

    @Test
    void shouldThrowExceptionWhenHeelHeightIsNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new Shoes("Кросівки", Size.M, "Білий", 2200.0,
                        Material.POLYESTER, "Nike", 15, -1, "running"));
    }

    @Test
    void shouldThrowExceptionWhenShoeTypeIsInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                new Shoes("Кросівки", Size.M, "Білий", 2200.0,
                        Material.POLYESTER, "Nike", 15, 25, "skating"));
    }

    @Test
    void shouldThrowExceptionWhenShoeTypeIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Shoes("Кросівки", Size.M, "Білий", 2200.0,
                        Material.POLYESTER, "Nike", 15, 25, null));
    }

    @Test
    void shouldAcceptShoeTypeCaseInsensitive() {
        // має приймати тип у будь-якому регістрі
        Shoes s = new Shoes("Кросівки", Size.M, "Білий", 2200.0,
                Material.POLYESTER, "Nike", 15, 25, "FORMAL");
        assertEquals("FORMAL", s.getShoeType());
    }

    @Test
    void shouldThrowExceptionWhenSetHeelHeightNegative() {
        Shoes s = createValidShoes();
        assertThrows(IllegalArgumentException.class, () -> s.setHeelHeight(-5));
    }
}