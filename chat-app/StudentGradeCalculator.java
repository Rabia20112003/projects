import java.util.Scanner;

public class StudentGradeCalculator 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) 
        {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        double average = (double) totalMarks / numSubjects;
        char grade = calculateGrade(average);

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
    }

    public static char calculateGrade(double average) 
    {
        if (average >= 90) 
        {
            return 'A';
        } 
        else if (average >= 80) 
        {
            return 'B';
        } 
        else if (average >= 70) 
        {
            return 'C';
        } 
        else if (average >= 60) 
        {
            return 'D';
        } 
        else 
        {
            return 'F';
        }
    }
}
