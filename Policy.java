import java.util.Scanner;

public class Policy {
    // Attributes
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double heightInInches; // Height in inches (double for decimals)
    private double weightInPounds; // Weight in pounds (double for decimals)

    // No-arg constructor
    /**
     * Creates a new Policy object with default values.
     */
    public Policy() {
        policyNumber = "";
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        heightInInches = 0.0;
        weightInPounds = 0.0;
    }

    // Constructor with parameters
    /**
     * Creates a new Policy object with specified values.
     *
     * @param policyNumber the unique identifier for the policy
     * @param providerName the name of the insurance provider
     * @param firstName the first name of the policyholder
     * @param lastName the last name of the policyholder
     * @param age the age of the policyholder
     * @param smokingStatus the smoking status of the policyholder ("smoker" or "non-smoker")
     * @param heightInInches the height of the policyholder in inches
     * @param weightInPounds the weight of the policyholder in pounds
     */
    public Policy(String policyNumber, String providerName, String firstName, String lastName, int age, String smokingStatus, double heightInInches, double weightInPounds) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // Getters and Setters

    /**
     * Returns the policy number.
     *
     * @return the policy number as a String
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     *
     * @param policyNumber the new policy number
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Returns the provider name.
     *
     * @return the provider name as a String
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the provider name.
     *
     * @param providerName the new provider name
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Returns the first name of the policyholder.
     *
     * @return the first name as a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the policyholder.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the policyholder.
     *
     * @return the last name as a String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the policyholder.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the age of the policyholder.
     *
     * @return the age as an int
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the policyholder.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the smoking status of the policyholder.
     *
     * @return the smoking status as a String
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Sets the smoking status of the policyholder.
     *
     * @param smokingStatus the new smoking status
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    /**
     * Returns the height of the policyholder in inches.
     *
     * @return the height in inches as a double
     */
    public double getHeightInInches() {
        return heightInInches;
    }

    /**
     * Sets the height of the policyholder in inches.
     *
     * @param heightInInches the new height in inches
     */
    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    /**
     * Returns the weight of the policyholder in pounds.
     *
     * @return the weight in pounds as a double
     */
    public double getWeightInPounds() {
        return weightInPounds;
    }

    /**
     * Sets the weight of the policyholder in pounds.
     *
     * @param weightInPounds the new weight in pounds
     */
    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    // Method to calculate BMI
    /**
     * Calculates the Body Mass Index (BMI) of the policyholder.
     *
     * @return the calculated BMI as a double, or 0 if height is zero
     */
    public double calculateBMI() {
        if (heightInInches == 0) {
            return 0; // Avoid division by zero
        }
        return (weightInPounds * 703.0) / (heightInInches * heightInInches);
    }

    // Method to calculate the price of the insurance policy
    /**
     * Calculates the price of the insurance policy based on various factors.
     *
     * @return the total insurance policy price as a double
     */
    public double calculatePrice() {
        double baseFee = 600.0;
        double totalFee = baseFee;

        // Additional fee for age over 50
        if (age > 50) {
            totalFee += 75.0;
        }

        // Additional fee for smokers
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            totalFee += 100.0;
        }

        // Additional fee for high BMI
        double bmi = calculateBMI();
        if (bmi > 35) {
            totalFee += (bmi - 35) * 20.0;
        }

        return totalFee;
    }
}