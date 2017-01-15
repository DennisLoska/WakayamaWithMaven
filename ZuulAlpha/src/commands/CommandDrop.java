package commands;

import game.GameState;
import game.Item;

/**
 * Created by Dennis on 13.01.2017.
 */
public class CommandDrop extends Command {

    private GameState state;
    private Item item;

    public CommandDrop(String word1, Item item) {
        this.item=item;
        state = GameState.getInstance();
    }

    @Override
    public String processCommand(Command command) {
        state.getCurrentRoom().addItem(getSecondWord(),item);
        Item.getPlayerInventory().remove(getSecondWord());
        return "You dropped: " + getSecondWord();
    }

}
