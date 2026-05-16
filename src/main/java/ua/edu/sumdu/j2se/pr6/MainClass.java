package ua.edu.sumdu.j2se.pr6;

import java.util.Scanner;

/**
 * Драйвер-клас для лабораторної роботи №6.
 * Демонструє роботу з enum-полями, копі-конструктором,
 * статичним лічильником об'єктів та класом-агрегатором {@link Store}.
 */
public class MainClass {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Точка входу програми. Виводить інформаційну шапку,
     * створює магазин і запускає головний цикл меню.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        printInfoHeader();

        Store store = new Store("Модний одяг");
        Clothes lastCreated = null;

        while (true) {
            printMenu();
            int choice = readIntSafe("Ваш вибір: ");

            switch (choice) {
                case 1:
                    Clothes created = readClothes();
                    if (created != null) {
                        store.addItem(created);
                        lastCreated = created;
                        System.out.println("Об'єкт успішно додано в магазин.");
                    }
                    break;
                case 2:
                    if (lastCreated == null) {
                        System.out.println("Спочатку створіть хоча б один об'єкт.");
                    } else {
                        Clothes copy = new Clothes(lastCreated);
                        store.addItem(copy);
                        System.out.println("Створено копію: " + copy);
                    }
                    break;
                case 3:
                    store.printInventory();
                    break;
                case 4:
                    System.out.println("Загальна кількість створених об'єктів Clothes: "
                            + Clothes.getInstanceCount());
                    break;
                case 5:
                    System.out.println("Завершення роботи.");
                    SCANNER.close();
                    return;
                default:
                    System.out.println("Невідомий пункт меню.");
            }
        }
    }

    /** Виводить інформаційну шапку програми. */
    private static void printInfoHeader() {
        System.out.println("========================================");
        System.out.println("  Лабораторна робота №6");
        System.out.println("  ООП на мові Java, СумДУ, гр. ІН-31/2");
        System.out.println("  Віхтенко Данило");
        System.out.println("  Варіант 1: Clothes + Store");
        System.out.println("========================================");
    }

    /** Виводить пункти головного меню. */
    private static void printMenu() {
        System.out.println();
        System.out.println("=== МЕНЮ ===");
        System.out.println("1. Створити новий об'єкт Clothes");
        System.out.println("2. Створити копію останнього об'єкта (копі-конструктор)");
        System.out.println("3. Вивести інвентар магазину");
        System.out.println("4. Кількість створених об'єктів (статичний лічильник)");
        System.out.println("5. Завершити роботу");
    }

    /**
     * Зчитує всі поля з клавіатури та намагається створити об'єкт {@link Clothes}.
     *
     * @return новий об'єкт або null, якщо валідація не пройшла
     */
    private static Clothes readClothes() {
        String name = readStringSafe("Назва: ");
        Size size = readSize();
        String color = readStringSafe("Колір: ");
        double price = readDoubleSafe("Ціна: ");
        Material material = readMaterial();
        String brand = readStringSafe("Бренд: ");
        int quantity = readIntSafe("Кількість на складі: ");

        try {
            return new Clothes(name, size, color, price, material, brand, quantity);
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА створення об'єкта: " + e.getMessage());
            return null;
        }
    }

    /**
     * Зчитує значення enum {@link Size} від користувача.
     * Виводить список доступних варіантів та повторює запит при помилці.
     *
     * @return обране значення Size
     */
    private static Size readSize() {
        while (true) {
            System.out.print("Доступні розміри: ");
            for (Size s : Size.values()) {
                System.out.print(s + " ");
            }
            System.out.println();
            System.out.print("Розмір: ");
            String input = SCANNER.nextLine().trim().toUpperCase();
            try {
                return Size.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("ПОМИЛКА: невідомий розмір.");
            }
        }
    }

    /**
     * Зчитує значення enum {@link Material} від користувача.
     * Виводить список доступних варіантів з описами.
     *
     * @return обране значення Material
     */
    private static Material readMaterial() {
        while (true) {
            System.out.println("Доступні матеріали:");
            for (Material m : Material.values()) {
                System.out.println("  " + m + " (" + m.getDescription() + ")");
            }
            System.out.print("Матеріал: ");
            String input = SCANNER.nextLine().trim().toUpperCase();
            try {
                return Material.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("ПОМИЛКА: невідомий матеріал.");
            }
        }
    }

    /**
     * Зчитує непорожній рядок. Повторює запит, якщо введено порожній рядок.
     */
    private static String readStringSafe(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("ПОМИЛКА: рядок не може бути порожнім.");
        }
    }

    /**
     * Зчитує ціле число. Повторює запит при нечисловому вводі.
     */
    private static int readIntSafe(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("ПОМИЛКА: треба ввести ціле число.");
            }
        }
    }

    /**
     * Зчитує дійсне число. Підтримує кому як десятковий розділювач.
     */
    private static double readDoubleSafe(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("ПОМИЛКА: треба ввести число.");
            }
        }
    }
}