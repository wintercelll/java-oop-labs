package ua.edu.sumdu.j2se.pr6;

/**
 * Перерахування можливих матеріалів виготовлення одягу.
 * Кожне значення має українську назву для зручного виведення.
 */
public enum Material {
    COTTON("Бавовна"),
    POLYESTER("Поліестер"),
    WOOL("Вовна"),
    SILK("Шовк"),
    LINEN("Льон");

    private final String description;

    /**
     * Конструктор перерахування з описом.
     *
     * @param description українська назва матеріалу
     */
    Material(String description) {
        this.description = description;
    }

    /**
     * Повертає українську назву матеріалу.
     *
     * @return опис українською мовою
     */
    public String getDescription() {
        return description;
    }
}