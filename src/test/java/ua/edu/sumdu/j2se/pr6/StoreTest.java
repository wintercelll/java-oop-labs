package ua.edu.sumdu.j2se.pr6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Юніт-тести для класу {@link Store} (демонстрація агрегації).
 */
class StoreTest {

    private Clothes createValidClothes() {
        return new Clothes("Футболка", Size.M, "Червоний",
                250.0, Material.COTTON, "Adidas", 10);
    }

    @Test
    void shouldCreateEmptyStore() {
        Store store = new Store("ТестМагазин");
        assertEquals("ТестМагазин", store.getName());
        assertEquals(0, store.getItemCount());
    }

    @Test
    void shouldThrowExceptionWhenStoreNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Store(""));
    }

    @Test
    void shouldThrowExceptionWhenStoreNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Store(null));
    }

    @Test
    void shouldAddItemToStore() {
        Store store = new Store("Магазин");
        store.addItem(createValidClothes());
        assertEquals(1, store.getItemCount());
    }

    @Test
    void shouldThrowExceptionWhenAddingNullItem() {
        Store store = new Store("Магазин");
        assertThrows(IllegalArgumentException.class, () -> store.addItem(null));
    }

    @Test
    void shouldRemoveItemFromStore() {
        Store store = new Store("Магазин");
        Clothes c = createValidClothes();
        store.addItem(c);
        assertTrue(store.removeItem(c));
        assertEquals(0, store.getItemCount());
    }

    @Test
    void shouldCalculateTotalValue() {
        Store store = new Store("Магазин");
        store.addItem(new Clothes("A", Size.M, "Червоний", 100.0,
                Material.COTTON, "Brand1", 2));
        store.addItem(new Clothes("B", Size.L, "Синій", 200.0,
                Material.SILK, "Brand2", 3));
        // 100 * 2 + 200 * 3 = 800
        assertEquals(800.0, store.getTotalValue());
    }

    @Test
    void shouldReturnDefensiveCopyOfItems() {
        Store store = new Store("Магазин");
        store.addItem(createValidClothes());

        store.getItems().clear(); // не повинно вплинути на внутрішній список

        assertEquals(1, store.getItemCount());
    }
}