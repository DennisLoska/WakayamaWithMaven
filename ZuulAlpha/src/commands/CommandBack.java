package commands;

import game.GameState;
import game.Room;

/**
 * Created by Dennis on 13.01.2017.
 */
public class CommandBack extends Command {

    private GameState state;

    public CommandBack(String word1, String word2) {
        super(word1, word2);
        state = GameState.getInstance();
    }

    @Override
    public String processCommand(Command command) {
        if (command.getSecondWord() == null) {
            state.setCurrentRoom(((Room)state.getLastRooomStack().pop())); //downcasting from Object to Room
            return "You are now back in " + state.getCurrentRoom().getDescription();
        } else return "Type in 'back' without any more words";
    }
}
