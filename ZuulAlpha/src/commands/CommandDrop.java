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
        state.getCurrentRoom().removeItem(item.getName());
        Item.getPlayerInventory().put(item.getName(),item);
        System.out.println(Item.getPlayerInventory().isEmpty());
        return "You now have this: " + item.getDescribtion();
    }

}