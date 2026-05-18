package ua.edu.sumdu.j2se.pr7;

/**
 * Похідний клас "Сорочки" — наслідує {@link Clothes}.
 * Додає специфічні характеристики: тип рукава та наявність комірця.
 */
public class Shirts extends Clothes {

    private boolean longSleeve;
    private boolean hasCollar;

    /**
     * Створює об'єкт сорочки з усіма характеристиками.
     * Поля базового класу делегуються у конструктор {@link Clothes}.
     *
     * @param name        назва (не null, не порожня)
     * @param size        розмір (enum {@link Size}, не null)
     * @param color       колір (не null, не порожній)
     * @param price       ціна (> 0)
     * @param material    матеріал (enum {@link Material}, не null)
     * @param brand       бренд (не null, не порожній)
     * @param quantity    кількість на складі (>= 0)
     * @param longSleeve  true — довгий рукав, false — короткий
     * @param hasCollar   true — є комірець, false — без коміра
     */
    public Shirts(String name, Size size, String color, double price,
                  Material material, String brand, int quantity,
                  boolean longSleeve, boolean hasCollar) {
        super(name, size, color, price, material, brand, quantity);
        this.longSleeve = longSleeve;
        this.hasCollar = hasCollar;
    }

    public boolean isLongSleeve() {
        return longSleeve;
    }

    public void setLongSleeve(boolean longSleeve) {
        this.longSleeve = longSleeve;
    }

    public boolean isHasCollar() {
        return hasCollar;
    }

    public void setHasCollar(boolean hasCollar) {
        this.hasCollar = hasCollar;
    }

    /**
     * Перевизначений toString — додає інформацію про рукав та комірець.
     */
    @Override
    public String toString() {
        return "Shirts{"
                + "base=" + super.toString()
                + ", longSleeve=" + (longSleeve ? "довгий" : "короткий")
                + ", hasCollar=" + (hasCollar ? "так" : "ні")
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shirts shirts = (Shirts) o;
        return longSleeve == shirts.longSleeve
                && hasCollar == shirts.hasCollar;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (longSleeve ? 1 : 0);
        result = 31 * result + (hasCollar ? 1 : 0);
        return result;
    }
}