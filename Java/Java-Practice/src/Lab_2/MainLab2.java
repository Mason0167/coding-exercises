package src.Lab_2;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainLab2 {
    public static void main(String[] args) {

        //char -> ASCII table
        //=========================================================
        // variable can hold only has one piece of information at the time
        // data collection it has a correlation or relation or dependency with each other.
        // collect 5 marks of a student
        //=============================================================
        // *** DataStructure : a bundle of data,  ---> sequential(Array, ArrayList..) or non-sequential(Set) ---> Mutable , Immutable
        // 1) String : Collection of char in sequence, Immutable

        String name = "Mason Tsai";
        String name2 = new String("Mason Tsai");

        // Array: Collection of same type data in sequence, Mutable (static) it has a fix size
        // Java support C style array declaration
        int [] a = {3,4, 5, 6};
        int b [] = {4, 5, 6, 7};

        // We have 4 numbers and I like to collect them
        // An array needs to be declared and assigned!
        int [] c = new int[4]; // we're holding 4 cells of cells of integer in the memory{0, 0, 0, 0}
        System.out.println(c[1]);
        double [] d =new double[3];
        System.out.println(d[1]);

        // The default value for JAVA arrays are 0
        System.out.println(5/3.0);

        boolean e [] = new boolean[4];
        System.out.println(e[1]);

        char [] f = new char[4];
        System.out.println(f[1]);

        Scanner sc = new Scanner(System.in);

        // Multi=d arrays
        String [] javaContent = {"Quizzes", "Assignment 1", "Assignment 2", "Lab Test 1", "Lab Test 2", "Midterm", "Final"};
        int [][] ListOfStudentMarks = {{45, 56, 78, 89, 87, 65, 82},
                {95, 56, 58, 89, 37, 65, 92},
                {48, 53, 88, 80, 83, 95, 12},
                {85, 56, 78, 89, 87, 65, 82}};

        // I like to collect the marks from the user!
        int [][] ListOfStudentMarks2 = new int[4][7]; // [row][col]
        String [] studentNames = {"Adam", "Max", "Julie", "Jolene"};

        // we collecting 4 students mark
        System.out.println(ListOfStudentMarks2.length);

        for (int i = 0; i < ListOfStudentMarks2.length; i++) {

            System.out.println("Enter Student Mark, " + studentNames[i] + ": ");
            for (int j = 0; j < ListOfStudentMarks2[i].length; j++) {
                System.out.println(javaContent[j] + " :");
                ListOfStudentMarks2[i][j] = sc.nextInt();
            }
        }

        // ---------------------------------------------------------------------------------------------
        // create a table of each student marks and show the avg marks of each content of the class!
        for (int i = 0; i < ListOfStudentMarks2.length; i++) {

            System.out.println("============ " + studentNames[i] + " ===========" );
            for (int j = 0; j < ListOfStudentMarks2[i].length; j++) {

                System.out.println(javaContent[j] + " :" + ListOfStudentMarks2[i][j]);

            }
        }

        float add;
        //--------------------------------------------------------------------------------------------
        for (int j = 0; j < ListOfStudentMarks2[0].length; j++) {
            // picking a column everytime
            add = 0f;
            for (int i = 0; i < ListOfStudentMarks2.length; i++) {
                add += ListOfStudentMarks2[i][j];
            }

            System.out.printf("The average of the %s is %.2f\n", javaContent[j], add/ListOfStudentMarks.length);
        }

        // Jagged Array
        String [][] listOfClasses = {{"Hesam","Tony", "Robert"},
                {"Tony","Adam"},
                {"Tony", "Robert", "Adam", "Clare"}};

        String [][] listOfClasses2 = new String[3][]; // in Java Array Declaration! the first array size must be there!

        for (int i = 0; i < listOfClasses2.length; i++) {
            System.out.println("How many student is in class  #" + (i + 1) + ": ");
            int nStudent = sc.nextInt();
            listOfClasses2[i] = new String[nStudent];

            for (int j = 0; j < listOfClasses2[i].length; j++) {
                System.out.println("Enter student name" +(j + 1)+ " for class #" + (i + 1) + ": ");
                listOfClasses2[i][j] = sc.next();
            }
        }

        // ArrayList ----> collection of same type instance(object) which is dynamic and sequential.
        ArrayList<String> listOfNames = new ArrayList<String>(20);// default size for ArrayList is 15

        System.out.println(listOfNames);
        listOfNames.add("Hesam Akbari");
        listOfNames.add("Tony");
        System.out.println(listOfNames);
        listOfNames.add(1, "Akbari");
        System.out.println(listOfNames);

        // Array of primitive variables ---> Wrapper Classes

        double n = 45;
        double n2 = 56.45;

        ArrayList<Double> numbers = new ArrayList<Double>();
        ArrayList<Integer> numbersInt = new ArrayList<Integer>();

        numbers.add(n);
        numbers.add(n2);
        System.out.println(numbers);
        numbers.add(45.4);
    }
}