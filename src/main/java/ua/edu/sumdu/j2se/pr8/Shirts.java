package ua.edu.sumdu.j2se.pr8;

/**
 * Похідний клас "Сорочки".
 */
public class Shirts extends Clothes {

    private boolean longSleeve;
    private boolean hasCollar;

    public Shirts(String name, Size size, String color, double price,
                  Material material, String brand, int quantity,
                  boolean longSleeve, boolean hasCollar) {
        super(name, size, color, price, material, brand, quantity);
        this.longSleeve = longSleeve;
        this.hasCollar = hasCollar;
    }

    public boolean isLongSleeve() { return longSleeve; }
    public void setLongSleeve(boolean longSleeve) { this.longSleeve = longSleeve; }

    public boolean isHasCollar() { return hasCollar; }
    public void setHasCollar(boolean hasCollar) { this.hasCollar = hasCollar; }

    @Override
    public String toString() {
        return "Shirts{base=" + super.toString()
                + ", longSleeve=" + (longSleeve ? "довгий" : "короткий")
                + ", hasCollar=" + (hasCollar ? "так" : "ні") + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shirts s = (Shirts) o;
        return longSleeve == s.longSleeve && hasCollar == s.hasCollar;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (longSleeve ? 1 : 0);
        result = 31 * result + (hasCollar ? 1 : 0);
        return result;
    }
}