import java.util.Scanner;

public class ExamSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static String[][] mcqs = {
        {"What is the capital of india?", "New Delhi", "Gujarat", "pune", "A"},
        {"Which team has won five world cups?", "Brazil", "Argentina", "USA", "A"},
        {"Who is the founder of Android?", "Steve Jobs", "Andrew E.Rubin", "Elon Musk", "B"},
        {"What is the currency of Australia?", "aud", "Dollar", "Euro", "A"},
        {"What is the name of the first man on the moon?", "Neil Armstrong", "Buzz Aldrin", "Michael Collins", "A"}
    };
    private static String[] answers = new String[mcqs.length];
    private static int sessionDuration = 60 * 1000; // 1 minute in milliseconds
    private static long endTime;

    public static void main(String[] args) {
        System.out.println("Welcome to the exam system");

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Update Profile");
            System.out.println("3. Update Password");
            System.out.println("4. Take Exam");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        updateProfile();
                        break;
                    case 3:
                        updatePassword();
                        break;
                    case 4:
                        takeExam();
                        break;
                    case 5:
                        logout();
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static void login() {
        try {
            System.out.print("\nEnter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            // Add actual authentication logic here

            System.out.println("\nLogin successful.");
        } catch (Exception e) {
            System.out.println("An error occurred during login. Please try again.");
        }
    }

    private static void updateProfile() {
        try {
            System.out.println("\nUpdating profile...");
            
            // Add actual profile update logic here
            
            System.out.println("Profile updated.");
        } catch (Exception e) {
            System.out.println("An error occurred while updating the profile. Please try again.");
        }
    }

    public static void updatePassword() {
        try {
            System.out.print("Enter current password: ");
            String password = sc.nextLine();
            System.out.print("Enter new password: ");
            String newPassword = sc.nextLine();

            if (newPassword.equals(password)) {
                System.out.println("Password cannot be the same as before.");
            } else {
                // Add actual password update logic here
                System.out.println("Password changed successfully.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while updating the password. Please try again.");
        }
    }

    private static void takeExam() {
        try {
            System.out.println("\nStarting exam...");
            endTime = System.currentTimeMillis() + sessionDuration;

            while (System.currentTimeMillis() < endTime) {
                int score = 0;
                for (int i = 0; i < mcqs.length; i++) {
                    String question = mcqs[i][0];
                    String optionA = mcqs[i][1];
                    String optionB = mcqs[i][2];
                    String optionC = mcqs[i][3];
                    String correctOption = mcqs[i][4];

                    System.out.println("\nQuestion " + (i + 1) + ": " + question);
                    System.out.println("A. " + optionA);
                    System.out.println("B. " + optionB);
                    System.out.println("C. " + optionC);
                    System.out.print("Enter your answer: ");
                    answers[i] = sc.nextLine();

                    if (answers[i].equalsIgnoreCase(correctOption)) {
                        score++;
                    }
                }

                System.out.println("\nExam finished.");
                System.out.println("Your score is: " + score + " out of " + mcqs.length);
                logout();
            }

            if (System.currentTimeMillis() >= endTime) {
                System.out.println("Time's up. Your answers will be submitted automatically.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during the exam. Please try again.");
        }
    }

    private static void logout() {
        try {
            System.out.println("\nLogging out...");
            System.out.println("Session closed. Goodbye!");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("An error occurred while logging out. Please try again.");
        }
    }
}