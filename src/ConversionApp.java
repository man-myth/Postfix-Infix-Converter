import java.io.IOException;
import java.util.Scanner;

public class ConversionApp {
    public static void main(String[] args) throws IOException {
        while (true) {
            try {
                String expression = "";
                int choice;
                ConvertExpression converter = new ConvertExpression();
                System.out.println("Welcome to the Conversion Application! What would you like to do?");
                System.out.println("1. Convert Infix to Postfix");
                System.out.println("2. Convert Postfix to Infix");
                System.out.println("3. Exit");
                choice = Integer.parseInt(userInput(1));
                switch (choice) {
                    case 1 -> {
                        System.out.println("Please input an Infix.");
                        expression = userInput(2);
                        System.out.println(converter.infixToPostfix(expression));
                        pressAnyKeyToContinue();
                    }
                    case 2 -> {
                        System.out.println("Please input an Postfix.");
                        expression = userInput(2);
                        try {
                            System.out.println(converter.postfixToInfix(expression) + " = " + converter.evaluatePostfixExpression(expression));
                        } catch (NumberFormatException e1){
                            String result = converter.postfixToInfix(expression);
                            System.out.println(result);
                        }
                        pressAnyKeyToContinue();
                    }
                    case 3 -> {
                        System.out.println("Closing application...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid input, ensure that you enter a number from 1 to 3.\n");
                }
            } catch (StackException e) {
                System.out.println("The expression should have no spaces.\n");
            }
        }
    }

    public static String userInput(int task) {
        Scanner kbd = new Scanner(System.in);
        int temp = 0;   //to let the block of the loop re-execute

        switch (task) {
            case 1 -> {
                boolean proceed;
                do {
                    try {
                        proceed = false;
                        System.out.print("> ");
                        temp = Integer.parseInt(kbd.nextLine());
                    } catch (NumberFormatException exception) {
                        System.out.println("Invalid input, need to enter a number.\n");
                        proceed = true;
                    }
                } while (proceed);
            }
            case 2 -> {
                System.out.print("> ");
                return kbd.nextLine();
            }
            default -> System.out.println("There is an error.\n");
        }
        return Integer.toString(temp);
    }

    private static void pressAnyKeyToContinue() throws IOException {
        System.out.print("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
