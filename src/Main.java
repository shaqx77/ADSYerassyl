import java.util.*;

class BankAccount {
    int id;
    String name;
    double balance;

    BankAccount(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    void display() {
        System.out.println(id + ") " + name + " | Balance: " + balance + " KZT");
    }
}

public class Main {

    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> history = new Stack<>();
    static Queue<String> bills = new LinkedList<>();
    static Queue<BankAccount> requests = new LinkedList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        BankAccount[] initial = {
                new BankAccount(1, "Aruzhan", 700000),
                new BankAccount(2, "Dias", 170000),
                new BankAccount(3, "Nursultan", 150000)
        };

        System.out.println("=== Initial Accounts ===");
        for (BankAccount acc : initial) {
            accounts.add(acc);
            acc.display();
        }

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Bank");
            System.out.println("2. ATM");
            System.out.println("3. Admin");
            System.out.println("4. Exit");

            int choice = getInt();

            switch (choice) {
                case 1 -> bankMenu();
                case 2 -> atmMenu();
                case 3 -> adminMenu();
                case 4 -> System.exit(0);
                default -> System.out.println("Wrong option!");
            }
        }
    }

    static int getInt() {
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Please enter a number!");
        }
        int x = input.nextInt();
        input.nextLine();
        return x;
    }

    static BankAccount findAccount() {
        System.out.print("Enter username: ");
        String name = input.nextLine();

        for (BankAccount acc : accounts) {
            if (acc.name.equalsIgnoreCase(name)) return acc;
        }
        System.out.println("Account not found");
        return null;
    }

    static void showAll() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts yet");
            return;
        }
        for (BankAccount acc : accounts) {
            acc.display();
        }
    }

    static void deposit() {
        BankAccount acc = findAccount();
        if (acc != null) {
            System.out.print("Enter deposit amount: ");
            double money = getInt();
            acc.balance += money;

            history.push(acc.name + " added " + money);
            System.out.println("New balance: " + acc.balance);
        }
    }

    static void withdraw() {
        BankAccount acc = findAccount();
        if (acc != null) {
            System.out.print("Enter withdraw amount: ");
            double money = getInt();

            if (acc.balance >= money) {
                acc.balance -= money;
                history.push(acc.name + " took " + money);
                System.out.println("Transaction completed");
            } else {
                System.out.println("Not enough balance!");
            }
        }
    }

    static void showLast() {
        if (!history.isEmpty())
            System.out.println("Last transaction: " + history.peek());
    }

    static void undo() {
        if (!history.isEmpty()) {
            String last = history.pop();
            System.out.println("Canceled: " + last);
        }
    }

    static void addBill() {
        System.out.print("Enter bill name: ");
        bills.add(input.nextLine());
        System.out.println("Bill added");
    }

    static void processBill() {
        if (!bills.isEmpty())
            System.out.println("Processing: " + bills.poll());
        else
            System.out.println("No bills in queue");
    }

    static void showBills() {
        System.out.println("Bills queue:");
        bills.forEach(System.out::println);
    }

    static void requestAccount() {
        System.out.print("Enter new username: ");
        String name = input.nextLine();
        requests.add(new BankAccount(0, name, 0));
        System.out.println("Request submitted");
    }

    static void processRequest() {
        if (!requests.isEmpty()) {
            BankAccount acc = requests.poll();
            acc.id = accounts.size() + 1;
            accounts.add(acc);
            System.out.println("New account created: " + acc.name);
        } else {
            System.out.println("No pending requests");
        }
    }

    static void bankMenu() {
        System.out.println("1.Request account 2.Deposit 3.Withdraw 4.Show accounts");
        int c = getInt();

        if (c == 1) requestAccount();
        else if (c == 2) deposit();
        else if (c == 3) withdraw();
        else if (c == 4) showAll();
    }

    static void atmMenu() {
        BankAccount acc = findAccount();
        if (acc != null) {
            System.out.println("1.Check balance 2.Withdraw");
            int c = getInt();

            if (c == 1)
                System.out.println("Your balance: " + acc.balance);
            else
                withdraw();
        }
    }

    static void adminMenu() {
        System.out.println("1.Process requests 2.Show bills 3.Add bill 4.Process bill 5.Last 6.Undo");
        int c = getInt();

        switch (c) {
            case 1 -> processRequest();
            case 2 -> showBills();
            case 3 -> addBill();
            case 4 -> processBill();
            case 5 -> showLast();
            case 6 -> undo();
        }
    }
}