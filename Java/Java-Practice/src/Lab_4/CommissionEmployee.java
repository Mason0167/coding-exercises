package src.Lab_4;

public class CommissionEmployee extends SalaryEmployee implements Payrol {

    private double commission;

    public CommissionEmployee(String name, double salary,  double commission) {
        super(name, salary);
        this.commission = commission;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
public double calculatePayrol() {
        return super.calculatePayrol() + commission;
    }

    @Override
    public String toString() {
        return "Commission " + super.toString() +
            "commission=" + commission +
                    "}";
    }
}
