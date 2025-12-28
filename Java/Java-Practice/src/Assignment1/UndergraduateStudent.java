package src.Assignment1;

import java.util.ArrayList;

public class UndergraduateStudent extends Student {
    private String subject;
    private int yearOfEntry;

    public UndergraduateStudent(
            String firstName,
            String lastName,
            ArrayList<Double> stdMarks,
            Address address,
            String subject,
            int yearOfEntry
    )
    {
        super(firstName, lastName, stdMarks, address);
        this.subject = subject;
        this.yearOfEntry = yearOfEntry;
    }

    public String getSubject() {return subject;}
    public void setSubject(String subject) {this.subject = subject;}

    public int getYearOfEntry() {return yearOfEntry;}
    public void setYearOfEntry(int yearOfEntry) {this.yearOfEntry = yearOfEntry;}

    public boolean Graduate(){
        return Average(getStdMarks()) >= 50;
    }

    @Override
    public String toString() {
        return super.toString() + "Subject: " + subject + "\nEligible to graduate? " + Graduate()
                + "\nYear of Entry: " + yearOfEntry;
    }
}
