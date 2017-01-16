package commands;

import game.GameState;
import game.Room;

/**
 * Created by Dennis on 11.01.2017.
 */
public class CommandGo extends Command {
    private GameState state;

    public CommandGo() {
    }

    public CommandGo(String word1, String word2) {
        super(word1, word2);
        state = GameState.getInstance();
    }

    public String processCommand(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Go where?";
        }
        String direction = command.getSecondWord();
        // Try to leave current room.
        Room next = state.getCurrentRoom().getExitsRoom(direction);
        state.setNextRoom(next);
        Room nextRoom = state.getNextRoom();
        state.setLastRoom(state.getCurrentRoom());
        state.getLastRooomStack().push(state.getCurrentRoom());
        String result = "";
        if (nextRoom == null) {
            result += "There is no door!";
        } else {
            state.setCurrentRoom(nextRoom);
            result += "You are " + nextRoom.getDescription() + "\n";
            result += nextRoom.getExits();
            return result;
        }
        result += "\n";
        return result;
    }
}
