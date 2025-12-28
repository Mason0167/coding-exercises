package src.Lab_3;

// static - you can access the static function/ property directly from the class (belong to the class)
// non-static : belong to an objects  initializing an object of the class
// overloading - Overloading is when you have the same function name but different parameters.
//
// overriding! --> when you're overriding a body of an existing function
// Overriding is when a subclass re-defines a method of the superclass class

// Encapsulation : to make the property(attr) private and access that via a public function
// What is the point of encapsulation?
// What is a base class


//------------------------ UML --------------------------------------
// 1) BankAccount
// 2) accNum, accHolderName, type
// 3) withdraw() deposit()

// constructor is method which instantiate an object for the first time
// Constructor has a same name as the class! you can only use it



public class BankAccount {
    private static int accGenerator = 0;
    // this is belong to the class
    private int accountNumber;
    private String name;
    private float balance;
    private String type;

    public BankAccount(String name, float balance, String type) {
        this.accountNumber = ++accGenerator;
        this.name = name;
        this.balance = balance;
        this.type = type;
    }

    public BankAccount(String name) {
        this.accountNumber = ++accGenerator;
        this.name = name;
        this.balance = 0;
        this.type = "Chequing";
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }
}
