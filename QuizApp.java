import java.util.*;
import java.util.concurrent.*;

public class QuizApp {

    // Simulating a simple user database (username -> password, profile details)
    static Map<String, String> userDatabase = new HashMap<>();
    static Map<String, String> userProfiles = new HashMap<>();
    
    // Timer constants
    static final int TIMER_DURATION = 10; // 10 seconds timer for the quiz

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Add a default user to simulate login
        userDatabase.put("user1", "password123");
        userProfiles.put("user1", "Name: John Doe, Email: johndoe@example.com");
        
        // User login
        System.out.println("Welcome to the Quiz App");
        if (login(scanner)) {
            // User logged in
            boolean loggedIn = true;
            while (loggedIn) {
                System.out.println("\nMenu:");
                System.out.println("1. Update Profile");
                System.out.println("2. Update Password");
                System.out.println("3. Start Quiz");
                System.out.println("4. Logout");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                
                switch (choice) {
                    case 1:
                        updateProfile(scanner);
                        break;
                    case 2:
                        updatePassword(scanner);
                        break;
                    case 3:
                        startQuiz(scanner);
                        break;
                    case 4:
                        loggedIn = false;
                        logout();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid login. Exiting the app.");
        }
        scanner.close();
    }

    // Login functionality
    private static boolean login(Scanner scanner) {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        // Check if the username and password match
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            return false;
        }
    }

    // Update Profile functionality
    private static void updateProfile(Scanner scanner) {
        System.out.print("Enter new profile details (e.g., Name: New Name, Email: newemail@example.com): ");
        String newProfile = scanner.nextLine();
        // Assuming the logged-in user is "user1"
        String username = "user1";
        userProfiles.put(username, newProfile);
        System.out.println("Profile updated successfully!");
    }

    // Update Password functionality
    private static void updatePassword(Scanner scanner) {
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        
        // Assuming the logged-in user is "user1"
        String username = "user1";
        if (userDatabase.get(username).equals(oldPassword)) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            userDatabase.put(username, newPassword);
            System.out.println("Password updated successfully!");
        } else {
            System.out.println("Incorrect old password. Unable to update.");
        }
    }

    // Start Quiz functionality
    private static void startQuiz(Scanner scanner) {
        System.out.println("Starting the quiz... You have " + TIMER_DURATION + " seconds to complete the quiz.");
        
        // Set up the quiz questions and answers
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[]{"Paris", "London", "Rome", "Berlin"}, 0));
        questions.add(new Question("Which programming language is this quiz written in?", new String[]{"Python", "Java", "C++", "JavaScript"}, 1));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1));
        
        // Start timer in a separate thread
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> timerFuture = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(TIMER_DURATION);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Quiz questions with timer
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());
            for (int j = 0; j < question.getOptions().length; j++) {
                System.out.println((j + 1) + ". " + question.getOptions()[j]);
            }
            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt() - 1;
            
            if (answer == question.getCorrectAnswerIndex()) {
                score++;
            }
        }

        // Check if time is up
        try {
            timerFuture.get();
        } catch (Exception e) {
            System.out.println("Quiz timed out automatically!");
        }

        System.out.println("Quiz over! Your score: " + score);
    }

    // Logout functionality
    private static void logout() {
        System.out.println("You have been logged out successfully!");
    }

    // Question class to represent MCQ questions
    static class Question {
        private String question;
        private String[] options;
        private int correctAnswerIndex;

        public Question(String question, String[] options, int correctAnswerIndex) {
            this.question = question;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public int getCorrectAnswerIndex() {
            return correctAnswerIndex;
        }
    }
}
