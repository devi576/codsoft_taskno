import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctAnswer;

    public QuizQuestion(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizProgram {
    private List<QuizQuestion> quizQuestions;
    private int score;

    public QuizProgram() {
        quizQuestions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(QuizQuestion question) {
        quizQuestions.add(question);
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : quizQuestions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your answer (1-" + options.size() + "): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == question.getCorrectAnswer()) {
                score++;
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + quizQuestions.size());
    }

    public static void main(String[] args) {
        QuizProgram quizProgram = new QuizProgram();

        // Add quiz questions here
        QuizQuestion question1 = new QuizQuestion("What is the capital of France?",
                List.of("London", "Paris", "Berlin", "Madrid"), 2);
        QuizQuestion question2 = new QuizQuestion("Which planet is known as the Red Planet?",
                List.of("Mars", "Venus", "Jupiter", "Saturn"), 1);

        quizProgram.addQuestion(question1);
        quizProgram.addQuestion(question2);

        quizProgram.startQuiz();
    }
}