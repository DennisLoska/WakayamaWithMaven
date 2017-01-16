package commands;

/**
 * Created by Dennis on 11.01.2017.
 */
public class CommandHelp extends Command {

    public CommandHelp(String word1, String word2) {
        super(word1, word2);
    }

    public String processCommand(Command command) {
        String result = "";
        result += "You are lost. You are alone. You wander\n";
        result += "around at the university.\n";
        result += "\n";
        result += "Your command words are:\n";
        result += CommandWord.getCommandList();
        return result;
    }
}
