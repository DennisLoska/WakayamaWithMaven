package commands;

/**
 * Created by Dennis on 11.01.2017.
 */
public class CommandUnknown extends Command {
    public CommandUnknown(String word1, String word2) {
        super(word1, word2);

    }

    public String processCommand(Command command) {
        return "I don't know what you mean...";
    }
}
