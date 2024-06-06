public class Transaction {
    /**
     * Transfers a specified amount from one account to another.
     * 
     * @param acc1 The account from which the amount will be withdrawn.
     * @param acc2 The account to which the amount will be deposited.
     * @param amount The amount of money to be transferred.
     */
    public void transfer(Account acc1, Account acc2, int amount) {
        if (amount > 0 && amount <= acc1.getBalance()) {
            acc1.withdraw(amount);
            acc2.deposit(amount);
        } else {
            System.out.println("Transfer amount must be greater than 0 and less than or equal to balance");
        }
    }
}
