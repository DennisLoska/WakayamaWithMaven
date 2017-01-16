package commands;

import game.GameState;

/**
 * Created by Dennis on 11.01.2017.
 */
public class CommandLook extends Command {
    private GameState state;

    public CommandLook(String word1, String word2) {
        super(word1, word2);
        state = GameState.getInstance();
    }

    public String processCommand(Command command) {
        return state.getCurrentRoom().getItemDescriptions();
    }
}
