package commands;

import game.GameState;
import game.Item;

/**
 * Created by Dennis on 13.01.2017.
 */
public class CommandTake extends Command {

    private GameState state;

    public CommandTake() {

    }

    public CommandTake(String word1, String word2) {
        super(word1, word2);
        state = GameState.getInstance();
    }

    @Override
    public String processCommand(Command command) {
        return null;
    }


}
