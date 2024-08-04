// Даны два файла, в каждом из которых находится записьmмногочлена. Сформировать
// файл, содержащий сумму многочленов.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialSum {
    public static void main(String[] args) {
        try {
            // Считываем содержимое файлов poly1.txt и poly2.txt в строки poly1 и poly2
            String poly1 = new String(Files.readAllBytes(Paths.get("poly1.txt")));
            String poly2 = new String(Files.readAllBytes(Paths.get("poly2.txt")));

            // Парсим строки многочленов в массивы коэффициентов
            int[] coefficients1 = parsePolynomial(poly1);
            int[] coefficients2 = parsePolynomial(poly2);

            // Определяем максимальную степень между двумя многочленами
            int maxDegree = Math.max(coefficients1.length, coefficients2.length);
            // Создаем массив для хранения коэффициентов результирующего многочлена
            int[] resultCoefficients = new int[maxDegree];

            // Складываем соответствующие коэффициенты двух многочленов
            for (int i = 0; i < maxDegree; i++) {
                int coef1 = i < coefficients1.length ? coefficients1[i] : 0;
                int coef2 = i < coefficients2.length ? coefficients2[i] : 0;
                resultCoefficients[i] = coef1 + coef2;
            }

            // Формируем строку результирующего многочлена
            String resultPolynomial = buildPolynomialString(resultCoefficients);
            // Записываем результирующий многочлен в файл result.txt
            writeToFile(resultPolynomial, "result.txt");

            // Выводим результирующий многочлен на консоль
            System.out.println("Resultant polynomial: " + resultPolynomial);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для парсинга многочлена из строки в массив коэффициентов
    private static int[] parsePolynomial(String poly) {
        // Разбиваем строку многочлена на отдельные члены
        String[] terms = poly.split(" \\+ ");
        int maxDegree = 0;
        Pattern pattern = Pattern.compile("x\\^(\\d+)");

        // Определяем максимальную степень многочлена
        for (String term : terms) {
            Matcher matcher = pattern.matcher(term);
            if (matcher.find()) {
                int degree = Integer.parseInt(matcher.group(1));
                if (degree > maxDegree) {
                    maxDegree = degree;
                }
            } else if (term.contains("x")) {
                if (maxDegree < 1) {
                    maxDegree = 1;
                }
            }
        }

        // Инициализируем массив коэффициентов
        int[] coefficients = new int[maxDegree + 1];

        // Заполняем массив коэффициентов на основе членов многочлена
        for (String term : terms) {
            int coefficient;
            int degree;
            if (term.contains("x^")) {
                String[] parts = term.split("\\*x\\^");
                coefficient = Integer.parseInt(parts[0]);
                degree = Integer.parseInt(parts[1]);
            } else if (term.contains("x")) {
                String[] parts = term.split("\\*x");
                coefficient = Integer.parseInt(parts[0]);
                degree = 1;
            } else {
                coefficient = Integer.parseInt(term);
                degree = 0;
            }
            coefficients[degree] = coefficient;
        }

        return coefficients;
    }

    // Метод для формирования строки многочлена из массива коэффициентов
    private static String buildPolynomialString(int[] coefficients) {
        StringBuilder polynomial = new StringBuilder();
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (polynomial.length() > 0) {
                    polynomial.append(" + ");
                }
                if (i == 0) {
                    polynomial.append(coefficients[i]);
                } else if (i == 1) {
                    polynomial.append(coefficients[i]).append("*x");
                } else {
                    polynomial.append(coefficients[i]).append("*x^").append(i);
                }
            }
        }
        return polynomial.toString();
    }

    // Метод для записи данных в файл
    private static void writeToFile(String data, String fileName) throws IOException {
        FileWriter writer = new FileWriter(new File(fileName));
        writer.write(data);
        writer.close();
    }
}

// 1. Чтение файлов:
// Считываем содержимое файлов poly1.txt и poly2.txt в строки poly1 и poly2.

// 2. Парсинг многочленов:
// Вызываем метод parsePolynomial, который преобразует строковое представление
// многочлена
// в массив его коэффициентов.

// 3. Сложение коэффициентов:
// Определяем максимальную степень между двумя многочленами.
// Создаем массив resultCoefficients для хранения коэффициентов результирующего
// многочлена.
// Складываем соответствующие коэффициенты двух многочленов.

// 4. Формирование строки результирующего многочлена:
// Вызываем метод buildPolynomialString, который преобразует массив
// коэффициентов в
// строковое представление многочлена.

// 5. Запись результирующего многочлена в файл:
// Вызываем метод writeToFile, который записывает строку результирующего
// многочлена в
// файл result.txt.

// Парсинг многочлена:

// Метод parsePolynomial преобразует строковое представление многочлена в массив
// его
// коэффициентов.
// Разбивает строку на отдельные члены.
// Определяет максимальную степень.
// Инициализирует массив коэффициентов.
// Заполняет массив коэффициентов на основе членов многочлена.
// Формирование строки многочлена:

// Метод buildPolynomialString преобразует массив коэффициентов в строковое
// представление многочлена.
// Проходит по массиву коэффициентов от старших степеней к младшим.
// Формирует строку многочлена, добавляя соответствующие степени и коэффициенты.
// Запись в файл:

// Метод writeToFile записывает данные в файл.

// Теперь, запустив этот код, вы сможете прочитать два файла с многочленами,
// сложить их
// и записать результат в новый файл. Убедитесь, что файлы poly1.txt и poly2.txt
// находятся в рабочем каталоге программы.