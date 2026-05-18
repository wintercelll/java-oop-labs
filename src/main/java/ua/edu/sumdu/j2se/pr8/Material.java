package ua.edu.sumdu.j2se.pr8;

/**
 * Перерахування можливих матеріалів виготовлення одягу.
 */
public enum Material {
    COTTON("Бавовна"),
    POLYESTER("Поліестер"),
    WOOL("Вовна"),
    SILK("Шовк"),
    LINEN("Льон");

    private final String description;

    Material(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}