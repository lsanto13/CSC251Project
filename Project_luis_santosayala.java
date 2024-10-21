import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_luis_santosayala {

    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        
        try {
            // Read from the PolicyInformation.txt file
            File file = new File("PolicyInformation.txt");
            Scanner fileScanner = new Scanner(file);
            
            // Read each line and create Policy objects
            while (fileScanner.hasNextLine()) {
                // Extract data from each line based on the file format
                String policyNumber = fileScanner.nextLine();
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                int age = Integer.parseInt(fileScanner.nextLine());
                String smokingStatus = fileScanner.nextLine();
                double heightInInches = Double.parseDouble(fileScanner.nextLine());
                double weightInPounds = Double.parseDouble(fileScanner.nextLine());

                // Create a Policy object with the extracted data
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, heightInInches, weightInPounds);
                
                // Add the policy object to the ArrayList
                policies.add(policy);
            }
            
            fileScanner.close();

            // Display all policies
            for (Policy policy : policies) {
                System.out.println("\nPolicy Details:");
                System.out.println("Policy Number: " + policy.getPolicyNumber());
                System.out.println("Provider Name: " + policy.getProviderName());
                System.out.println("Policyholder's First Name: " + policy.getFirstName());
                System.out.println("Policyholder's Last Name: " + policy.getLastName());
                System.out.println("Policyholder's Age: " + policy.getAge());
                System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
                System.out.printf("Policyholder's Height (in inches): %.2f\n", policy.getHeightInInches());
                System.out.printf("Policyholder's Weight (in pounds): %.2f\n", policy.getWeightInPounds());
                System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
                System.out.printf("Insurance Policy Price: $%.2f\n", policy.calculatePrice());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt file not found.");
            e.printStackTrace();
        }
    }
}

class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double heightInInches;
    private double weightInPounds;

    // Constructor
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

    // Getters for policy attributes
    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    // Method to calculate BMI
    public double calculateBMI() {
        return (weightInPounds / (heightInInches * heightInInches)) * 703;
    }

    // Method to calculate price (you can define your own logic here)
    public double calculatePrice() {
        double basePrice = 500;  // Example base price
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            basePrice += 200;  // Higher price for smokers
        }
        return basePrice;
    }
}