package src.Assignment1;

import java.util.ArrayList;

public class GraduateStudent extends Student {
    private String subject;
    private int yearOfEntry;
    private String thesisTopic;

    public GraduateStudent(
            String firstName,
            String lastName,
            ArrayList<Double> stdMarks,
            Address address,
            String subject,
            int yearOfEntry,
            String thesisTopic
    )
    {
        super(firstName, lastName, stdMarks, address);
        this.subject = subject;
        this.yearOfEntry = yearOfEntry;
        this.thesisTopic = thesisTopic;
    }

    public String getSubject() {return subject;}
    public void setSubject(String subject) {this.subject = subject;}

    public int getYearOfEntry() {return yearOfEntry;}
    public void setYearOfEntry(int yearOfEntry) {this.yearOfEntry = yearOfEntry;}

    public String getThesisTopic() {return thesisTopic;}
    public void setThesisTopic(String thesisTopic) {this.thesisTopic = thesisTopic;}

    public boolean Graduate(){
        return Average(getStdMarks()) >= 70;
    }

    @Override
    public String toString() {
        return super.toString() + "Subject: " + subject + "\nEligible to graduate? " + Graduate()
                + "\nYear of Entry: " + yearOfEntry + "\nThesis Topic: " + thesisTopic;
    }
}
