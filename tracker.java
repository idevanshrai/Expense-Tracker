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

public class ExpenseTracker {    //using arraylist to avoid stack data structure 
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter 'a' to add an expense, 'v' to view total and expense details, or 'q' to quit: ");
            String action = scanner.nextLine();

            if (action.equals("a")) {
                addExpense();
            } else if (action.equals("v")) {
                viewTotal();
                viewExpenseDetails();
            } else if (action.equals("q")) {
                break;
            } else {
                System.out.println("Invalid action. Try again.");
            }
        }
    }

    private static void addExpense() {     //adding expenses
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter the description: ");
        String description = scanner.nextLine();
        expenses.add(new Expense(amount, description));
        System.out.println("Expense added successfully!");
    }

    private static void viewTotal() {   //printing total expense
        double total = expenses.stream()
                               .mapToDouble(expense -> expense.amount)
                               .sum();
        System.out.printf("Total expenses: $%.2f\n", total);
    }

    private static void viewExpenseDetails() {  //printing individual expense 
        System.out.println("\nExpense Details:");
        double total = 0;
        for (Expense expense : expenses) {
            System.out.printf("$%.2f - %s\n", expense.amount, expense.description);
            total += expense.amount;
        }
        System.out.printf("\nTotal amount spent: $%.2f\n", total);
    }
}
