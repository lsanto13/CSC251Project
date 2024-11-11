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
            File file = new File("PolicyInformation.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                // Defensive check to ensure the file has enough lines for each policy
                if (!fileScanner.hasNextLine()) break;
                String policyNumber = fileScanner.nextLine();

                if (!fileScanner.hasNextLine()) break;
                String providerName = fileScanner.nextLine();

                if (!fileScanner.hasNextLine()) break;
                String firstName = fileScanner.nextLine();

                if (!fileScanner.hasNextLine()) break;
                String lastName = fileScanner.nextLine();

                // Read age with defensive parsing
                int age = 0;
                if (fileScanner.hasNextLine()) {
                    String ageString = fileScanner.nextLine();
                    try {
                        age = Integer.parseInt(ageString);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid age format for policyholder " + firstName + " " + lastName);
                        continue; // Skip to the next policy if age is invalid
                    }
                }

                if (!fileScanner.hasNextLine()) break;
                String smokingStatus = fileScanner.nextLine();

                // Read height with defensive parsing
                double heightInInches = 0.0;
                if (fileScanner.hasNextLine()) {
                    String heightString = fileScanner.nextLine();
                    try {
                        heightInInches = Double.parseDouble(heightString);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid height format for policyholder " + firstName + " " + lastName);
                        continue; // Skip to the next policy if height is invalid
                    }
                }

                // Read weight with defensive parsing
                double weightInPounds = 0.0;
                if (fileScanner.hasNextLine()) {
                    String weightString = fileScanner.nextLine();
                    try {
                        weightInPounds = Double.parseDouble(weightString);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid weight format for policyholder " + firstName + " " + lastName);
                        continue; // Skip to the next policy if weight is invalid
                    }
                }

                // Create PolicyHolder and Policy objects
                PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, heightInInches, weightInPounds);
                Policy policy = new Policy(policyNumber, providerName, policyHolder);

                policies.add(policy);

                // Count smokers and non-smokers
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }
            fileScanner.close();

            // Display all policies
            for (Policy policy : policies) {
                System.out.println("\n" + policy.toString());
            }

            // Display smoker/non-smoker statistics and total policy count
            System.out.println("\nTotal Policies: " + Policy.getPolicyCount());
            System.out.println("Policies with Smokers: " + smokerCount);
            System.out.println("Policies with Non-Smokers: " + nonSmokerCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt file not found.");
        }
    }
}