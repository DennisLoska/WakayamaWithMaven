package game;

import commands.*;

import java.util.Scanner;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class commands.Command.
 * <p>
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Parser {
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() {
        reader = new Scanner(System.in);
    }

    private String readLine() {
        System.out.print("> ");     // print prompt
        return reader.nextLine();
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() {
        String inputLine = readLine();
        return getCommand(inputLine);
    }

    public Command getCommand(String inputLine) {
        String word1 = null;
        String word2 = null;
        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();// get first word
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }
        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        if (word1 == null){
            word1 = " ";
        }
        switch (word1) {
            case "help":
                return new CommandHelp(word1, word2);
            case "go":
                return new CommandGo(word1, word2);
            case "quit":
                return new CommandQuit(word1, word2);
            case "eat":
                return new CommandEat(word1, word2);
            case "look":
                return new CommandLook(word1, word2);
            case "back":
                return new CommandBack(word1, word2);
            default:
                return new CommandUnknown(word1, word2);
        }
    }
}
