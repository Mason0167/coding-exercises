package src.Assignment1;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    static int id = 0;
    private int StudentID;
    private String stdFirstName;
    private String stdLastName;
    private ArrayList<Double> stdMarks;
    private Address stdAddress;

    public Student(String stdFirstName, String stdLastName, ArrayList<Double> stdMarks, Address stdAddress) {
        this.StudentID = ++id;
        this.stdFirstName = stdFirstName;
        this.stdLastName = stdLastName;
        this.stdMarks = stdMarks;
        this.stdAddress = stdAddress;
    }

    public int getStudentID() {return StudentID;}

    public String getStdFirstName() {return stdFirstName;}
    public void setStdFirstName(String stdFirstName) {this.stdFirstName = stdFirstName;}

    public String getStdLastName() {return stdLastName;}
    public void setStdLastName(String stdLastName) {this.stdLastName = stdLastName;}

    public ArrayList<Double> getStdMarks() {return stdMarks;}
    public void setStdMarks(ArrayList<Double> stdMarks) {this.stdMarks = stdMarks;}

    public Address getStdAddress() {return stdAddress;}
    public void setStdAddress(Address stdAddress) {this.stdAddress = stdAddress;}

    public double Average(ArrayList<Double> stdMarks) {
        double stdTotalMark = 0;
        for(double stdMark : stdMarks){
            stdTotalMark += stdMark;
        }
        return stdTotalMark /  stdMarks.size();
    }

    @Override
    public String toString(){
        return "\nStudent ID: " + StudentID + "\nFull Name: " + stdFirstName + " " + stdLastName
                + "\nMarks: " + stdMarks.toString().replace("[", "").replace("]", "")
                + "\nAverage: " + Average(stdMarks) + "\n\n" + stdAddress + "\n\n";
    }
}
