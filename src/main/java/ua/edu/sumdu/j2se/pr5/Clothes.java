package ua.edu.sumdu.j2se.pr5;

import java.util.Objects;

/**
 * Клас предметної області, що описує одиницю одягу.
 * Містить характеристики: назва, розмір, колір, ціна, матеріал.
 */
public class Clothes {

    private String name;
    private String size;
    private String color;
    private double price;
    private String material;

    /**
     * Створює новий об'єкт одягу з усіма характеристиками.
     *
     * @param name     назва предмета одягу
     * @param size     розмір (S, M, L, XL тощо)
     * @param color    колір
     * @param price    ціна в гривнях
     * @param material матеріал виготовлення
     */
    public Clothes(String name, String size, String color, double price, String material) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.material = material;
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
                + '}';
    }

    /**
     * Перевіряє рівність двох об'єктів одягу.
     * Два об'єкти рівні, якщо всі їхні поля збігаються.
     *
     * @param o інший об'єкт для порівняння
     * @return true якщо об'єкти рівні
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return Double.compare(clothes.price, price) == 0
                && Objects.equals(name, clothes.name)
                && Objects.equals(size, clothes.size)
                && Objects.equals(color, clothes.color)
                && Objects.equals(material, clothes.material);
    }

    /**
     * Хеш-код об'єкта. Узгоджений з equals.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, size, color, price, material);
    }
}