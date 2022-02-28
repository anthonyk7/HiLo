package game;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named(value = "gameBean")
@SessionScoped
public class GameBean implements Serializable {

    // Game Attribute
    private int usersAnswer;
    private int secretNumber; // gives a random number between 1 - 10
    private Integer amountOfTries = 1;
    private String displayMessage;
    private String hint;


    public GameBean() {
        this.secretNumber = 1 + (int) (100 * Math.random());
    }

    public int getUsersAnswer() {
        return usersAnswer;
    }

    public void setUsersAnswer(int usersAnswer) {
        this.usersAnswer = usersAnswer;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(Integer secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int getAmountOfTries() {
        return amountOfTries;
    }

    public void setAmountOfTries(Integer amountOfTries) {
        this.amountOfTries = amountOfTries;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }


    /** method that runs the game */
    public String play() {
        if (usersAnswer == secretNumber) {
            displayMessage = usersAnswer + " is the secret number you won!";
            return "index";
        } else if (usersAnswer > secretNumber) {
            amountOfTries++;
            displayMessage = usersAnswer + "  is inncorrect! guess again";
            hint = "try a lower number";
            return "index";
        } else if (usersAnswer < secretNumber) {
            amountOfTries++;
            displayMessage = usersAnswer + "  is an inncorrect answer! guess again";
            hint = "try a higher number";
            return "index";
        } else {
            amountOfTries++;
            displayMessage = usersAnswer + "  is inncorrect! guess again";
            return "index";
        }
    }

    /** restarts and starts a new game */
    public String restart() {
        amountOfTries = 1;
        displayMessage = "";
        hint = "";
        this.secretNumber = +(int) (100 * Math.random());
        return "index";
    }
}