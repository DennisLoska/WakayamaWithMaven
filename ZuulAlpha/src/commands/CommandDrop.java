package commands;

import game.GameState;
import game.Item;

/**
 * Created by Dennis on 13.01.2017.
 */
public class CommandDrop extends Command {

    private GameState state;
    private Item item;

    public CommandDrop() {

    }

    public CommandDrop(String word1, Item item) {
        this.item=item;
        state = GameState.getInstance();
    }

    @Override
    public String processCommand(Command command) {

        Item.getPlayerInventory().remove(getSecondWord());
        state.getCurrentRoom().addItem(getSecondWord());
        return "You dropped: " + getSecondWord();
    }

}
