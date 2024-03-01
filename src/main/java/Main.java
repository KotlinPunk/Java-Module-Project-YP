import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = 0; // хранит ответ пользователя

        while (true) {

            try {
                numberOfPeople = scanner.nextInt();
            } catch (InputMismatchException q) {
                System.out.println("Введено не целое число.");
            } finally {
                scanner.nextLine();
            }

            if (numberOfPeople == 1) {

                System.out.println("В этом случае нет смысла ничего считать и делить.");

            } else if (numberOfPeople < 1) {

                System.out.println("Некорректное значение для подсчёта.");

            } else if (numberOfPeople > 1) {

                String s = Calculator.calculator(numberOfPeople);

                System.out.println("Каждый заплатит: " + s + ".");
            }
        }
    }
}

