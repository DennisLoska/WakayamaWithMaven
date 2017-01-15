package commands;

import game.GameState;
import game.Item;

/**
 * Created by Dennis on 13.01.2017.
 */
public class CommandDrop extends Command {

    private GameState state;
    String word2;

    public CommandDrop(String word1, String word2) {
        state = GameState.getInstance();
        this.word2 = word2;
    }

    @Override
    public String processCommand(Command command) {
        state.getCurrentRoom().getRoomItems().put(word2,state.getPlayerInventory().get(word2));
        state.getPlayerInventory().remove(word2);
        return "You dropped: " + word2;
    }

}
