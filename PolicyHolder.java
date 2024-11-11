public class PolicyHolder {
    // Policy holder's personal attributes
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double heightInInches;
    private double weightInPounds;

    // Constructor with parameters
    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // BMI calculation method
    public double calculateBMI() {
        if (heightInInches == 0) return 0;
        return (weightInPounds * 703.0) / (heightInInches * heightInInches);
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeightInInches() { return heightInInches; }
    public double getWeightInPounds() { return weightInPounds; }

    // toString method to display PolicyHolder details
    @Override
    public String toString() {
        return "Policyholder's First Name: " + firstName +
               "\nPolicyholder's Last Name: " + lastName +
               "\nPolicyholder's Age: " + age +
               "\nPolicyholder's Smoking Status (smoker/non-smoker): " + smokingStatus +
               "\nPolicyholder's Height: " + heightInInches + " inches" +
               "\nPolicyholder's Weight: " + weightInPounds + " pounds" +
               "\nPolicyholder's BMI: " + String.format("%.2f", calculateBMI());
    }
}