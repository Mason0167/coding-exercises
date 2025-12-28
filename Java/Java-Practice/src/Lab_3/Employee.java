package src.Lab_3;

public class Employee {


    static int generator = 0;
    private int employeeNumber;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.employeeNumber = ++generator;
        this.name = name;
        this.salary = salary;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double computeSalary() {

        return salary/26;

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("employeeNumber=").append(employeeNumber);
        sb.append(", name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
