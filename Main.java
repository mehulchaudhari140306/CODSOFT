import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSub = sc.nextInt();

        double[] marks = new double[numSub];
        double total = 0;

        for (int i = 0; i < numSub; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextDouble();
            total += marks[i];
        }

        double avgPer = total / numSub;

        String grade;
        if (avgPer >= 90) {
            grade = "A+";
        } else if (avgPer >= 80) {
            grade = "A";
        } else if (avgPer >= 70) {
            grade = "B";
        } else if (avgPer >= 60) {
            grade = "C";
        } else if (avgPer >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + avgPer + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
