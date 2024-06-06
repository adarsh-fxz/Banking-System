public class Account extends Customer {
    
    private int balance; // Balance of the account
    private int accountNumber; // Account number

    /**
     * Constructor to initialize the Account object with provided details.
     * @param FName First name of the account holder.
     * @param LName Last name of the account holder.
     * @param accNum Account number.
     * @param accBal Initial account balance.
     */
    public Account(String FName, String LName, int accNum, int accBal) {
        // Setting first, last name using the parent class methods
        setFirstName(FName);
        setLastName(LName);

        // Setting account number and balance
        this.balance = accBal;
        this.accountNumber = accNum;
    }

    /**
     * Method to get the current balance of the account.
     * @return Current balance.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Method to get the account number.
     * @return Account number.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Method to deposit an amount into the account.
     * @param amount The amount to deposit.
     */
    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Deposit amount must be greater than 0");
        }
    }

    /**
     * Method to withdraw an amount from the account.
     * @param amount The amount to withdraw.
     */
    public void withdraw(int amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Withdrawal amount must be greater than 0 and less than or equal to balance");
        }
    }
}
