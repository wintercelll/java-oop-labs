package ua.edu.sumdu.j2se.pr8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Драйвер-клас для лабораторної роботи №8.
 * Демонструє розширену ієрархію класів (5 типів) та поліморфізм:
 * усі об'єкти зберігаються в єдиному {@code List<Clothes>}.
 * Меню має головну частину (3 пункти) та підменю вибору типу
 * з можливістю повернення без створення.
 */
public class MainClass {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Точка входу програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        printInfoHeader();
        List<Clothes> items = new ArrayList<>();

        while (true) {
            printMainMenu();
            int choice = readIntSafe("Ваш вибір: ");

            switch (choice) {
                case 1:
                    handleCreate(items);
                    break;
                case 2:
                    displayAll(items);
                    break;
                case 3:
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
        System.out.println("  Лабораторна робота №8");
        System.out.println("  ООП на мові Java, СумДУ, гр. ІН-31/2");
        System.out.println("  Віхтенко Данило");
        System.out.println("  Варіант 1: Clothes -> Pants, Shirts, Jackets, Shoes");
        System.out.println("========================================");
    }

    /** Виводить головне меню (3 пункти). */
    private static void printMainMenu() {
        System.out.println();
        System.out.println("=== ГОЛОВНЕ МЕНЮ ===");
        System.out.println("1. Створити новий об'єкт");
        System.out.println("2. Вивести інформацію про всі об'єкти");
        System.out.println("3. Завершити роботу");
    }

    /**
     * Обробляє пункт "Створити новий об'єкт" — показує підменю
     * вибору типу з опцією повернення.
     *
     * @param items колекція для додавання нового об'єкта
     */
    private static void handleCreate(List<Clothes> items) {
        while (true) {
            System.out.println();
            System.out.println("=== ВИБІР ТИПУ ===");
            System.out.println("1. Clothes (базовий клас одягу)");
            System.out.println("2. Pants (штани)");
            System.out.println("3. Shirts (сорочка)");
            System.out.println("4. Jackets (куртка)");
            System.out.println("5. Shoes (взуття)");
            System.out.println("6. Назад до головного меню");

            int type = readIntSafe("Тип: ");
            Clothes created = null;

            switch (type) {
                case 1: created = readClothes(); break;
                case 2: created = readPants(); break;
                case 3: created = readShirts(); break;
                case 4: created = readJackets(); break;
                case 5: created = readShoes(); break;
                case 6:
                    System.out.println("Повернення до головного меню без створення.");
                    return;
                default:
                    System.out.println("Невідомий тип. Спробуйте ще раз.");
                    continue;
            }

            if (created != null) {
                items.add(created);
                System.out.println("Об'єкт додано: [" + created.getClass().getSimpleName() + "]");
            }
            return;
        }
    }

    /**
     * Виводить усі об'єкти через посилання базового типу — поліморфізм.
     *
     * @param items колекція об'єктів
     */
    private static void displayAll(List<Clothes> items) {
        if (items.isEmpty()) {
            System.out.println("Список порожній.");
            return;
        }
        System.out.println("=== Усі об'єкти (всього: " + items.size() + ") ===");
        for (int i = 0; i < items.size(); i++) {
            Clothes item = items.get(i);
            System.out.println((i + 1) + ". [" + item.getClass().getSimpleName() + "] " + item);
        }
    }

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
            System.out.println("ПОМИЛКА створення Clothes: " + e.getMessage());
            return null;
        }
    }

    private static Pants readPants() {
        String name = readStringSafe("Назва: ");
        Size size = readSize();
        String color = readStringSafe("Колір: ");
        double price = readDoubleSafe("Ціна: ");
        Material material = readMaterial();
        String brand = readStringSafe("Бренд: ");
        int quantity = readIntSafe("Кількість на складі: ");
        int waistSize = readIntSafe("Об'єм талії (см): ");
        int inseamLength = readIntSafe("Довжина внутрішнього шва (см): ");

        try {
            return new Pants(name, size, color, price, material, brand, quantity,
                    waistSize, inseamLength);
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА створення Pants: " + e.getMessage());
            return null;
        }
    }

    private static Shirts readShirts() {
        String name = readStringSafe("Назва: ");
        Size size = readSize();
        String color = readStringSafe("Колір: ");
        double price = readDoubleSafe("Ціна: ");
        Material material = readMaterial();
        String brand = readStringSafe("Бренд: ");
        int quantity = readIntSafe("Кількість на складі: ");
        boolean longSleeve = readBooleanSafe("Довгий рукав? (так/ні): ");
        boolean hasCollar = readBooleanSafe("Є комірець? (так/ні): ");

        try {
            return new Shirts(name, size, color, price, material, brand, quantity,
                    longSleeve, hasCollar);
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА створення Shirts: " + e.getMessage());
            return null;
        }
    }

    private static Jackets readJackets() {
        String name = readStringSafe("Назва: ");
        Size size = readSize();
        String color = readStringSafe("Колір: ");
        double price = readDoubleSafe("Ціна: ");
        Material material = readMaterial();
        String brand = readStringSafe("Бренд: ");
        int quantity = readIntSafe("Кількість на складі: ");
        boolean waterproof = readBooleanSafe("Водонепроникна? (так/ні): ");
        boolean hooded = readBooleanSafe("З капюшоном? (так/ні): ");

        try {
            return new Jackets(name, size, color, price, material, brand, quantity,
                    waterproof, hooded);
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА створення Jackets: " + e.getMessage());
            return null;
        }
    }

    private static Shoes readShoes() {
        String name = readStringSafe("Назва: ");
        Size size = readSize();
        String color = readStringSafe("Колір: ");
        double price = readDoubleSafe("Ціна: ");
        Material material = readMaterial();
        String brand = readStringSafe("Бренд: ");
        int quantity = readIntSafe("Кількість на складі: ");
        int heelHeight = readIntSafe("Висота каблука (мм): ");
        String shoeType = readStringSafe("Тип взуття (running/casual/formal): ");

        try {
            return new Shoes(name, size, color, price, material, brand, quantity,
                    heelHeight, shoeType);
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА створення Shoes: " + e.getMessage());
            return null;
        }
    }

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

    private static boolean readBooleanSafe(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim().toLowerCase();
            if (line.equals("так") || line.equals("yes") || line.equals("y")) {
                return true;
            }
            if (line.equals("ні") || line.equals("no") || line.equals("n")) {
                return false;
            }
            System.out.println("ПОМИЛКА: введіть 'так' або 'ні'.");
        }
    }
}