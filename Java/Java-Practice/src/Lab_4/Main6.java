package src.Lab_4;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Object-oriented Databases.(Association of classes, aggregation)
// Inheritance ---> parent class ---> child class

import src.Lab_3.Employee;

interface I1{ int x = 10;}
interface I2{double tax = 0.13;}
interface I3{}

class A implements I1 {
    private int a;

    public A(int a) {
        this.a = a;
    }

    public double getA() {
        return a * x;
    }
    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }
}

class B extends A implements I2, I3 {

    private double b;

    public B(int a, int b ) {
        super(a); // REFER TO SUPER CLASS (PARENT CLASS CONSTRUCTOR)
        this.b = b * I2.tax;
    }

    public double getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "B{" +
                "b=" + b +
                "} " + super.toString();
    }
}



public class Main6 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        A a1 = new A(10);
        A a2 = new A(20);
        B b1 = new B(20, 10);
        B b2 = new B(30, 10);
        //System.out.println(a);
        //System.out.println(b);

        A[] listA = {a1,a2,b1,b2};
        //B[] listB = {b1,b2, a1,a2};

        for (A a : listA) {
            System.out.println(a);
        }

        Employee1 e1 = new Employee1("Adam") ;
        System.out.println(e1);

        SalaryEmployee s1 = new SalaryEmployee("Rob", 45000);
        HourlyEmployee h1 = new HourlyEmployee("Adam", 30, 30);
        System.out.println(s1);
        System.out.println(h1);

        Employee1 [] employees = {s1, h1, e1, new CommissionEmployee("Adam",100000, 1000)};
        SalaryEmployee [] employees1 = {s1, new CommissionEmployee("Adam",100000, 1000)};


        priceChecker(new Book("Adam", "Tony", 1000));
        priceChecker(new Laptop("12","LG","TC", 2300));

    }

    public static void priceChecker(PriceChecker item){
        System.out.println(item.getPrice());
    }

}