package ua.edu.sumdu.j2se.pr8;

/**
 * Похідний клас "Куртки" — наслідує {@link Clothes}.
 * Додає характеристики водонепроникності та наявності капюшона.
 */
public class Jackets extends Clothes {

    private boolean waterproof;
    private boolean hooded;

    /**
     * Створює об'єкт куртки з усіма характеристиками.
     *
     * @param name       назва (не null, не порожня)
     * @param size       розмір (enum {@link Size}, не null)
     * @param color      колір (не null, не порожній)
     * @param price      ціна (> 0)
     * @param material   матеріал (enum {@link Material}, не null)
     * @param brand      бренд (не null, не порожній)
     * @param quantity   кількість на складі (>= 0)
     * @param waterproof true — водонепроникна, false — звичайна
     * @param hooded     true — з капюшоном, false — без капюшона
     */
    public Jackets(String name, Size size, String color, double price,
                   Material material, String brand, int quantity,
                   boolean waterproof, boolean hooded) {
        super(name, size, color, price, material, brand, quantity);
        this.waterproof = waterproof;
        this.hooded = hooded;
    }

    public boolean isWaterproof() {
        return waterproof;
    }

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    public boolean isHooded() {
        return hooded;
    }

    public void setHooded(boolean hooded) {
        this.hooded = hooded;
    }

    @Override
    public String toString() {
        return "Jackets{base=" + super.toString()
                + ", waterproof=" + (waterproof ? "так" : "ні")
                + ", hooded=" + (hooded ? "з капюшоном" : "без капюшона")
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Jackets jackets = (Jackets) o;
        return waterproof == jackets.waterproof && hooded == jackets.hooded;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (waterproof ? 1 : 0);
        result = 31 * result + (hooded ? 1 : 0);
        return result;
    }
}