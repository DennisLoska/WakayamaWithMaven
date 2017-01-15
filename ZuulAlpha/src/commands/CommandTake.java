package commands;

import game.GameState;
import game.Item;

/**
 * Created by Dennis on 13.01.2017.
 */
public class CommandTake extends Command {

    private GameState state;
    private String word2;

    public CommandTake(String word1, String word2) {
        state = GameState.getInstance();
        this.word2 = word2;
    }

    @Override
    public String processCommand(Command command) {
        state.getPlayerInventory().put(word2,state.getCurrentRoom().getRoomItems().get(word2));
        state.getCurrentRoom().removeItem(word2);
        return "You now have this: " + word2;
    }

}
