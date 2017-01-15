package game;

import commands.*;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.  Users
 * can walk around some scenery. That's all. It should really be extended
 * to make more interesting!
 * <p>
 * To play this game, create an instance of this class and call the "play"
 * method.
 * <p>
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game.  It also evaluates and
 * executes the commands that the parser returns.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Game {
    private Parser parser;
    private GameState state;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        Item item = new Item();
        item.createItems();
        item.fillCollection();
        Room room = new Room(item);
        GameState.createGameState(room);
        state = GameState.getInstance();
        room.createRooms(state);
        parser = new Parser();

    }




    /**
     * Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            state.setLastOutput(command.processCommand(command));
            finished = (null == state.getLastOutput());
            if (!finished) {
                System.out.println(state.getLastOutput());
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * This is a further method added by BK to
     * provide a clearer interface that can be tested:
     * game.game processes a commandLine and returns output.
     *
     * @param commandLine - the line entered as String
     * @return output of the command
     */
    public String processCommand(String commandLine) {
        Command command = parser.getCommand(commandLine);
        return command.processCommand(command);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + state.getCurrentRoom().getDescription());
        System.out.print("Exits: ");

        String exits = state.getCurrentRoom().getExits();
        System.out.print(exits);
        System.out.println();
    }

    /**
     * starts the application in a loop
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
