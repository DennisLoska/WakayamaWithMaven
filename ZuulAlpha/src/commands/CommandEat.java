package commands;

/**
 * Created by Dennis on 11.01.2017.
 */
public class CommandEat extends Command {
    public CommandEat(String word1, String word2) {
        super(word1, word2);
    }

    public String processCommand(Command command) {
        return "You have eaten now and are not hungry any more";
    }
}
