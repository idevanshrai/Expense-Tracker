import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    double amount;
    String description;

    Expense(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter 'a' to add an expense, 'v' to view total, or 'q' to quit: ");
            String action = scanner.nextLine();

            if (action.equals("a")) {
                addExpense();
            } else if (action.equals("v")) {
                viewTotal();
            } else if (action.equals("q")) {
                break;
            } else {
                System.out.println("Invalid action. Try again.");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter the description: ");
        String description = scanner.nextLine();
        expenses.add(new Expense(amount, description));
        System.out.println("Expense added successfully!");
    }

    private static void viewTotal() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.amount;
        }
        System.out.printf("Total expenses: $%.2f\n", total);
    }
}
