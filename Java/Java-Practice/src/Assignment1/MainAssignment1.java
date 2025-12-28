package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class MainAssignment1 {

    private static Scanner input = new Scanner(System.in);

    static String firstName = "";
    static String lastName = "";
    static ArrayList<Double> marks = new ArrayList<>();

    static String street = "";
    static String city = "";
    static String postalCode = "";
    static String province = "";
    static String country = "";

    static UndergraduateStudent undergraduateStd;
    static ArrayList<UndergraduateStudent> undergraduateStds = new ArrayList<>();

    static GraduateStudent  graduateStd;
    static ArrayList<GraduateStudent> graduateStds = new ArrayList<>();

    static Address address;
    static ArrayList<Address> stdsAddress = new ArrayList<>();

    static String subject = "";
    static int entryYear;
    static String thesisTopic = "";

    public static void main(String[] args) {
        String menu = "\n------------System Menu------------\n"
                        + "1. Add undergraduate student\n"
                        + "2. Add graduate student\n"
                        + "3. View all the students\n"
                        + "4. View only eligible students for graduation\n"
                        + "5. Exit\n"
                        + "Enter your choice, from 1 to 5: ";

        boolean valid = false;

        while(!valid){
            System.out.print(menu);
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n------------Create Under Graduate Students List------------");
                    createStudentsList();

                    undergraduateStd = new UndergraduateStudent(firstName, lastName, new ArrayList<>(marks), address, subject, entryYear);
                    undergraduateStds.add(undergraduateStd);
                    continue;

                case 2:
                    System.out.println("\n------------Create Graduate Students List------------");
                    createStudentsList();

                    System.out.println("Enter this student's thesis topic: ");
                    thesisTopic = input.nextLine();

                    graduateStd = new GraduateStudent(firstName, lastName, new ArrayList<>(marks), address, subject, entryYear, thesisTopic);
                    graduateStds.add(graduateStd);
                    continue;

                case 3:
                    System.out.println("\n------------View all the students------------");
                    if(undergraduateStds.isEmpty() && graduateStds.isEmpty()){
                        System.out.println("Nothing in here.");

                    }else{
                        System.out.println("Viewing under graduate students");
                        for(UndergraduateStudent std : undergraduateStds){
                            System.out.println(std);
                        }

                        System.out.println("\nViewing graduate students");
                        for(GraduateStudent std : graduateStds){
                            System.out.println(std);
                        }
                    }
                    continue;

                case 4:
                    System.out.println("\n-------------View only eligible students for graduation------------");
                    if(undergraduateStds.isEmpty() && graduateStds.isEmpty()){
                        System.out.println("Nothing in here.");
                    }else{
                        for(UndergraduateStudent std : undergraduateStds){
                            if(std.Average(std.getStdMarks()) >= 50){
                                System.out.println(std);
                            }
                        }
                        for(GraduateStudent std : graduateStds){
                            if(std.Average(std.getStdMarks()) >= 70){
                                System.out.println(std);
                            }
                        }
                    }
                    continue;

                case 5:
                    valid = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void createStudentsList(){
        marks.clear();

        System.out.print("Enter student first name: ");
        firstName = input.nextLine();

        System.out.print("Enter student last name: ");
        lastName = input.nextLine();

        System.out.println("Enter student marks (Enter -1 to stop): ");
        while(true){
            double mark = input.nextDouble();
            input.nextLine();
            if(mark == -1){
                System.out.println("Stop Entering.\n");
                break;
            }else if (mark >= 0 || mark <= 100) {
                marks.add(mark);
            }else{
                System.out.println("Invalid marks.");
            }
        }

        System.out.print("Enter student street name: ");
        street = input.nextLine();

        System.out.print("Enter student city name: ");
        city = input.nextLine();

        System.out.print("Enter student postal code: ");
        postalCode = input.nextLine();

        System.out.print("Enter student province: ");
        province = input.nextLine();

        System.out.print("Enter student country: ");
        country = input.nextLine();

        System.out.println("\nFinished.\n");

        address = new Address(street, city, postalCode, province, country);
        stdsAddress.add(address);

        System.out.println("Enter this student's subject: ");
        subject = input.nextLine();

        System.out.println("Enter this student's entry year: ");
        entryYear = input.nextInt();
        input.nextLine();
    }
}
