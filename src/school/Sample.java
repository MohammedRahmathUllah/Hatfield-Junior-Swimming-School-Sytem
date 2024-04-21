package school;
import java.util.ArrayList;
import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<LearnerModel> learnersList = new ArrayList<>();

        while (true) {
            System.out.println("Enter learner's name:");
            String name = scanner.nextLine();

            System.out.println("Enter learner's gender:");
            String gender = scanner.nextLine();

            System.out.println("Enter learner's age:");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter learner's emergency contact:");
            String emergencyContact = scanner.nextLine();

            System.out.println("Enter learner's grade:");
            int grade = Integer.parseInt(scanner.nextLine());

            LearnerModel learner = new LearnerModel(name, gender, age, emergencyContact, grade);
            learnersList.add(learner);

            System.out.println("Do you want to add another learner? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                break;
            }
        }

        // Print out the list of learners for verification
        System.out.println("List of learners:");
        for (LearnerModel learner : learnersList) {
            System.out.println("Name: " + learner.getName());
            System.out.println("Gender: " + learner.getGender());
            System.out.println("Age: " + learner.getAge());
            System.out.println("Emergency Contact: " + learner.getEmergencyContact());
            System.out.println("Grade: " + learner.getGrade());
            System.out.println();
        }

        scanner.close();
    }
}
