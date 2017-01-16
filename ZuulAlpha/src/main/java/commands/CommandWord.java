package commands;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), UNKOWN("unknown"), EAT("eat"), LOOK("look"),
    BACK("back"), TAKE("take"), DROP("drop"), ITEMS("items");

    private String word;

    /**
     * Constructor - initialise the command words.
     */
    private CommandWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    /**
     * Used to create a command from the first word the user typed in.
     *
     * @param word - possible command
     * @return UNKNOWN if given command is not known
     */
    public static CommandWord getForWord(String word) {
        for (CommandWord cw : values()) {
            if (cw.getWord().equals(word))
                return cw;
        }
        return UNKOWN;
    }

    /**
     * Returns List for the showHelp()-method
     *
     * @return - a list of available commands
     */
    public static String getCommandList() {
        String commands = " ";
        for (CommandWord cw : values()) {
            commands = commands + cw.getWord() + " ";
        }
        return commands;
    }

    /**
     * Check whether a given String is a valid command word.
     *
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public static boolean isCommand(String aString) {
        for (CommandWord cw : values()) {
            if (cw.getWord().equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

}
