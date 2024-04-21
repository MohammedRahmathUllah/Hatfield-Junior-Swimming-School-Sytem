package school;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize a new BookingSystem object
        BookingModel bookingModel = new BookingModel();

        // Add some example data to the system (you would replace this with actual data)
        // Add coaches
        CoachModel coach1 = new CoachModel("Maria");
        CoachModel coach2 = new CoachModel("Aisha");
        CoachModel coach3 = new CoachModel("Katarina");
        bookingModel.addCoach(coach1);
        bookingModel.addCoach(coach2);
        bookingModel.addCoach(coach3);

        // Add lessons for each day of the week and grade level
        String[] days = {"Monday", "Wednesday", "Friday", "Saturday"};
        String[] timesMonToFri = {"4-5pm", "5-6pm", "6-7pm"};
        String[] timesSaturday = {"2-3pm", "3-4pm"};
        for (int grade = 1; grade <= 5; grade++) {
            for (String day : days) {
                String[] times = (day.equals("Saturday")) ? timesSaturday : timesMonToFri;
                for (String time : times) {
                    // Rotate coaches for each lesson for variety
                    CoachModel currentCoach;
                    if (grade % 3 == 1) {
                        currentCoach = coach2;
                    } else if (grade % 3 == 2) {
                        currentCoach = coach3;
                    } else {
                        currentCoach = coach1;
                    }

                    bookingModel.addLesson(new LessonModel(day, time, grade, currentCoach));
                }
            }
        }

        // Add some example learners to the system (you would replace this with actual data)
        String[] learnerNames = {"Zhang", "John", "Kim", "Juan", "Ricardo", "James", "Edward", "Jack", "Thomas", "Alexander", "Olivia", "Luna", "Mason", "Grace", "Lily"};
        String[] genders = {"Female", "Male", "Male", "Female", "Male", "Female", "Male", "Female", "Male", "Female", "Male", "Female", "Male", "Female", "Female"};
        int[] ages = {7, 8, 9, 10, 6, 7, 8, 9, 10, 11, 7, 8, 9, 10, 6};
        String[] emergencyContacts = {"123-456-7890", "234-567-8901", "345-678-9012", "456-789-0123", "567-890-1234", "678-901-2345", "789-012-3456", "890-123-4567", "901-234-5678", "012-345-6789", "123-456-7890", "234-567-8901", "345-678-9012", "456-789-0123", "567-890-1234"};
        int[] grades = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        for (int i = 0; i < learnerNames.length; i++) {
            bookingModel.addLearner(new LearnerModel(learnerNames[i], genders[i], ages[i], emergencyContacts[i], grades[i]));
        }

        // Main menu loop
        while(true) {
            System.out.println("Welcome to the Hatfield Junior Swimming School Booking System");
            System.out.println("1. Book a lesson");
            System.out.println("2. Change or Cancel booking");
            System.out.println("3. Attend a swimming lesson");
            System.out.println("4. Monthly learner report");
            System.out.println("5. Monthly coach report");
            System.out.println("6. Register a new learner");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    // View timetables and book a lesson
                    System.out.println("View Timetables ");
                    System.out.println("By day choose 1 ");
                    System.out.println("By grade choose 2 ");
                    System.out.println("By day choose 3 ");
                    int subCategory = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    switch (subCategory) {
                        case 1:
                            System.out.print("Enter the day (e.g., Monday): ");
                            String day = scanner.nextLine();
                            bookingModel.viewTimetableByDay(day);
                            break;
                        case 2:
                            System.out.print("Enter the grade (1-5): ");
                            int grade = scanner.nextInt();
                            scanner.nextLine(); // consume the newline
                            bookingModel.viewTimetableByGrade(grade);
                            break;
                        case 3:
                            System.out.print("Enter the coach's name: ");
                            String coachName = scanner.nextLine();
                            bookingModel.viewTimetableByCoach(coachName);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    }
                    System.out.print("Enter learner name, day, time, and grade separated by commas (e.g., Alice,Monday,4-5pm,1): ");
                    String[] bookingInfo = scanner.nextLine().split(",");
                    if (bookingInfo.length == 4) {
                        bookingModel.bookLesson(bookingInfo[0].trim(), bookingInfo[1].trim(), bookingInfo[2].trim(), Integer.parseInt(bookingInfo[3].trim()));
                    } else {
                        System.out.println("Invalid input format.");
                    }
                    break;
                case 2:
                    // Change or cancel a booking
                    System.out.println("Change or Cancel Booking ");
                    System.out.println("Change Booking choose 1 ");
                    System.out.println("Cancel Booking choose 2 ");
                    int subCategory2 = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    switch (subCategory2) {
                        case 1:
                        	//change booking
                            System.out.print("Enter learner name, old day, old time, new day, new time, and new grade separated by commas: ");
                            String[] changeInfo = scanner.nextLine().split(",");
                            if (changeInfo.length == 6) {
                                bookingModel.changeBooking(changeInfo[0].trim(), changeInfo[1].trim(), changeInfo[2].trim(), changeInfo[3].trim(), changeInfo[4].trim(), Integer.parseInt(changeInfo[5].trim()));
                            } else {
                                System.out.println("Invalid input format.");
                            }
                            break;
                        case 2:
                        	//cancel booking
                            System.out.print("Enter learner name, day, and time separated by commas (e.g., Alice,Monday,4-5pm): ");
                            String[] cancelInfo = scanner.nextLine().split(",");
                            if (cancelInfo.length == 3) {
                                bookingModel.cancelBooking(cancelInfo[0].trim(), cancelInfo[1].trim(), cancelInfo[2].trim());
                            } else {
                                System.out.println("Invalid input format.");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Please choose a number between 1 and 2");
                    }
                    break;
                case 3:
                    // Attend a swimming lesson
                    System.out.print("Enter learner name, day, and time separated by commas (e.g., Alice,Monday,4-5pm): ");
                    String[] attendanceInfo = scanner.nextLine().split(",");
                    if (attendanceInfo.length == 3) {
                        bookingModel.attendLesson(attendanceInfo[0].trim(), attendanceInfo[1].trim(), attendanceInfo[2].trim());
                    } else {
                        System.out.println("Invalid input format.");
                    }
                    break;
                case 4:
                    // Print monthly learner report
                    bookingModel.printMonthlyLearnerReport();
                    break;
                case 5:
                    // Print monthly coach report
                    bookingModel.printMonthlyCoachReport();
                    break;
                case 6:
                    // Register a new learner
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

                        bookingModel.addLearner(new LearnerModel(name, gender, age, emergencyContact, grade));
                        System.out.println("Registered Learner successfully.");

                        System.out.println("Do you want to add another learner? (yes/no)");
                        String response = scanner.nextLine().toLowerCase();
                        if (!response.equals("yes")) {
                            break;
                        }
                case 7:
                    // Exit the program
                    System.out.println("Exiting....Thank you for using the booking system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
            System.out.println();
        }
    }
}