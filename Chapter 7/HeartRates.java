public class HeartRates {
    private String firstName;
    private String lastName;
    private int birthMonth;
    private int birthDay;
    private int birthYear;

    public HeartRates(String firstName, String lastName, int birthMonth, int birthDay, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }

    public void setBirthMonth(int birthMonth) { this.birthMonth = birthMonth; }
    public int getBirthMonth() { return birthMonth; }

    public void setBirthDay(int birthDay) { this.birthDay = birthDay; }
    public int getBirthDay() { return birthDay; }

    public void setBirthYear(int birthYear) { this.birthYear = birthYear; }
    public int getBirthYear() { return birthYear; }

    public int getAge() {
        return 2026 - birthYear;
    }

    public int getMaxHeartRate() {
        return 220 - getAge();
    }

    public String getTargetHeartRate() {
        int max = getMaxHeartRate();
        double lower = max * 0.5;
        double upper = max * 0.85;
        return (int) lower + " - " + (int) upper + " bpm";
    }
}
