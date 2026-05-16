package ua.edu.sumdu.j2se.pr6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Клас "Магазин" — демонструє принцип агрегації.
 * Містить колекцію об'єктів {@link Clothes}, які можуть існувати
 * незалежно від конкретного магазину. Магазин має назву та список товарів.
 */
public class Store {

    private String name;
    private final List<Clothes> items;

    /**
     * Створює новий магазин з заданою назвою та порожнім списком товарів.
     *
     * @param name назва магазину (не null, не порожня)
     * @throws IllegalArgumentException якщо name некоректна
     */
    public Store(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Назва магазину не може бути null або порожньою");
        }
        this.name = name;
        this.items = new ArrayList<>();
    }

    /**
     * Додає предмет одягу до магазину.
     *
     * @param item предмет одягу (не null)
     * @throws IllegalArgumentException якщо item == null
     */
    public void addItem(Clothes item) {
        if (item == null) {
            throw new IllegalArgumentException(
                    "Предмет одягу не може бути null");
        }
        items.add(item);
    }

    /**
     * Видаляє предмет одягу з магазину.
     *
     * @param item предмет одягу для видалення
     * @return true, якщо предмет було видалено
     */
    public boolean removeItem(Clothes item) {
        return items.remove(item);
    }

    /**
     * Повертає назву магазину.
     *
     * @return назва магазину
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює нову назву магазину з валідацією.
     *
     * @param name нова назва (не null, не порожня)
     * @throws IllegalArgumentException якщо name некоректна
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Назва магазину не може бути null або порожньою");
        }
        this.name = name;
    }

    /**
     * Повертає копію списку товарів (захист від модифікації ззовні).
     *
     * @return новий список з усіма товарами магазину
     */
    public List<Clothes> getItems() {
        return new ArrayList<>(items);
    }

    /**
     * Повертає кількість різних позицій товарів у магазині.
     *
     * @return кількість позицій
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Обчислює загальну вартість усіх товарів у магазині
     * (сума ціна × кількість для кожної позиції).
     *
     * @return загальна вартість товарів
     */
    public double getTotalValue() {
        double sum = 0;
        for (Clothes item : items) {
            sum += item.getPrice() * item.getQuantity();
        }
        return sum;
    }

    /**
     * Виводить інформацію про магазин і всі товари у консоль.
     */
    public void printInventory() {
        System.out.println("=== Магазин: " + name + " ===");
        if (items.isEmpty()) {
            System.out.println("(порожній)");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.printf("Всього позицій: %d, загальна вартість: %.2f грн%n",
                items.size(), getTotalValue());
    }

    @Override
    public String toString() {
        return "Store{name='" + name + "', itemCount=" + items.size() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(name, store.name)
                && Objects.equals(items, store.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, items);
    }
}