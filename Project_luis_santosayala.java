import java.util.Scanner;
    // Main method for testing
  public class Project_luis_santosayala
  {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Input policy details
        System.out.print("Enter policy number: ");
        String policyNumber = scanner.nextLine();

        System.out.print("Enter provider name: ");
        String providerName = scanner.nextLine();

        System.out.print("Enter policyholder's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter policyholder's last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter policyholder's age: ");
        int age = scanner.nextInt();

        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter policyholder's smoking status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();

        System.out.print("Enter policyholder's height in inches (e.g., 70.5): ");
        double heightInInches = scanner.nextDouble();

        System.out.print("Enter policyholder's weight in pounds (e.g., 180.2): ");
        double weightInPounds = scanner.nextDouble();

        // Create a Policy object with user input
        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, heightInInches, weightInPounds);

        // Display policy details
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

        scanner.close(); // Close the scanner
    }
}