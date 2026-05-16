package ua.edu.sumdu.j2se.pr6;

import ua.edu.sumdu.j2se.pr5.Clothes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Драйвер-клас з консольним меню для роботи з об'єктами {@link ua.edu.sumdu.j2se.pr5.Clothes}.
 * Підтримує створення нових об'єктів, перегляд списку та коректну
 * обробку помилок введення (нечислове введення, порожні рядки,
 * некоректні значення).
 */
public class MainClass {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Точка входу програми. Запускає головний цикл меню.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        List<ua.edu.sumdu.j2se.pr5.Clothes> items = new ArrayList<>();

        while (true) {
            printMenu();
            int choice = readIntSafe("Ваш вибір: ");

            switch (choice) {
                case 1:
                    ua.edu.sumdu.j2se.pr5.Clothes c = readClothes();
                    if (c != null) {
                        items.add(c);
                        System.out.println("Об'єкт успішно додано.");
                    }
                    break;
                case 2:
                    displayAll(items);
                    break;
                case 3:
                    System.out.println("Завершення роботи.");
                    SCANNER.close();
                    return;
                default:
                    System.out.println("Невідомий пункт меню. Спробуйте ще раз.");
            }
        }
    }

    /** Виводить пункти головного меню. */
    private static void printMenu() {
        System.out.println();
        System.out.println("=== МЕНЮ ===");
        System.out.println("1. Створити новий об'єкт");
        System.out.println("2. Вивести інформацію про всі об'єкти");
        System.out.println("3. Завершити роботу");
    }

    /**
     * Виводить список усіх об'єктів через {@link ua.edu.sumdu.j2se.pr5.Clothes#toString()}.
     *
     * @param items список об'єктів
     */
    private static void displayAll(List<ua.edu.sumdu.j2se.pr5.Clothes> items) {
        if (items.isEmpty()) {
            System.out.println("Список порожній.");
            return;
        }
        System.out.println("=== Список об'єктів (всього: " + items.size() + ") ===");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    /**
     * Зчитує всі поля з клавіатури та намагається створити об'єкт {@link ua.edu.sumdu.j2se.pr5.Clothes}.
     * При помилках валідації виводить повідомлення і повертає null.
     *
     * @return новий об'єкт або null, якщо валідація не пройшла
     */
    private static ua.edu.sumdu.j2se.pr5.Clothes readClothes() {
        String name = readStringSafe("Назва: ");
        String size = readStringSafe("Розмір (S/M/L/XL/XXL): ");
        String color = readStringSafe("Колір: ");
        double price = readDoubleSafe("Ціна: ");
        String material = readStringSafe("Матеріал: ");
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
     * Зчитує непорожній рядок. Повторює запит, якщо введено порожній рядок.
     *
     * @param prompt текст запрошення
     * @return непорожній рядок
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
     *
     * @param prompt текст запрошення
     * @return ціле число
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
     * Зчитує дійсне число. Повторює запит при нечисловому вводі.
     * Допускає кому як десятковий розділювач.
     *
     * @param prompt текст запрошення
     * @return дійсне число
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