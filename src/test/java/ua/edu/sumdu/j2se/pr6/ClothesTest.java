package ua.edu.sumdu.j2se.pr6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Юніт-тести для класу {@link Clothes}.
 * Перевіряють валідацію, конструктори (включно з копі-конструктором)
 * та статичний лічильник.
 */
class ClothesTest {

    private Clothes createValidClothes() {
        return new Clothes("Футболка", Size.M, "Червоний",
                250.0, Material.COTTON, "Adidas", 10);
    }

    @Test
    void shouldCreateValidClothes() {
        Clothes c = createValidClothes();
        assertEquals("Футболка", c.getName());
        assertEquals(Size.M, c.getSize());
        assertEquals(Material.COTTON, c.getMaterial());
        assertEquals(250.0, c.getPrice());
    }

    @Test
    void shouldThrowExceptionWhenConstructorReceivesEmptyName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothes("", Size.M, "Червоний", 250.0,
                        Material.COTTON, "Adidas", 10));
    }

    @Test
    void shouldThrowExceptionWhenConstructorReceivesNullSize() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothes("Футболка", null, "Червоний", 250.0,
                        Material.COTTON, "Adidas", 10));
    }

    @Test
    void shouldThrowExceptionWhenConstructorReceivesNullMaterial() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothes("Футболка", Size.M, "Червоний", 250.0,
                        null, "Adidas", 10));
    }

    @Test
    void shouldThrowExceptionWhenConstructorReceivesZeroPrice() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothes("Футболка", Size.M, "Червоний", 0.0,
                        Material.COTTON, "Adidas", 10));
    }

    @Test
    void shouldThrowExceptionWhenConstructorReceivesNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () ->
                new Clothes("Футболка", Size.M, "Червоний", 250.0,
                        Material.COTTON, "Adidas", -1));
    }

    @Test
    void shouldThrowExceptionWhenSetPriceWithNegativeValue() {
        Clothes c = createValidClothes();
        assertThrows(IllegalArgumentException.class, () -> c.setPrice(-100));
    }

    @Test
    void shouldThrowExceptionWhenSetSizeWithNull() {
        Clothes c = createValidClothes();
        assertThrows(IllegalArgumentException.class, () -> c.setSize(null));
    }

    @Test
    void shouldCopyAllFieldsViaCopyConstructor() {
        Clothes original = createValidClothes();
        Clothes copy = new Clothes(original);

        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getSize(), copy.getSize());
        assertEquals(original.getMaterial(), copy.getMaterial());
        assertEquals(original.getPrice(), copy.getPrice());
        assertEquals(original, copy);
    }

    @Test
    void shouldThrowExceptionWhenCopyConstructorReceivesNull() {
        assertThrows(IllegalArgumentException.class, () -> new Clothes(null));
    }

    @Test
    void shouldIncrementStaticCounterOnEveryCreation() {
        int before = Clothes.getInstanceCount();
        createValidClothes();
        createValidClothes();
        int after = Clothes.getInstanceCount();
        assertEquals(2, after - before);
    }

    @Test
    void shouldIncrementStaticCounterOnCopy() {
        Clothes original = createValidClothes();
        int before = Clothes.getInstanceCount();
        new Clothes(original);
        int after = Clothes.getInstanceCount();
        assertEquals(1, after - before);
    }
}