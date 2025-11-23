public class FullTimeEmployee extends Employee {
    private String name;
    private double monthlySalary;

    public FullTimeEmployee() {
        this.name = "Full-Time Mặc Định";
        this.monthlySalary = 10000000;
    }

    public FullTimeEmployee(double monthlySalary) {
        this.name = "Full-Time (Tên Vô Danh)";
        this.monthlySalary = monthlySalary;
    }

    public FullTimeEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    @Override public String getName() { return name; }
    @Override public double calculateSalary() { return monthlySalary; }
}