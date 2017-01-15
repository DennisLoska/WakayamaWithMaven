package commands;

import game.GameState;
import game.Item;

import java.util.Map;

/**
 * Created by Dennis on 15.01.2017.
 */
public class CommandItems extends Command {

    private GameState state;

    public CommandItems(String word1, String word2) {
        state = GameState.getInstance();
    }

    @Override
    public String processCommand(Command command) {
        String result = "";
        double totalWeight = 0;
        for (Map.Entry<String, Item> entry : state.getPlayerInventory().entrySet()) {
            String key = entry.getKey();
            Item value = entry.getValue();
            result += value.getName() + " weight: " + value.getWeight() + "\n" ;
            totalWeight += value.getWeight();
        }
        return result += " total weight: " + totalWeight + " / " + state.getCurrentRoom().getItem().getMAXWEIGHT();
    }
}
