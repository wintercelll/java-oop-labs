package ua.edu.sumdu.j2se.pr4;

import java.util.Random;
import java.util.Scanner;

/**
 * Драйвер-клас для демонстрації роботи з масивом об'єктів {@link Clothes}.
 * Запитує у користувача кількість предметів та частину їх характеристик,
 * заповнює інші поля програмно та виводить інформацію про всі предмети.
 */
public class MainClass {

    /** Можливі кольори для випадкового вибору. */
    private static final String[] COLORS = {"Red", "Blue", "Green", "Black", "White", "Yellow"};

    /** Можливі матеріали для випадкового вибору. */
    private static final String[] MATERIALS = {"Cotton", "Polyester", "Wool", "Silk", "Linen"};

    /**
     * Точка входу програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть кількість предметів одягу: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // прибрати залишок переведення рядка після nextInt

        Clothes[] clothesArray = new Clothes[count];

        for (int i = 0; i < count; i++) {
            System.out.println();
            System.out.println("--- Предмет " + (i + 1) + " ---");

            System.out.print("Назва: ");
            String name = scanner.nextLine();

            System.out.print("Розмір (S/M/L/XL): ");
            String size = scanner.nextLine();

            String color = COLORS[random.nextInt(COLORS.length)];
            String material = MATERIALS[random.nextInt(MATERIALS.length)];
            double price = 100 + random.nextInt(1901); // від 100 до 2000

            clothesArray[i] = new Clothes(name, size, color, price, material);
        }

        System.out.println();
        System.out.println("=== Список усіх предметів одягу ===");
        for (int i = 0; i < clothesArray.length; i++) {
            System.out.println((i + 1) + ". " + clothesArray[i]);
        }

        // Демонстрація роботи equals()
        if (clothesArray.length >= 2) {
            System.out.println();
            System.out.println("=== Демонстрація equals() ===");
            System.out.println("Предмет 1 == Предмет 2 ? "
                    + clothesArray[0].equals(clothesArray[1]));
            System.out.println("Предмет 1 == Предмет 1 ? "
                    + clothesArray[0].equals(clothesArray[0]));
        }

        scanner.close();
    }
}