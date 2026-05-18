package ua.edu.sumdu.j2se.pr8;

import java.util.Objects;

/**
 * Базовий клас одягу для лабораторної роботи №8.
 */
public class Clothes {

    private String name;
    private Size size;
    private String color;
    private double price;
    private Material material;
    private String brand;
    private int quantity;

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
    }

    public Clothes(Clothes other) {
        if (other == null) {
            throw new IllegalArgumentException("Об'єкт для копіювання не може бути null");
        }
        this.name = other.name;
        this.size = other.size;
        this.color = other.color;
        this.price = other.price;
        this.material = other.material;
        this.brand = other.brand;
        this.quantity = other.quantity;
    }

    public String getName() { return name; }
    public void setName(String name) { validateString(name, "name"); this.name = name; }

    public Size getSize() { return size; }
    public void setSize(Size size) { validateNotNull(size, "size"); this.size = size; }

    public String getColor() { return color; }
    public void setColor(String color) { validateString(color, "color"); this.color = color; }

    public double getPrice() { return price; }
    public void setPrice(double price) { validatePrice(price); this.price = price; }

    public Material getMaterial() { return material; }
    public void setMaterial(Material material) { validateNotNull(material, "material"); this.material = material; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { validateString(brand, "brand"); this.brand = brand; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { validateQuantity(quantity); this.quantity = quantity; }

    protected static void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Поле '" + fieldName + "' не може бути null або порожнім");
        }
    }

    protected static void validateNotNull(Object value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException("Поле '" + fieldName + "' не може бути null");
        }
    }

    protected static void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна має бути більшою за 0, отримано: " + price);
        }
    }

    protected static void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Кількість не може бути від'ємною, отримано: " + quantity);
        }
    }

    @Override
    public String toString() {
        return "Clothes{name='" + name + '\''
                + ", size=" + size
                + ", color='" + color + '\''
                + ", price=" + price
                + ", material=" + material + " (" + material.getDescription() + ")"
                + ", brand='" + brand + '\''
                + ", quantity=" + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes c = (Clothes) o;
        return Double.compare(c.price, price) == 0 && quantity == c.quantity
                && Objects.equals(name, c.name) && size == c.size
                && Objects.equals(color, c.color) && material == c.material
                && Objects.equals(brand, c.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, color, price, material, brand, quantity);
    }
}