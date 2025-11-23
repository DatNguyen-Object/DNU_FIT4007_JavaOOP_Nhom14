public class Student {
    private String mssv;
    private String name;
    private double gpa;

    public Student(String mssv, String name, double gpa) {
        this.mssv = mssv;
        this.name = name;
        this.gpa = gpa;
    }

    public void printInfo() {
        System.out.println("mssv: " + this.mssv + ", name: " + this.name + ", gpa: " + this.gpa);
    }
}