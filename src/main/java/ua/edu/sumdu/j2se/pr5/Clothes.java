package ua.edu.sumdu.j2se.pr5;

import java.util.Objects;

/**
 * Розширений клас предметної області для лабораторної роботи №5.
 * Описує одиницю одягу з характеристиками: назва, розмір, колір, ціна,
 * матеріал, бренд та кількість на складі.
 */
public class Clothes {

    private String name;
    private String size;
    private String color;
    private double price;
    private String material;
    private String brand;
    private int quantity;

    /**
     * Створює новий об'єкт одягу з усіма характеристиками.
     *
     * @param name     назва предмета одягу
     * @param size     розмір (S, M, L, XL тощо)
     * @param color    колір
     * @param price    ціна в гривнях
     * @param material матеріал виготовлення
     * @param brand    бренд виробника
     * @param quantity кількість одиниць на складі
     */
    public Clothes(String name, String size, String color, double price,
                   String material, String brand, int quantity) {
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
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Повертає текстовий опис об'єкта одягу.
     *
     * @return рядок із усіма характеристиками
     */
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

    /**
     * Перевіряє рівність двох об'єктів одягу.
     *
     * @param o інший об'єкт для порівняння
     * @return true якщо всі поля збігаються
     */
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

    /**
     * Хеш-код об'єкта. Узгоджений з equals.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, size, color, price, material, brand, quantity);
    }
}