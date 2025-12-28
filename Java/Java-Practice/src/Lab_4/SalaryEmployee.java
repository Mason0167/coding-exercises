package src.Lab_4;

public class SalaryEmployee extends Employee1 implements Payrol {

    private double salary; // Annual Salary...
    public SalaryEmployee(String name, double salary) {
        super(name);
        this.salary = salary;

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculatePayrol() {
        return salary/26;
    }

    @Override
    public String toString() {
        return "Salary " + super.toString() +
                ", Salary=" + salary;
    }
}
