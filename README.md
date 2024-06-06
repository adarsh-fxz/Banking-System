# Basic Banking System

## Part 1 - Basic Banking System

1. Create a class called Customer with two private string variables: firstName and lastName. Implement the following methods:

- getFirstName()
- getLastName()
- setFirstName(String FName)
- setLastName(String LName)

2. Create a class called Account that extends the Customer class. Add the following private integer variables:

- balance
- accountNumber

Implement the following methods:

- Account(String FName, String LName, int balance, int accountNumber) - constructor
- getBalance()
- getAccountNumber()
- deposit(int amount)
- withdraw(int amount)

3. Create a class called Transaction with a method transfer(Account source, Account destination, int amount).

4. In the main method:

- Create an Account object account1 with firstName = "Jeffrey", lastName = "Ting", accountNumber = 1, and balance = 2000.
- Create another Account object account2 with values of your choice.
- Print out the balance of account1 and account2.
- Deposit 250 into account1 and print out the balance.
- Withdraw 500 from account2 and print out the balance.
- Create a Transaction object t and use it to transfer 250 from account1 to account2. Print out the final balances of both accounts.

## Part 2 - Banking System using a CSV File

1. Implement the ReadAccounts class with the following methods:

- ReadAccounts(String URL) - Constructor
- LinkedList< String > getFirstNames()
- LinkedList< String > getLastNames()
- LinkedList< Integer > getAccounts()
- LinkedList< Integer > getBalances()
2. In the main method:

- Create a LinkedList<Account> to store accounts.
- Create an object readAccounts from the ReadAccounts class and read data from Accounts.csv.
- Use the retrieved data to populate the accounts list.
3. Perform the same tests as in Part 1 but with accounts created from the CSV file.

## Part 3 - Integration of a Graphical User Interface (GUI)

1. Implement the GUI class with the following components:

- Buttons for deposit, withdraw, and transfer.
- Text fields for inputting amounts and account details.
- Labels for displaying account information.
- Layout settings for arranging the components.
- Implement the actionPerformed(ActionEvent e) method to handle button clicks and perform the respective operations using the Account and Transaction classes.

2. Modify the main method to:

- Create an instance of the GUI class.
- Set the GUI visibility to true and configure the window settings.
- Ensure all functionalities from Part 1 and Part 2 are accessible via the GUI.

These questions guide the development and testing of the banking system application, incorporating OOP principles, file handling, and GUI integration.

## Usage

### Reading from CSV
1. Ensure the Accounts.csv file is in the project directory.

2. The ReadAccounts class will automatically read from this file to populate account data.

### Using the GUI
1. Run the GUI class to start the graphical user interface.

2. Use the interface to perform banking operations interactively.