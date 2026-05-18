package ua.edu.sumdu.j2se.pr8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Юніт-тести для похідного класу {@link Jackets}.
 */
class JacketsTest {

    private Jackets createValidJackets() {
        return new Jackets("Парка", Size.L, "Хакі", 3500.0,
                Material.COTTON, "TheNorthFace", 4, true, true);
    }

    @Test
    void shouldCreateValidJackets() {
        Jackets j = createValidJackets();
        assertEquals("Парка", j.getName());
        assertTrue(j.isWaterproof());
        assertTrue(j.isHooded());
    }

    @Test
    void shouldBeInstanceOfClothes() {
        Jackets j = createValidJackets();
        assertTrue(j instanceof Clothes,
                "Jackets має бути екземпляром Clothes");
    }

    @Test
    void shouldThrowExceptionWhenBaseFieldInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                new Jackets("", Size.L, "Хакі", 3500.0,
                        Material.COTTON, "TheNorthFace", 4, true, true));
    }

    @Test
    void shouldUpdateWaterproofAndHoodedViaSetters() {
        Jackets j = createValidJackets();
        j.setWaterproof(false);
        j.setHooded(false);
        assertFalse(j.isWaterproof());
        assertFalse(j.isHooded());
    }

    @Test
    void shouldContainBaseInfoInToString() {
        Jackets j = createValidJackets();
        String text = j.toString();
        assertTrue(text.contains("Jackets"));
        assertTrue(text.contains("Парка"));
        assertTrue(text.contains("waterproof"));
    }
}