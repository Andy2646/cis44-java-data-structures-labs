import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Enter numbers, operators (+, -, *, /, =), or 'exit' to quit.");
        System.out.println("0.0");

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator");
                break;
            }

            if (input.isEmpty()) {
                continue;
            }

            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("=")) {
                calculator.setOperator(input);
                System.out.println(calculator.printDisplay());
            } else {
                try {
                    double number = Double.parseDouble(input);
                    calculator.setNumber(number);
                    System.out.println(calculator.printDisplay());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number, operator, or 'exit'.");
                }
            }
        }
        scanner.close();
    }
}
