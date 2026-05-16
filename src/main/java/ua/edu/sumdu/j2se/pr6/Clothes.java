package ua.edu.sumdu.j2se.pr6;

import java.util.Objects;

/**
 * Розширений клас предметної області для лабораторної роботи №6.
 * Описує одиницю одягу. Поля size та material — типи перерахувань
 * ({@link Size}, {@link Material}), що гарантує обмежений набір значень
 * на рівні типів. Усі поля проходять валідацію у конструкторі та сетерах.
 * Клас містить статичний лічильник створених об'єктів та конструктор копіювання.
 */
public class Clothes {

    /** Лічильник створених об'єктів класу (статичне поле). */
    private static int instanceCount = 0;

    private String name;
    private Size size;
    private String color;
    private double price;
    private Material material;
    private String brand;
    private int quantity;

    /**
     * Створює новий об'єкт одягу з усіма характеристиками.
     *
     * @param name     назва (не null, не порожня)
     * @param size     розмір (enum {@link Size}, не null)
     * @param color    колір (не null, не порожній)
     * @param price    ціна (> 0)
     * @param material матеріал (enum {@link Material}, не null)
     * @param brand    бренд (не null, не порожній)
     * @param quantity кількість на складі (>= 0)
     * @throws IllegalArgumentException при некоректних вхідних даних
     */
    public Clothes(String name, Size size, String color, double price,
                   Material material, String brand, int quantity) {
        validateString(name, "name");
        validateNotNull(size, "size");
        validateString(color, "color");
        validatePrice(price);
        validateNotNull(material, "material");
        validateString(brand, "brand");
        validateQuantity(quantity);

        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.material = material;
        this.brand = brand;
        this.quantity = quantity;

        instanceCount++;
    }

    /**
     * Конструктор копіювання. Створює новий об'єкт з полями,
     * скопійованими з {@code other}. Лічильник об'єктів збільшується.
     *
     * @param other об'єкт для копіювання (не null)
     * @throws IllegalArgumentException якщо other == null
     */
    public Clothes(Clothes other) {
        if (other == null) {
            throw new IllegalArgumentException(
                    "Об'єкт для копіювання не може бути null");
        }
        this.name = other.name;
        this.size = other.size;
        this.color = other.color;
        this.price = other.price;
        this.material = other.material;
        this.brand = other.brand;
        this.quantity = other.quantity;

        instanceCount++;
    }

    /**
     * Повертає кількість створених об'єктів класу {@link Clothes}.
     *
     * @return загальна кількість створених екземплярів
     */
    public static int getInstanceCount() {
        return instanceCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateString(name, "name");
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        validateNotNull(size, "size");
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        validateString(color, "color");
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        validateNotNull(material, "material");
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        validateString(brand, "brand");
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    /**
     * Перевіряє, що рядок не null та не порожній.
     *
     * @param value     значення для перевірки
     * @param fieldName ім'я поля для повідомлення про помилку
     * @throws IllegalArgumentException якщо значення null або порожнє
     */
    private static void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Поле '" + fieldName + "' не може бути null або порожнім");
        }
    }

    /**
     * Перевіряє, що об'єкт не null.
     *
     * @param value     значення для перевірки
     * @param fieldName ім'я поля для повідомлення про помилку
     * @throws IllegalArgumentException якщо значення null
     */
    private static void validateNotNull(Object value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Поле '" + fieldName + "' не може бути null");
        }
    }

    /**
     * Перевіряє, що ціна > 0.
     *
     * @param price значення ціни
     * @throws IllegalArgumentException якщо ціна <= 0
     */
    private static void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(
                    "Ціна має бути більшою за 0, отримано: " + price);
        }
    }

    /**
     * Перевіряє, що кількість >= 0.
     *
     * @param quantity значення кількості
     * @throws IllegalArgumentException якщо кількість < 0
     */
    private static void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Кількість не може бути від'ємною, отримано: " + quantity);
        }
    }

    @Override
    public String toString() {
        return "Clothes{"
                + "name='" + name + '\''
                + ", size=" + size
                + ", color='" + color + '\''
                + ", price=" + price
                + ", material=" + material + " (" + material.getDescription() + ")"
                + ", brand='" + brand + '\''
                + ", quantity=" + quantity
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return Double.compare(clothes.price, price) == 0
                && quantity == clothes.quantity
                && Objects.equals(name, clothes.name)
                && size == clothes.size
                && Objects.equals(color, clothes.color)
                && material == clothes.material
                && Objects.equals(brand, clothes.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, color, price, material, brand, quantity);
    }
}