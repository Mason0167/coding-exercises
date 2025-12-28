package src.Lab_4;

public class Employee1 {

    private static int idGenerator = 0;
    private int id;
    private String name;

    public Employee1(String name) {
        this.name = name;
        id = ++idGenerator;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    // Abstract method! a method that has a heading yet
    // no body! ( its incomplete and it has to be completed
    // later!)


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
