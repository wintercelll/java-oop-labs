package ua.edu.sumdu.j2se.pr7;

/**
 * Похідний клас "Штани" — наслідує {@link Clothes}.
 * Додає специфічні характеристики: об'єм талії та довжина внутрішнього шва.
 */
public class Pants extends Clothes {

    private int waistSize;
    private int inseamLength;

    /**
     * Створює об'єкт штанів з усіма характеристиками.
     * Поля базового класу делегуються у конструктор {@link Clothes}.
     *
     * @param name         назва (не null, не порожня)
     * @param size         розмір (enum {@link Size}, не null)
     * @param color        колір (не null, не порожній)
     * @param price        ціна (> 0)
     * @param material     матеріал (enum {@link Material}, не null)
     * @param brand        бренд (не null, не порожній)
     * @param quantity     кількість на складі (>= 0)
     * @param waistSize    об'єм талії в см (> 0)
     * @param inseamLength довжина внутрішнього шва в см (> 0)
     * @throws IllegalArgumentException при некоректних вхідних даних
     */
    public Pants(String name, Size size, String color, double price,
                 Material material, String brand, int quantity,
                 int waistSize, int inseamLength) {
        super(name, size, color, price, material, brand, quantity);
        validatePositive(waistSize, "waistSize");
        validatePositive(inseamLength, "inseamLength");
        this.waistSize = waistSize;
        this.inseamLength = inseamLength;
    }

    public int getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(int waistSize) {
        validatePositive(waistSize, "waistSize");
        this.waistSize = waistSize;
    }

    public int getInseamLength() {
        return inseamLength;
    }

    public void setInseamLength(int inseamLength) {
        validatePositive(inseamLength, "inseamLength");
        this.inseamLength = inseamLength;
    }

    /**
     * Перевіряє, що ціле число > 0.
     */
    private static void validatePositive(int value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException(
                    "Поле '" + fieldName + "' має бути більше за 0, отримано: " + value);
        }
    }

    /**
     * Перевизначений toString — додає інформацію про талію та довжину шва.
     */
    @Override
    public String toString() {
        return "Pants{"
                + "base=" + super.toString()
                + ", waistSize=" + waistSize + "см"
                + ", inseamLength=" + inseamLength + "см"
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pants pants = (Pants) o;
        return waistSize == pants.waistSize
                && inseamLength == pants.inseamLength;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + waistSize;
        result = 31 * result + inseamLength;
        return result;
    }
}