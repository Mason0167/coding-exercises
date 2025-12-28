package src.Lab_4;

public class HourlyEmployee extends Employee1 implements Payrol {

    private int hour;
    private double rate;

    public HourlyEmployee(String name, int hour, double rate) {
        super(name);
        this.hour = hour;
        this.rate = rate;

    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculatePayrol() {
        return hour * rate;
    }

    @Override
    public String toString() {
        return " Hourly " + super.toString() +
                "hours= " + hour + ", rate = " + rate;
    }
}
