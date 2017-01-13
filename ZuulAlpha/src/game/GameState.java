package game;

/**
 * Created by Dennis on 10.01.2017.
 * This class is an implementation of the singleton design-pattern
 */
public class GameState {
    private String lastOutput;
    private Room nextRoom;
    private Room currentRoom;
    private static GameState state = new GameState();

    private GameState() {

    }

    public String getLastOutput() {
        return lastOutput;
    }

    public void setLastOutput(String lastOutput) {
        this.lastOutput = lastOutput;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public static GameState getInstance() {
        return state;
    }
}
