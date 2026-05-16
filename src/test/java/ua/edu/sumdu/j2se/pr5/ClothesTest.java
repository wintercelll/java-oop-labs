package ua.edu.sumdu.j2se.pr5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Юніт-тести для класу {@link Clothes}.
 * Перевіряють валідацію вхідних даних у конструкторі та сетерах.
 */
class ClothesTest {

    /**
     * Допоміжний метод: створює коректний об'єкт для тестів сетерів.
     *
     * @return новий валідний об'єкт Clothes
     */
    private Clothes createValidClothes() {
        return new Clothes("Футболка", "M", "Червоний",
                250.0, "Бавовна", "Adidas", 10);
    }

    @Test
    void shouldCreateValidClothes() {
        Clothes c = createValidClothes();
        assertEquals("Футболка", c.getName());
        assertEquals("M", c.getSize());
        assertEquals(250.0, c.getPrice());
        assertEquals(10, c.getQuantity());
    }

    @Test
    void shouldThrowExceptionWhenConstructorReceivesEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothes("", "M", "Червоний", 250.0,
                        "Бавовна", "Adidas", 10));
    }

    @Test
    void shouldThrowExceptionWhenConstructorReceivesNullName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothes(null, "M", "Червоний", 250.0,
                        "Бавовна", "Adidas", 10));
    }

    @Test
    void shouldThrowExceptionWhenConstructorReceivesInvalidSize() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothes("Футболка", "XXXL", "Червоний", 250.0,
                        "Бавовна", "Adidas", 10));
    }

    @Test
    void shouldThrowExceptionWhenConstructorReceivesZeroPrice() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothes("Футболка", "M", "Червоний", 0.0,
                        "Бавовна", "Adidas", 10));
    }

    @Test
    void shouldThrowExceptionWhenConstructorReceivesNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothes("Футболка", "M", "Червоний", 250.0,
                        "Бавовна", "Adidas", -1));
    }

    @Test
    void shouldThrowExceptionWhenSetPriceWithNegativeValue() {
        Clothes c = createValidClothes();
        assertThrows(IllegalArgumentException.class, () -> c.setPrice(-100));
    }

    @Test
    void shouldThrowExceptionWhenSetSizeWithInvalidValue() {
        Clothes c = createValidClothes();
        assertThrows(IllegalArgumentException.class, () -> c.setSize("XXXL"));
    }

    @Test
    void shouldThrowExceptionWhenSetQuantityWithNegativeValue() {
        Clothes c = createValidClothes();
        assertThrows(IllegalArgumentException.class, () -> c.setQuantity(-5));
    }

    @Test
    void shouldUpdateFieldsCorrectlyViaSetters() {
        Clothes c = createValidClothes();
        c.setPrice(999.99);
        c.setQuantity(50);
        c.setBrand("Nike");

        assertEquals(999.99, c.getPrice());
        assertEquals(50, c.getQuantity());
        assertEquals("Nike", c.getBrand());
    }
}