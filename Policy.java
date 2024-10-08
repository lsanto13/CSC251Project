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
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    // Method to calculate BMI
    public double calculateBMI() {
        if (heightInInches == 0) {
            return 0; // Avoid division by zero
        }
        return (weightInPounds * 703.0) / (heightInInches * heightInInches);
    }

    // Method to calculate the price of the insurance policy
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