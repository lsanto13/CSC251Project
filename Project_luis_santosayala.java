import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_luis_santosayala {

    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            // Read from the PolicyInformation.txt file
            File file = new File("PolicyInformation.txt");
            Scanner fileScanner = new Scanner(file);

            // Read each line and create Policy objects
            while (fileScanner.hasNextLine()) {
                // Defensive check to make sure file has enough lines for each policy
                if (!fileScanner.hasNextLine()) break;
                String policyNumber = fileScanner.nextLine();

                if (!fileScanner.hasNextLine()) break;
                String providerName = fileScanner.nextLine();

                if (!fileScanner.hasNextLine()) break;
                String firstName = fileScanner.nextLine();

                if (!fileScanner.hasNextLine()) break;
                String lastName = fileScanner.nextLine();

                if (!fileScanner.hasNextLine()) break;
                String ageString = fileScanner.nextLine();
                int age = 0;
                try {
                    age = Integer.parseInt(ageString);  // Attempt to parse age as an integer
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing age for policyholder " + firstName + " " + lastName);
                    continue;  // Skip to the next policy if there's an error
                }

                if (!fileScanner.hasNextLine()) break;
                String smokingStatus = fileScanner.nextLine();

                if (!fileScanner.hasNextLine()) break;
                String heightString = fileScanner.nextLine();
                double heightInInches = 0.0;
                try {
                    heightInInches = Double.parseDouble(heightString);  // Attempt to parse height as a double
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing height for policyholder " + firstName + " " + lastName);
                    continue;  // Skip to the next policy if there's an error
                }

                if (!fileScanner.hasNextLine()) break;
                String weightString = fileScanner.nextLine();
                double weightInPounds = 0.0;
                try {
                    weightInPounds = Double.parseDouble(weightString);  // Attempt to parse weight as a double
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing weight for policyholder " + firstName + " " + lastName);
                    continue;  // Skip to the next policy if there's an error
                }

                // Create a Policy object with the extracted data
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, heightInInches, weightInPounds);

                // Add the policy object to the ArrayList
                policies.add(policy);

                // Increment smoker/non-smoker counters
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
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
                System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
                System.out.printf("Policyholder's Height: %.1f inches\n", policy.getHeightInInches());
                System.out.printf("Policyholder's Weight: %.1f pounds\n", policy.getWeightInPounds());
                System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
                System.out.printf("Policy Price: $%.2f\n", policy.calculatePrice());
            }

            // Display smoker/non-smoker statistics
            System.out.println("\nThe number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt file not found.");
            e.printStackTrace();
        }
    }
}
