package commands;

import game.GameState;
import game.Item;

import java.util.Map;

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
        if (state.getCurrentRoom().getRoomItems().get(word2) != null &&  canPick() == true) {
            state.getPlayerInventory().put(word2, state.getCurrentRoom().getRoomItems().get(word2));
            state.getCurrentRoom().removeItem(word2);
            return "You now have this: " + word2 + " " + state.getPlayerInventory().get(word2).getWeight();
        } else return "You can´t take that.";
    }

    public boolean canPick(){
        double maxWeight = 1.0;
        double inventoryWeight = 0;
        if(state.getPlayerInventory().isEmpty()) return true;
        for (Map.Entry<String, Item> entry : state.getPlayerInventory().entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue().getWeight();

            inventoryWeight += value;
        }
        inventoryWeight += state.getCurrentRoom().getRoomItems().get(word2).getWeight();
        System.out.println("Your inventory: " + inventoryWeight + " / " + maxWeight);
        if (inventoryWeight <= maxWeight)return true;
        else return false;
    }

}
