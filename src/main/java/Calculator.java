import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {

    public static String calculator(int N) {

        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        double sum = 0;

        while (true) {

            System.out.println("Пожалуйста, введти название товара: ");
            String productName = prod(scanner);

            System.out.println("Пожалуйста, укажите в формате 'рубли,копейки' стоимость товара: ");
            double priceProduct = prPr(scanner);
            sum += priceProduct;

            products.add(new Product(productName, priceProduct));
            System.out.println("Товар успешно добавлен");

            System.out.println("Будут ли ещё товары? Если нет, пожалуйста, введите 'Завершить'.");
            String z = scanner.next();


            if(z.equalsIgnoreCase("Завершить")) {

                for (int i = 0; i < products.size(); i++) {
                    Product product = products.get(i);
                    System.out.println("Товар: " + product.productName + ", стоимость товара: " + product.priceProduct + ".");
                }

                double midSum = sum/N;

                String form = String.format("%.2f", midSum);
                String f = rub(midSum);
                return form + f; // возвращаем средний чек на человека
            }
        }
    }

    public static String prod (Scanner scanner) {
        while (true) {
            try {
                String productName = scanner.next();
                return productName;
            } catch (InputMismatchException q) {
                System.out.println("Введено некорректно название товара.");
            } finally {
                scanner.nextLine();
            }
        }
    }
    public static double prPr (Scanner scanner) {
        while (true) {
            try {
                double prPr = scanner.nextDouble();
                if (prPr <= 0) {
                    System.out.println("Введена отрицательная или нулевая стоимость товара. Повторите ввод, пожалуйста.");
                } else {
                return prPr;
                }
            } catch (InputMismatchException q) {
                System.out.println("Введена некорректная стоимость товара.");
            } finally {
                scanner.nextLine();
            }
        }
    }
    public static String rub(double midSum) {
        double v = Math.floor(midSum);
        if (v % 100 >= 11 && v % 100 <=14) {
            return " рублей";
        } else if (v % 10 == 1) {
            return " рубль";
        } else if (v % 10 == 2 || v % 10 == 3 || v % 10 == 4) {
            return " рубля";
        }else {
            return " рублей";
        }
    }
}


