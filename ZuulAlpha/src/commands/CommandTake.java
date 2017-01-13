package commands;

import game.GameState;
import game.Item;

/**
 * Created by Dennis on 13.01.2017.
 */
public class CommandTake extends Command {

    private GameState state;
    private Item item;

    public CommandTake() {

    }

    public CommandTake(String word1, Item item) {
        super(word1, item);
        this.item=item;
        state = GameState.getInstance();

    }

    @Override
    public String processCommand(Command command) {
        state.getCurrentRoom().removeItem(item.getName());
        return "You now have this: " + item.getDescribtion();
    }

}
