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
        GameState.createGameState();
        state = GameState.getInstance();
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room templeEntrance, library, toilets, secretRoom, cellarHallway, atelier, bridge,
                forrest, forrestEntrance, closedShops, trainStation, s45, hallway,
                storageRoom, room_a, room_b, room_c;
        // create the rooms
        templeEntrance = new Room("at the temple entrance");
        secretRoom = new Room("at this wall - looks suspicious...");
        library = new Room("in the library");
        toilets = new Room("at the toilets");
        cellarHallway = new Room("in the cellar");
        atelier = new Room("in the atelier");
        bridge = new Room("at an abandoned bridge that looks spooky");
        forrest = new Room("in the forrest");
        forrestEntrance = new Room("at the forrest entrance");
        closedShops = new Room("at some closed shops");
        trainStation = new Room("at the train station");
        s45 = new Room("in the s45");
        hallway = new Room("in a hallway");
        storageRoom = new Room("in the storage room");
        room_a = new Room("in room a");
        room_b = new Room("in room b");
        room_c = new Room("in room c");
        // initialise room exits
        templeEntrance.setExits("east", library);
        templeEntrance.setExits("west", toilets);
        templeEntrance.setExits("south", secretRoom);
        templeEntrance.setExits("north", bridge);
        secretRoom.setExits("north", templeEntrance);
        bridge.setExits("south", templeEntrance);
        bridge.setExits("north", forrest);
        forrest.setExits("south", bridge);
        forrest.setExits("north", forrestEntrance);
        forrestEntrance.setExits("south", forrest);
        forrestEntrance.setExits("east", closedShops);
        forrestEntrance.setExits("north", trainStation);
        closedShops.setExits("west", forrestEntrance);
        trainStation.setExits("south", forrestEntrance);
        trainStation.setExits("north", s45);
        s45.setExits("south", trainStation);
        toilets.setExits("east", templeEntrance);
        toilets.setExits("down", cellarHallway);
        cellarHallway.setExits("up", toilets);
        cellarHallway.setExits("east", atelier);
        atelier.setExits("west", cellarHallway);
        library.setExits("west", templeEntrance);
        library.setExits("up", hallway);
        hallway.setExits("down", library);
        hallway.setExits("east", storageRoom);
        storageRoom.setExits("west", hallway);
        storageRoom.setExits("east", room_a);
        room_a.setExits("north", room_c);
        room_a.setExits("west", storageRoom);
        room_a.setExits("south", room_b);
        room_b.setExits("north", room_a);
        room_c.setExits("south", room_a);
        //adding items
        library.addItem("scroll");
        library.addItem("key");
        library.addItem("apple");
        atelier.addItem("scroll");
        room_c.addItem("scroll");
        //setting initial gamestate
        state.setCurrentRoom(templeEntrance);  // start game inside the temple entrance
        state.setLastRoom(templeEntrance);
        state.getLastRooomStack().push(templeEntrance);
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
