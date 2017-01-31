package commands;

import game.GameState;
import game.Item;

import java.util.Map;

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
        if (state.getPlayerInventory().get(word2) != null) {
            state.getCurrentRoom().getRoomItems().put(word2, state.getPlayerInventory().get(word2));
            state.getPlayerInventory().remove(word2);
            return "You dropped: " + word2;
        } else if (word2.equals("all")) {
            for (Map.Entry<String, Item> entry : state.getPlayerInventory().entrySet()) {
                String key = entry.getKey();
                Item value = entry.getValue();
                state.getCurrentRoom().getRoomItems().put(key, value);
            }
            state.getPlayerInventory().clear();
            return "You dropped all your items.";
        } else return "You don´t have that item.";
    }

}
