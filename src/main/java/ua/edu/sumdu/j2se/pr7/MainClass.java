package ua.edu.sumdu.j2se.pr7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Драйвер-клас для лабораторної роботи №7.
 * Демонструє наслідування та поліморфізм:
 * усі об'єкти (Clothes, Pants, Shirts) зберігаються в єдиному
 * списку {@code List<Clothes>} і обробляються через посилання
 * на базовий тип.
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
            printMenu();
            int choice = readIntSafe("Ваш вибір: ");

            switch (choice) {
                case 1:
                    Clothes c = readClothes();
                    if (c != null) {
                        items.add(c);
                        System.out.println("Додано базовий об'єкт Clothes.");
                    }
                    break;
                case 2:
                    Pants p = readPants();
                    if (p != null) {
                        items.add(p);
                        System.out.println("Додано об'єкт Pants.");
                    }
                    break;
                case 3:
                    Shirts s = readShirts();
                    if (s != null) {
                        items.add(s);
                        System.out.println("Додано об'єкт Shirts.");
                    }
                    break;
                case 4:
                    displayAll(items);
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
        System.out.println("  Лабораторна робота №7");
        System.out.println("  ООП на мові Java, СумДУ, гр. ІН-31/2");
        System.out.println("  Віхтенко Данило");
        System.out.println("  Варіант 1: Clothes -> Pants, Shirts");
        System.out.println("========================================");
    }

    /** Виводить пункти головного меню. */
    private static void printMenu() {
        System.out.println();
        System.out.println("=== МЕНЮ ===");
        System.out.println("1. Створити Clothes (базовий клас)");
        System.out.println("2. Створити Pants (штани)");
        System.out.println("3. Створити Shirts (сорочка)");
        System.out.println("4. Вивести інформацію про всі об'єкти");
        System.out.println("5. Завершити роботу");
    }

    /**
     * Виводить усі об'єкти через посилання базового типу — демонстрація
     * поліморфізму. Метод toString() викликається динамічно
     * відповідно до фактичного типу об'єкта.
     *
     * @param items список усіх об'єктів
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

    /** Зчитує базовий об'єкт Clothes з клавіатури. */
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

    /** Зчитує об'єкт Pants з клавіатури. */
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

    /** Зчитує об'єкт Shirts з клавіатури. */
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

    /** Зчитує boolean як "так"/"ні". */
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