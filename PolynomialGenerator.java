// Задана натуральная степень k. Сформировать случайным образом список
// коэффициентов
// (значения от 0 до 100) многочлена многочлен степени k.

// Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0

import java.util.Random;
import java.util.Scanner;

public class PolynomialGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Запрашиваем степень многочлена
        System.out.print("Enter the degree of the polynomial (k): ");
        int k = scanner.nextInt(); // Пользователь вводит степень многочлена, например, 3

        // Генерируем случайные коэффициенты
        int[] coefficients = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            coefficients[i] = random.nextInt(101); // Коэффициенты от 0 до 100
        }

        // Строим строку для многочлена
        StringBuilder polynomial = new StringBuilder();
        for (int i = k; i >= 0; i--) {
            int coefficient = coefficients[i];
            if (coefficient != 0) {
                if (polynomial.length() > 0) {
                    polynomial.append(" + ");
                }
                if (i == 0) {
                    polynomial.append(coefficient);
                } else if (i == 1) {
                    polynomial.append(coefficient).append("*x");
                } else {
                    polynomial.append(coefficient).append("*x^").append(i);
                }
            }
        }

        // Если все коэффициенты равны 0
        if (polynomial.length() == 0) {
            polynomial.append("0");
        }

        // Добавляем "= 0" в конец
        polynomial.append(" = 0");

        // Выводим результат
        System.out.println("Generated polynomial: " + polynomial.toString());

        scanner.close();
    }
}

// 1. Импорт необходимых классов:Random:Random:
// Random: Класс из библиотеки Java, используемый для генерации случайных чисел.
// Scanner: Класс из библиотеки Java, используемый для чтения ввода пользователя
// с консоли.

// 2. Определение класса и метода main:
// PolynomialGenerator: Имя класса.
// public static void main(String[] args): Точка входа в программу. Метод main
// запускается при запуске программы.
//
// 3. Создание объектов Scanner и Random:
// scanner: Объект для чтения ввода пользователя с консоли.
// random: Объект для генерации случайных чисел.
//
// 4. Запрос у пользователя степени многочлена:
// System.out.print: Выводит сообщение на консоль без перехода на новую строку.
// int k = scanner.nextInt();: Считывает введенное пользователем целое число и
// сохраняет
// его в переменную k.

// 5. Генерация случайных коэффициентов:
// int[] coefficients = new int[k + 1];: Создает массив длиной k + 1, чтобы
// учесть все
// коэффициенты от степени k до свободного члена.
// Цикл for: Проходит от 0 до k и заполняет массив случайными числами от 0 до
// 100
// включительно.

// 6. Формирование строки многочлена:
// StringBuilder polynomial = new StringBuilder();: Создает объект StringBuilder
// для
// построения строки многочлена.
// Цикл for: Проходит от степени k до 0, добавляя каждый ненулевой коэффициент в
// строку.
// if (coefficient != 0): Проверяет, что коэффициент не равен 0. Если равен,
// пропускает
// его.
// if (polynomial.length() > 0): Если строка многочлена уже содержит члены,
// добавляет " + " перед следующим членом.
// Условия для добавления коэффициентов и степеней:
// Если i == 0, добавляет только коэффициент.
// Если i == 1, добавляет коэффициент и x.
// В остальных случаях добавляет коэффициент и x^i.

// 7. Проверка на случай, если все коэффициенты равны 0:
// Проверяет, если строка многочлена пустая (все коэффициенты равны 0),
// добавляет "0".

// 8. Добавление "= 0" в конец многочлена:
// Добавляет "= 0" в конец строки многочлена.

// 9. Вывод результата:
// Выводит сгенерированный многочлен на консоль.

// 10. Закрытие Scanner:
// Закрывает объект scanner, освобождая ресурсы.