public class Policy {
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;
    private static int policyCount = 0;

    // Constructor with parameters
    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        policyCount++; // Increment the counter each time a new policy is created
    }

    // Calculate the price of the policy based on age, smoking status, and BMI
    public double calculatePrice() {
        double baseFee = 600.0;
        double totalFee = baseFee;
        if (policyHolder.getAge() > 50) totalFee += 75.0;
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) totalFee += 100.0;
        double bmi = policyHolder.calculateBMI();
        if (bmi > 35) totalFee += (bmi - 35) * 20.0;
        return totalFee;
    }

    // Getters
    public String getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public static int getPolicyCount() { return policyCount; }

    // toString method to display policy details
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName + 
               "\n" + policyHolder.toString() +
               "\nPolicy Price: $" + String.format("%.2f", calculatePrice());
    }
}