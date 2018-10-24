package softserve.academy;

import java.util.Scanner;

public class App {
    private static FibonacciProducer fibonacciProducer = FibonacciProducer.getProducer();
    private static Scanner scanner = new Scanner(System.in);
    private static int input;

    public static void main(String[] args) {
        askForMode();
        if (input == 1) {
            runInRangeSession();
        } else {
            runByLengthSession();
        }
    }

    private static void askForMode() {
        do {
            System.out.println("1 - in a range\n2 - by length");
            String inputStr = scanner.nextLine();
            try {
                input = Integer.parseInt(inputStr);
                if (input == 2 || input == 1) {
                    break;
                } else {
                    System.out.println("Incorrect input!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input!");
            }
        } while (true);
    }

    private static void runByLengthSession() {
        int length = -1;
        do {
            System.out.println("Enter numbers length (min 1 max 9):");
            String lengthStr = scanner.nextLine();
            try {
                length = Integer.parseInt(lengthStr);
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input!");
            }
            if (length > 9) {
                System.out.println("Incorrect input!");
            }
        } while (length <= 0 || length > 9);
        System.out.println(fibonacciProducer.getSequenceByLength(length));
    }

    private static void runInRangeSession() {
        int lower = -1;
        int upper = -1;
        do {
            System.out.println("Enter a lower bound:");
            String lowerStr = scanner.nextLine();
            try {
                lower = Integer.parseInt(lowerStr);
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input!");
            }
        } while (lower < 0);

        do {
            System.out.println("Enter an upper bound (max 2 147 483 647):");
            String upperStr = scanner.nextLine();
            try {
                upper = Integer.parseInt(upperStr);
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input!");
            }
        } while (upper < 0);

        System.out.println(fibonacciProducer.getSequenceInRange(lower, upper));
    }
}