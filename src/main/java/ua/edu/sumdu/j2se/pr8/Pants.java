package ua.edu.sumdu.j2se.pr8;

/**
 * Похідний клас "Штани".
 */
public class Pants extends Clothes {

    private int waistSize;
    private int inseamLength;

    public Pants(String name, Size size, String color, double price,
                 Material material, String brand, int quantity,
                 int waistSize, int inseamLength) {
        super(name, size, color, price, material, brand, quantity);
        validatePositive(waistSize, "waistSize");
        validatePositive(inseamLength, "inseamLength");
        this.waistSize = waistSize;
        this.inseamLength = inseamLength;
    }

    public int getWaistSize() { return waistSize; }
    public void setWaistSize(int waistSize) { validatePositive(waistSize, "waistSize"); this.waistSize = waistSize; }

    public int getInseamLength() { return inseamLength; }
    public void setInseamLength(int inseamLength) { validatePositive(inseamLength, "inseamLength"); this.inseamLength = inseamLength; }

    private static void validatePositive(int value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException("Поле '" + fieldName + "' має бути більше за 0, отримано: " + value);
        }
    }

    @Override
    public String toString() {
        return "Pants{base=" + super.toString()
                + ", waistSize=" + waistSize + "см"
                + ", inseamLength=" + inseamLength + "см}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pants p = (Pants) o;
        return waistSize == p.waistSize && inseamLength == p.inseamLength;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + waistSize;
        result = 31 * result + inseamLength;
        return result;
    }
}