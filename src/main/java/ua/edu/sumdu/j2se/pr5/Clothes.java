package ua.edu.sumdu.j2se.pr5;

import java.util.Objects;

/**
 * Розширений клас предметної області для лабораторної роботи №5.
 * Описує одиницю одягу з характеристиками: назва, розмір, колір, ціна,
 * матеріал, бренд та кількість на складі. Усі поля проходять валідацію
 * у конструкторі та сетерах; при некоректних даних кидається
 * {@link IllegalArgumentException}.
 */
public class Clothes {

    /** Дозволені значення для поля size. */
    private static final String[] ALLOWED_SIZES = {"S", "M", "L", "XL", "XXL"};

    private String name;
    private String size;
    private String color;
    private double price;
    private String material;
    private String brand;
    private int quantity;

    /**
     * Створює новий об'єкт одягу з усіма характеристиками.
     * Усі параметри валідуються; при некоректних значеннях кидається виняток.
     *
     * @param name     назва (не null, не порожня)
     * @param size     розмір (S / M / L / XL / XXL)
     * @param color    колір (не null, не порожній)
     * @param price    ціна (> 0)
     * @param material матеріал (не null, не порожній)
     * @param brand    бренд (не null, не порожній)
     * @param quantity кількість на складі (>= 0)
     * @throws IllegalArgumentException при некоректних вхідних даних
     */
    public Clothes(String name, String size, String color, double price,
                   String material, String brand, int quantity) {
        validateString(name, "name");
        validateSize(size);
        validateString(color, "color");
        validatePrice(price);
        validateString(material, "material");
        validateString(brand, "brand");
        validateQuantity(quantity);

        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.material = material;
        this.brand = brand;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateString(name, "name");
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        validateSize(size);
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        validateString(material, "material");
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
     * Перевіряє, що розмір — одне з дозволених значень.
     *
     * @param size значення розміру
     * @throws IllegalArgumentException якщо розмір некоректний
     */
    private static void validateSize(String size) {
        if (size == null) {
            throw new IllegalArgumentException("Розмір не може бути null");
        }
        for (String allowed : ALLOWED_SIZES) {
            if (allowed.equals(size)) {
                return;
            }
        }
        throw new IllegalArgumentException(
                "Некоректний розмір: '" + size + "'. Допустимі: S, M, L, XL, XXL");
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
                + ", size='" + size + '\''
                + ", color='" + color + '\''
                + ", price=" + price
                + ", material='" + material + '\''
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
                && Objects.equals(size, clothes.size)
                && Objects.equals(color, clothes.color)
                && Objects.equals(material, clothes.material)
                && Objects.equals(brand, clothes.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, color, price, material, brand, quantity);
    }
}