import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.*;

// GUI class to create the graphical user interface
public class GUI extends JFrame {
	// Instace variables
	private Transaction transferObject;
	private StringBuilder sbAllData;
	private LinkedList<Account> globalAccounts;
	private JLabel accNumLabel1, depositAmountLabel, accNumLabel2, withdrawAmountLabel, accNumLabel3, accNumLabel4,
			transferAmountLabel;
	private JTextArea showAllData, history;
	private JButton showAllButton, depositButton, withdrawButton, transferButton;
	private JTextField accDeposit, accWithdraw, acc1Transfer, acc2Transfer, depositInput, withdrawInput, transferAmount;

	// Constructor to initialize the GUI
	public GUI(LinkedList<Account> accounts) {
		super("Banking System");
		setLayout(null); // using absolute layout for manual component positioning
		Font font = new Font("Palatino Linotype", Font.PLAIN, 18);

		// Initializing instance variables
		this.globalAccounts = accounts;
		this.sbAllData = new StringBuilder();
		this.transferObject = new Transaction();

		updateAllData(); // Initial update of account data

		// Creating and setting properties for "Show All" button
		showAllButton = new JButton("Show All");
		showAllButton.setBounds(440, 360, 150, 40);
		showAllButton.setFont(font);
		showAllButton.setToolTipText("Click to show all account data");
		showAllButton.setFocusable(false);
		add(showAllButton);

		// Creating JTextArea to display account data
		showAllData = new JTextArea("Data will be displayed here. Click 'Show All' to view all account data.");
		showAllData.setBounds(40, 40, 550, 300);
		showAllData.setEditable(false);
		showAllData.setLineWrap(true);
		showAllData.setWrapStyleWord(true);
		showAllData.setFont(font);
		showAllData.setMargin(new Insets(10, 10, 10, 10));

		// Creating JScrollPane for JTextArea
		JScrollPane scrollPane = new JScrollPane(showAllData);
		scrollPane.setBounds(40, 40, 550, 300);
		add(scrollPane);

		// Adding labels, text fields, and buttons for deposit, withdrawal, and transfer
		// operations
		// Similar setup for other components...

		accNumLabel1 = new JLabel("Account Number:");
		accNumLabel1.setBounds(40, 450, 200, 40);
		accNumLabel1.setFont(font);
		add(accNumLabel1);

		accDeposit = new JTextField();
		accDeposit.setBounds(220, 450, 170, 40);
		accDeposit.setFont(font);
		accDeposit.setToolTipText("Enter account number");
		add(accDeposit);

		depositAmountLabel = new JLabel("Deposit Amount:");
		depositAmountLabel.setBounds(40, 510, 200, 40);
		depositAmountLabel.setFont(font);
		add(depositAmountLabel);

		depositInput = new JTextField();
		depositInput.setBounds(220, 510, 170, 40);
		depositInput.setFont(font);
		depositInput.setToolTipText("Enter deposit amount");
		add(depositInput);

		depositButton = new JButton("Deposit");
		depositButton.setBounds(220, 570, 170, 40);
		depositButton.setFocusable(false);
		depositButton.setFont(font);
		depositButton.setToolTipText("Click to deposit");
		add(depositButton);

		accNumLabel2 = new JLabel("Account Number:");
		accNumLabel2.setBounds(600, 450, 200, 40);
		accNumLabel2.setFont(font);
		add(accNumLabel2);

		accWithdraw = new JTextField();
		accWithdraw.setBounds(780, 450, 170, 40);
		accWithdraw.setFont(font);
		accWithdraw.setToolTipText("Enter account number");
		add(accWithdraw);

		withdrawAmountLabel = new JLabel("Withdraw Amount:");
		withdrawAmountLabel.setBounds(600, 510, 200, 40);
		withdrawAmountLabel.setFont(font);
		add(withdrawAmountLabel);

		withdrawInput = new JTextField();
		withdrawInput.setBounds(780, 510, 170, 40);
		withdrawInput.setFont(font);
		withdrawInput.setToolTipText("Enter withdrawal amount");
		add(withdrawInput);

		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(780, 570, 170, 40);
		withdrawButton.setFocusable(false);
		withdrawButton.setToolTipText("Click to withdraw");
		withdrawButton.setFont(font);
		add(withdrawButton);

		accNumLabel3 = new JLabel("From Account:");
		accNumLabel3.setBounds(40, 670, 150, 40);
		accNumLabel3.setFont(font);
		add(accNumLabel3);

		acc1Transfer = new JTextField();
		acc1Transfer.setBounds(220, 670, 170, 40);
		acc1Transfer.setFont(font);
		acc1Transfer.setToolTipText("Enter account number to transfer from");
		add(acc1Transfer);

		accNumLabel4 = new JLabel("To Account:");
		accNumLabel4.setBounds(40, 730, 150, 40);
		accNumLabel4.setFont(font);
		add(accNumLabel4);

		acc2Transfer = new JTextField();
		acc2Transfer.setBounds(220, 730, 170, 40);
		acc2Transfer.setFont(font);
		acc2Transfer.setToolTipText("Enter account number to transfer to");
		add(acc2Transfer);

		transferAmountLabel = new JLabel("Transfer Amount:");
		transferAmountLabel.setBounds(40, 790, 200, 40);
		transferAmountLabel.setFont(font);
		add(transferAmountLabel);

		transferAmount = new JTextField();
		transferAmount.setBounds(220, 790, 170, 40);
		transferAmount.setFont(font);
		transferAmount.setToolTipText("Enter transfer amount");
		add(transferAmount);

		transferButton = new JButton("Transfer");
		transferButton.setBounds(220, 850, 170, 40);
		transferButton.setFocusable(false);
		transferButton.setFont(font);
		transferButton.setToolTipText("Click to transfer");
		add(transferButton);

		// JTextArea for runtime transaction history
		history = new JTextArea("Transaction History\n\n");
		history.setBounds(600, 40, 360, 300);
		history.setEditable(false);
		history.setLineWrap(true);
		history.setWrapStyleWord(true);
		history.setFont(font);
		history.setMargin(new Insets(10, 10, 10, 10));

		// Adding JScrollPane for history JTextArea
		JScrollPane historyScrollPane = new JScrollPane(history);
		historyScrollPane.setBounds(600, 40, 360, 300);
		add(historyScrollPane);

		// Adding ActionListener to buttons
		HandlerClass handler = new HandlerClass();
		showAllButton.addActionListener(handler);
		depositButton.addActionListener(handler);
		withdrawButton.addActionListener(handler);
		transferButton.addActionListener(handler);
	}

	// Method to update the display of all account data
	private void updateAllData() {
		sbAllData.setLength(0);
		for (Account acc : globalAccounts) {
			sbAllData.append("First Name: ").append(acc.getFirstName()).append("\n");
			sbAllData.append("Last Name: ").append(acc.getLastName()).append("\n");
			sbAllData.append("Account Number: ").append(acc.getAccountNumber()).append("\n");
			sbAllData.append("Balance: ").append(acc.getBalance()).append("\n\n");
		}
	}

	// Method to update the CSV file with account data
	private void updateCSVfile() {
		try (FileWriter writer = new FileWriter("Accounts.csv")) {
			for (Account acc : globalAccounts) {
				writer.append(acc.getFirstName()).append(",")
						.append(acc.getLastName()).append(",")
						.append(String.valueOf(acc.getAccountNumber())).append(",")
						.append(String.valueOf(acc.getBalance())).append("\n");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error updating CSV file: " + e.getMessage());
		}
	}

	// ActionListener class to handle button clicks
	private class HandlerClass implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// Handling actions for each button
			if (event.getSource() == showAllButton) {
				// Action for "Show All" button
				showAllData.setText(sbAllData.toString()); // Display all account data
			} else if (event.getSource() == depositButton) {
				// Action for "Deposit" button
				try {
					// Parsing input fields
					int accNumber = Integer.parseInt(accDeposit.getText());
					int depositAmount = Integer.parseInt(depositInput.getText());
					boolean accountFound = false;

					// Searching for the account to deposit
					for (Account acc : globalAccounts) {
						if (acc.getAccountNumber() == accNumber) {
							// Validating deposit amount
							if (depositAmount <= 0) {
								JOptionPane.showMessageDialog(null, "Deposit amount must be greater than 0.");
								return;
							}
							// Depositing amount to the account
							acc.deposit(depositAmount);
							accountFound = true;
							history.append("Deposited Rs. " + depositAmount + " to Account " + accNumber + ".\n");
							break;
						}
					}

					// Handling if account not found
					if (!accountFound) {
						JOptionPane.showMessageDialog(null, "Account Number " + accNumber + " not found.");
					} else {
						// Updating data and displaying success message
						updateAllData();
						updateCSVfile();
						showAllData.setText(sbAllData.toString());
						JOptionPane.showMessageDialog(null, "Deposit successful. Rs. " + depositAmount
								+ " has been deposited into Account " + accNumber + ".");
						accDeposit.setText("");
						depositInput.setText("");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");
				}
			} else if (event.getSource() == withdrawButton) {
				// Action for "Withdraw" button
				try {
					// Parsing input fields
					int accNumber = Integer.parseInt(accWithdraw.getText());
					int withdrawAmount = Integer.parseInt(withdrawInput.getText());
					boolean accountFound = false;
					// Searching for the account to withdraw
					for (Account acc : globalAccounts) {
						if (acc.getAccountNumber() == accNumber) {
							// Validating withdrawal amount
							if (withdrawAmount <= 0) {
								JOptionPane.showMessageDialog(null, "Withdrawal amount must be greater than 0.");
								return;
							}
							// Validating sufficient balance
							if (withdrawAmount > acc.getBalance()) {
								JOptionPane.showMessageDialog(null,
										"Insufficient balance in Account " + accNumber + " for this withdrawal.");
								return;
							}
							// Withdrawing amount from the account
							acc.withdraw(withdrawAmount);
							accountFound = true;
							history.append("Withdrawn Rs. " + withdrawAmount + " from Account " + accNumber + ".\n");
							break;
						}
					}

					// Handling if account not found
					if (!accountFound) {
						JOptionPane.showMessageDialog(null, "Account Number " + accNumber + " not found.");
					} else {
						// Updating data and displaying success message
						updateAllData();
						updateCSVfile();
						showAllData.setText(sbAllData.toString());
						JOptionPane.showMessageDialog(null, "Withdrawal successful. Rs. " + withdrawAmount
								+ " has been withdrawn from Account " + accNumber + ".");
						accWithdraw.setText("");
						withdrawInput.setText("");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");
				}
			} else if (event.getSource() == transferButton) {
				// Action for "Transfer" button
				try {
					// Parsing input fields
					int acc1 = Integer.parseInt(acc1Transfer.getText());
					int acc2 = Integer.parseInt(acc2Transfer.getText());
					int transferAmt = Integer.parseInt(transferAmount.getText());
					boolean acc1Found = false;
					boolean acc2Found = false;
					Account account1 = null;
					Account account2 = null;

					// Validating if accounts are different
					if (acc1 == acc2) {
						JOptionPane.showMessageDialog(null, "The accounts must be different.");
						return;
					}

					// Searching for the accounts involved in transfer
					for (Account acc : globalAccounts) {
						if (acc.getAccountNumber() == acc1) {
							account1 = acc;
							acc1Found = true;
						}
						if (acc.getAccountNumber() == acc2) {
							account2 = acc;
							acc2Found = true;
						}
					}

					// Handling if either of the accounts is not found
					if (!acc1Found) {
						JOptionPane.showMessageDialog(null, "Account Number " + acc1 + " not found.");
					} else if (!acc2Found) {
						JOptionPane.showMessageDialog(null, "Account Number " + acc2 + " not found.");
					} else {
						// Validating transfer amount
						if (transferAmt <= 0) {
							JOptionPane.showMessageDialog(null, "Transfer amount must be greater than 0.");
							return;
						}
						// Validating sufficient balance in source account
						if (transferAmt > account1.getBalance()) {
							JOptionPane.showMessageDialog(null,
									"Insufficient balance in Account " + acc1 + " for this transfer.");
							return;
						}
						// Performing the transfer operation
						transferObject.transfer(account1, account2, transferAmt);
						history.append("Transferred Rs. " + transferAmt + " from Account " + acc1 + " to Account "
								+ acc2 + ".\n");
						updateAllData();
						updateCSVfile();
						showAllData.setText(sbAllData.toString());
						JOptionPane.showMessageDialog(null, "Transfer successful. Rs. " + transferAmt
								+ " has been transferred from Account " + acc1 + " to Account " + acc2 + ".");
						acc1Transfer.setText("");
						acc2Transfer.setText("");
						transferAmount.setText("");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");
				}
			}
		}
	}
}
