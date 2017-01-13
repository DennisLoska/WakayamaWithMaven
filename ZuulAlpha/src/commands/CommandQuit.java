package commands;

/**
 * Created by Dennis on 11.01.2017.
 */
public class CommandQuit extends Command {
    public CommandQuit(String word1, String word2) {
        super(word1, word2);
    }

    public String processCommand(Command command) {
        if (command.hasSecondWord()) {
            return "Quit what?";
        } else {
            return null;  // signal that we want to quit
        }
    }
}
