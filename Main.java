import java.util.LinkedList;
import javax.swing.JFrame;

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        String file = "./Accounts.csv"; // path to the csv file containing account details
        LinkedList<Account> accounts = new LinkedList<>(); // LinkedList to store account objects

        // part 1
        // Uncomment the following code to test the basic Banking System using console
        /*
         * Account account1 = new Account("Jeffrey", "Ting", 1, 2000);
         * Account account2 = new Account("Hiran", "Patel", 2, 1000);
         * System.out.println("Account 1 balance: " + account1.getBalance());
         * System.out.println("Account 2 balance: " + account2.getBalance());
         * account1.deposit(250);
         * System.out.println("Account 1 balance after deposit: " +
         * account1.getBalance());
         * account2.withdraw(500);
         * System.out.println("Account 2 balance after withdrawal: " +
         * account2.getBalance());
         * Transaction t = new Transaction();
         * t.transfer(account1, account2, 250);
         * System.out.println("Account 1 balance after transfer: " +
         * account1.getBalance());
         * System.out.println("Account 2 balance after transfer: " +
         * account2.getBalance());
         */

        try {

            // Creating an instance of ReadAccounts to read the CSV file
            ReadAccounts readAccounts = new ReadAccounts(file);

            // Retrieving data from the CSV file
            LinkedList<String> firstNames = readAccounts.getFirstNames();
            LinkedList<String> lastNames = readAccounts.getLastNames();
            LinkedList<Integer> accountList = readAccounts.getAccounts();
            LinkedList<Integer> balanceList = readAccounts.getBalances();

            // Creating Account objects and adding them to the accounts list
            for (int i = 0; i < firstNames.size(); i++) {
                accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
            }

            // part 2
            // Uncomment the following code to print the account details of basic Banking
            // System using console
            /*
             * for (Account acc : accounts) {
             * System.out.println("First Name: " + acc.getFirstName());
             * System.out.println("Last Name: " + acc.getLastName());
             * System.out.println("Account Number: " + acc.getAccountNumber());
             * System.out.println("Balance: " + acc.getBalance());
             * System.out.println();
             * }
             * 
             * // perform deposit and withdrawal operations on the accounts
             * accounts.get(0).deposit(500);
             * System.out.println("Account 1 balance after deposit: " +
             * accounts.get(0).getBalance());
             * accounts.get(1).withdraw(200);
             * System.out.println("Account 2 balance after withdrawal: " +
             * accounts.get(1).getBalance());
             * 
             * // perform transfer operation
             * Transaction transfer = new Transaction();
             * transfer.transfer(accounts.get(0), accounts.get(1), 100);
             * System.out.println("Account 1 balance after transfer: " +
             * accounts.get(0).getBalance());
             * System.out.println("Account 2 balance after transfer: " +
             * accounts.get(1).getBalance());
             */

            // part 3
            // Creating and setting up the GUI
            GUI gui = new GUI(accounts);
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setSize(1000, 1060);
            gui.setVisible(true);

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}