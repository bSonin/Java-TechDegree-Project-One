import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prompter {

    private BufferedReader reader;

    public Prompter() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void displayAdminBanner() {
        System.out.println("===============================");
        System.out.println("Administrator Mode");
        System.out.println("===============================");
    }

    public void displayPlayerBanner() {
        System.out.printf("%n%n%n%n");
        System.out.println("===============================");
        System.out.println("Player Mode");
        System.out.println("===============================");
    }

    public String requestItemName() {
        System.out.printf("What type of item?  ");
        return readStringFromInput();
    }

    public int requestMaxAmount(String name, boolean isPositiveMaxAmount) {
        if (!isPositiveMaxAmount)
        {
            System.out.printf("There must be a positive amount of %s.%n", name);
        }
        System.out.printf("What is the maximum amount of %s?  ", name);
        return readIntFromInput();
    }

    public int requestInitialGuess(String name, int maxAmount) {
        System.out.printf("How many %s are in the jar? Pick a number between 1 and %d:  ", name, maxAmount);
        return readIntFromInput();
    }

    public int requestValidGuess(int maxAmount, boolean isGuessPositive) {
        if (isGuessPositive) {
            System.out.printf("Your guess must be less than %d:  ", maxAmount);
        } else {
            System.out.print("Your guess must be greater than 0:  ");
        }
        return readIntFromInput();
    }

    private int readIntFromInput() {
        int value = -1;
        try {
            value = Integer.parseInt(reader.readLine().trim());
        } catch (Exception e) {
            System.err.println("Error: Game could not parse your input!");
        }
        return value;
    }

    private String readStringFromInput() {
        String string = "";
        try {
            string = reader.readLine().trim();
        } catch (Exception e) {
            System.err.println("Error : Game could not parse your input!");
        }
        return string;
    }

    public void adviseGuess(String hint) {
        System.out.printf("Your guess is too %s%n", hint);
    }

    public void completionMessage(int numberOfTries) {
        String plural = (numberOfTries > 1) ? "s" : "";
        System.out.printf("You got it in %d attempt%s", numberOfTries, plural);
    }
}
