public class Customer {
    // Instance variables to store the first name and last name of the customer
    private String firstName;
    private String lastName;

    /**
     * Getter method to retrieve the first name of the customer.
     * 
     * @return The first name of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter method to retrieve the last name of the customer.
     * 
     * @return The last name of the customer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method to set the first name of the customer.
     * 
     * @param FName The first name to set.
     */
    public void setFirstName(String FName) {
        this.firstName = FName;
    }

    /**
     * Setter method to set the last name of the customer.
     * 
     * @param LName The last name to set.
     */
    public void setLastName(String LName) {
        this.lastName = LName;
    }
}
