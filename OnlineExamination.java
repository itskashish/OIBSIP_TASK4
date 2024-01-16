import java.util.Scanner;

class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void updateProfile(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
        System.out.println("Profile updated successfully!");
    }
}

class MCQ {
    String question;
    String[] options;
    int correctOption;

    public MCQ(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean checkAnswer(int selectedOption) {
        return selectedOption == correctOption;
    }
}

class Timer {
    int timeLimit;

    public Timer(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean isTimeUp(long startTime) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime >= timeLimit;
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = new User(username, password);

        // Update Profile and Password
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        user.updateProfile(newUsername, newPassword);

        // Selecting answers for MCQs
        MCQ mcq = new MCQ("What is the capital of France?",
                new String[] { "A. Berlin", "B. Paris", "C. London", "D. Madrid" }, 2);

        System.out.println(mcq.question);
        for (String option : mcq.options) {
            System.out.println(option);
        }

        System.out.print("Select your answer (1-4): ");
        int selectedOption = scanner.nextInt();

        if (mcq.checkAnswer(selectedOption)) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer!");
        }

        // Timer and auto submit
        Timer timer = new Timer(60000); // 1 minute timer
        long startTime = System.currentTimeMillis();

        while (!timer.isTimeUp(startTime)) {
            // Do something during the quiz
        }

        System.out.println("Time's up! Auto submitting...");

        // Closing session and Logout
        System.out.println("Closing session and logging out...");

        scanner.close();
    }
}
