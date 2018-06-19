public class GameController {
    private Jar jar;
    private Prompter prompter;
    private int numberOfTries;

    public GameController() {
        prompter = new Prompter();
        numberOfTries = 0;
        administratorSetup();
    }

    public void administratorSetup() {
        prompter.displayAdminBanner();
        String itemName = prompter.requestItemName();
        int maxAmount = requestPositiveMaxAmount(itemName);
        jar = new Jar(itemName, maxAmount);
    }

    public int requestPositiveMaxAmount(String itemName) {
        int maxAmount = prompter.requestMaxAmount(itemName, true);
        while (maxAmount < 1) {
            maxAmount = prompter.requestMaxAmount(itemName, false);
        }
        return maxAmount;
    }

    public void standardPlay() {
        prompter.displayPlayerBanner();
        int guess = -1;
        while (guess != jar.getAmount()) {
            guess = getGuess();
            adviseNextGuess(guess);
        }
        prompter.completionMessage(numberOfTries);
    }

    private int getGuess() {
        int guess = prompter.requestInitialGuess(jar.getItemName(), jar.getMaxAmount());
        while (!isGuessValid(guess)) {
            guess = prompter.requestValidGuess(jar.getMaxAmount(), guess > 0);
        }
        ++numberOfTries;
        return guess;
    }

    private boolean isGuessValid(int guess) {
        return guess > 0 && guess <= jar.getMaxAmount();
    }

    private void adviseNextGuess(int guess) {
        if (jar.hasFewerThan(guess)) {
            prompter.adviseGuess("high");
        }
        else if (jar.hasMoreThan(guess)) {
            prompter.adviseGuess("low");
        }
    }

}
