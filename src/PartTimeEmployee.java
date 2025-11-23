public class PartTimeEmployee extends Employee {
    private String name;
    private double hourlySalary;
    private int hoursWorked;

    public PartTimeEmployee(int hoursWorked) {
        this.name = "Part-Time Vô Danh";
        this.hourlySalary = 10000;
        this.hoursWorked = hoursWorked;
    }

    public PartTimeEmployee(double hourlySalary, int hoursWorked) {
        this.name = "Part-Time (Tên Vô Danh)";
        this.hourlySalary = hourlySalary;
        this.hoursWorked = hoursWorked;
    }

    public PartTimeEmployee(String name, double hourlySalary, int hoursWorked) {
        this.name = name;
        this.hourlySalary = hourlySalary;
        this.hoursWorked = hoursWorked;
    }

    @Override public String getName() { return name; }
    @Override public double calculateSalary() { return this.hourlySalary * this.hoursWorked; }
}
