package src.Lab_3;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainLab3 {
    // Fundamental of data structure in Java
    // - primitive data int, float, boolean, char
    // 1) String : collection of character in sequence
    // 2) Arrays: Collection of same type data in sequence [fixed]
    // 3) ArrayList : Collection of instance(object) data in sequence
    // 2.1) Multi-D Array ---> correlation of multiple list or arrays [Matrix, ragged]
    // 4) Classes: Model of an object (blueprint of an object)

    // What's an object (real-world) --> its a physical entity something tangible, it's a thing!
    // object ---> specific characteristic that all the object shares with each other!
    // 1) Name:
    // 2) Properties (Attr):
    // 3) Functionality (behavior):
    // ==> object doesn't need to be a physical entity in OOP
    // if you use the class as a blueprint of an object its customary to create a dedicate file for it!

    public static void main(String[] args) {
        // TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // primary key is AutoIncremented and Unique

        /*
        BankAccount acc1 = new BankAccount( "hesam");
        BankAccount acc2 = new BankAccount("Tony");
        BankAccount acc3 = new BankAccount("Robert");


        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);

        System.out.println(accounts);
        System.out.println(acc1.toString());
        System.out.println(acc1); // by default call the toString()

        System.out.println("==============================================");
*/
        Employee[][] payroll = new Employee[26][];

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the payroll number you want to pay:");
        int index = input.nextInt();
        System.out.println("Enter the number of employee want to pay on this payroll:");
        int nEmployee = input.nextInt();

        payroll[index] = new Employee[nEmployee];


        for (int i = 0; i < nEmployee; i++) {
            System.out.println("Enter the name and annual salary for employee # " + (i+1) + ":");
            String name = input.next();
            double salary = input.nextDouble();

            payroll[index][i] = new Employee(name, salary);

        }

    }
}