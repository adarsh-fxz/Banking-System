import java.io.*;
import java.util.*;

// ReadAccounts class reads the csv file containing account details
public class ReadAccounts {
    public String url; // path to the csv file containing account details
    BufferedReader reader; // reader object to read the csv file

    // Constructor to initialize the URL/path of the CSV file
    public ReadAccounts(String URL) {
        this.url = URL;
    }

    /**
     * Method to get the first names from the CSV file.
     * 
     * @return LinkedList of first names.
     * @throws IOException if there is an error reading the file.
     */
    public LinkedList<String> getFirstNames() throws IOException {
        LinkedList<String> firstNames = new LinkedList<>();
        reader = new BufferedReader(new FileReader(this.url));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                firstNames.add(values[0]);
            }
        } finally {
            reader.close();
        }
        return firstNames;
    }

    /**
     * Method to get the last names from the CSV file.
     * 
     * @return LinkedList of last names.
     * @throws IOException if there is an error reading the file.
     */
    public LinkedList<String> getLastNames() throws IOException {
        LinkedList<String> lastNames = new LinkedList<>();
        reader = new BufferedReader(new FileReader(this.url));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                lastNames.add(values[1]);
            }
        } finally {
            reader.close();
        }
        return lastNames;
    }

    /**
     * Method to get the account numbers from the CSV file.
     * 
     * @return LinkedList of account numbers.
     * @throws IOException if there is an error reading the file.
     */
    public LinkedList<Integer> getAccounts() throws IOException {
        LinkedList<Integer> accountList = new LinkedList<>();
        reader = new BufferedReader(new FileReader(this.url));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                accountList.add(Integer.parseInt(values[2]));
            }
        } finally {
            reader.close();
        }
        return accountList;
    }

    /**
     * Method to get the account balances from the CSV file.
     * 
     * @return LinkedList of account balances.
     * @throws IOException if there is an error reading the file.
     */
    public LinkedList<Integer> getBalances() throws IOException {
        LinkedList<Integer> balanceList = new LinkedList<>();
        reader = new BufferedReader(new FileReader(this.url));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                balanceList.add(Integer.parseInt(values[3]));
            }
        } finally {
            reader.close();
        }
        return balanceList;
    }
}
