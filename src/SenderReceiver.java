import java.util.Scanner;
public class SenderReceiver {
    static void sender() {
        System.out.println("Sender:Hi");
    }

    static void receiver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Receiver:Hello");
        System.out.println("Receiver:What do you want?");
    }

    static void operation(String op, double a, double b) {
        switch (op) {
            case "+":
                System.out.println("Result=" + (a + b));
                break;
            case "-":
                System.out.println("Result=" + (a - b));
                break;
            case "*":
                System.out.println("Result=" + (a * b));
                break;
            case "/":
                if (b != 0)
                    System.out.println("Result=" + (a / b));
                else
                    System.out.println("Cannot divide by zero.");
                break;
            default:
                System.out.println("Receiver:Sorry! Invalid operation.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sender();
        receiver();
        String choice;
        do {
            System.out.print("Enter operation(+,-,*,/)");
            String op = sc.next();
            if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                System.out.print("Enter first number:");
                double a = sc.nextDouble();
                System.out.print("Enter second number:");
                double b = sc.nextDouble();
                operation(op, a, b);
            } else {
                operation(op, 0, 0);
            }
            System.out.print("Receiver:Do you want to continue?(yes/no):");
            choice = sc.next();
        }while (choice.equalsIgnoreCase("yes"));
        System.out.println("Receiver:Thank you! Bye.");
        sc.close();
    }
}
