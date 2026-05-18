package ua.edu.sumdu.j2se.pr8;

import java.util.Objects;

/**
 * Похідний клас "Взуття" — наслідує {@link Clothes}.
 * Додає характеристики висоти каблука та типу взуття.
 */
public class Shoes extends Clothes {

    /** Дозволені типи взуття. */
    private static final String[] ALLOWED_TYPES = {"running", "casual", "formal"};

    private int heelHeight;
    private String shoeType;

    /**
     * Створює об'єкт взуття з усіма характеристиками.
     *
     * @param name       назва (не null, не порожня)
     * @param size       розмір (enum {@link Size}, не null)
     * @param color      колір (не null, не порожній)
     * @param price      ціна (> 0)
     * @param material   матеріал (enum {@link Material}, не null)
     * @param brand      бренд (не null, не порожній)
     * @param quantity   кількість на складі (>= 0)
     * @param heelHeight висота каблука в мм (>= 0)
     * @param shoeType   тип взуття (running / casual / formal)
     */
    public Shoes(String name, Size size, String color, double price,
                 Material material, String brand, int quantity,
                 int heelHeight, String shoeType) {
        super(name, size, color, price, material, brand, quantity);
        validateHeelHeight(heelHeight);
        validateShoeType(shoeType);
        this.heelHeight = heelHeight;
        this.shoeType = shoeType;
    }

    public int getHeelHeight() {
        return heelHeight;
    }

    public void setHeelHeight(int heelHeight) {
        validateHeelHeight(heelHeight);
        this.heelHeight = heelHeight;
    }

    public String getShoeType() {
        return shoeType;
    }

    public void setShoeType(String shoeType) {
        validateShoeType(shoeType);
        this.shoeType = shoeType;
    }

    /**
     * Перевіряє, що висота каблука >= 0.
     */
    private static void validateHeelHeight(int heelHeight) {
        if (heelHeight < 0) {
            throw new IllegalArgumentException(
                    "Висота каблука не може бути від'ємною, отримано: " + heelHeight);
        }
    }

    /**
     * Перевіряє, що тип взуття — один із дозволених.
     */
    private static void validateShoeType(String shoeType) {
        if (shoeType == null || shoeType.trim().isEmpty()) {
            throw new IllegalArgumentException("Тип взуття не може бути null або порожнім");
        }
        for (String allowed : ALLOWED_TYPES) {
            if (allowed.equalsIgnoreCase(shoeType)) {
                return;
            }
        }
        throw new IllegalArgumentException(
                "Некоректний тип взуття: '" + shoeType + "'. Допустимі: running, casual, formal");
    }

    @Override
    public String toString() {
        return "Shoes{base=" + super.toString()
                + ", heelHeight=" + heelHeight + "мм"
                + ", shoeType='" + shoeType + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shoes shoes = (Shoes) o;
        return heelHeight == shoes.heelHeight
                && Objects.equals(shoeType, shoes.shoeType);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + heelHeight;
        result = 31 * result + Objects.hashCode(shoeType);
        return result;
    }
}