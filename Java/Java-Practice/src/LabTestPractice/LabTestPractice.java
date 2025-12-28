package src.LabTest2Practice;

import java.util.Scanner;

public class LabTestPractice {
    static String[] students = new String[5];
    static String[] classes = new String[]{"C#", "Java", "Database"};
    static double[] averages = new double[5];
    static double[] subjectAverages = new double[3];
    static double[][] subjectScores = new double[5][3];


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter the name of student:\n" + (i + 1) + ". ");
            students[i] = input.nextLine();

            for (int j = 0; j < subjectScores[0].length; j++) {
                while (true){
                    System.out.print("Enter " + students[i] + "'s " + classes[j] + " score: ");
                    subjectScores[i][j] = input.nextDouble();
                    input.nextLine();
                    if(subjectScores[i][j] >= 0 && subjectScores[i][j] <= 100){
                        break;
                    }else{
                        System.out.println("Invalid input. Please try again.");
                    }
                }
            }
        }

        for (int i = 0; i < subjectScores[0].length; i++) {
            double score = 0.0;
            for (int j = 0; j < subjectScores.length; j++) {
                 score += subjectScores[j][i];
            }
            subjectAverages[i] = score / subjectScores.length;
        }

        calculateAverage(subjectScores);
        LabTestPractice table = new LabTestPractice();
        System.out.println(table);

        System.out.print("Enter a student name to search: ");
        String name = input.nextLine();
        String result = LabTestPractice.searchStudent(name);
        System.out.println(result);
    }

    public static double[] calculateAverage(double[][] subjectScores){

        for (int i = 0; i < subjectScores.length; i++) {
            double sum = 0;
            for(int j = 0; j < subjectScores[0].length; j++){
                sum += subjectScores[i][j];
            }
            averages[i] = sum / subjectScores[0].length;
        }
        return averages;
    }

    public static String searchStudent(String name){
        String wantedName = "";
        String searchedResult = "";
        int subjectScoresIndex = 0;

        for (int i = 0; i < students.length; i++) {
            if(students[i].trim().equalsIgnoreCase(name.trim())){
                wantedName = students[i];
                subjectScoresIndex = i;
            }
        }
        searchedResult += wantedName + "'s Scores\n";
        for(int i = 0; i < subjectScores[0].length; i++){
            searchedResult += classes[i] + ": " + subjectScores[subjectScoresIndex][i];
            if(subjectScores[subjectScoresIndex][i] > subjectAverages[i]){
                searchedResult += " (Above Class Average)" + "\n";
            }else if(subjectScores[subjectScoresIndex][i] < subjectAverages[i]){
                searchedResult += " (Below Class Average)" + "\n";
            }else{
                searchedResult += " (Same as Class Average)" + "\n";
            }
        }
        return searchedResult;
    }

    @Override
    public String toString() {
        String result = "";
        result += String.format("%-10s %-6s %-7s %-8s %-9s %n", "Name", "C#", "JAVA", "Database", "Averages");
        result += String.format("----------------------------------------------%n");

        for (int i = 0; i < students.length; i++) {
            result += String.format("%-10s", students[i]);
            for (int j = 0; j < subjectScores[0].length; j++) {
                result += String.format("%-8.2f", subjectScores[i][j]);
            }
            result += String.format("%-10.2f %n", averages[i]);
        }
        return result;
    }
}
