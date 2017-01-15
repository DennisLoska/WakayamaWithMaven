package game;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Dennis on 10.01.2017.
 * This class is an implementation of the singleton design-pattern
 */
public class GameState {
    private String lastOutput;
    private Room room;
    private Room nextRoom;
    private Room currentRoom;
    private Room lastRoom;
    private Stack lastRooomStack = new Stack();
    private static GameState state;
    private HashMap<String, Item> playerInventory = new HashMap<String, Item>();

    private GameState(Room room) {
        this.room = room;
    }

    public HashMap<String, Item> getPlayerInventory() {
        return playerInventory;
    }

    public Stack getLastRooomStack() {
        return lastRooomStack;
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

    public void setLastRoom(Room lastRoom) {
        this.lastRoom = lastRoom;
    }

    public static GameState getInstance() {
        return state;
    }

    public static void createGameState(Room room) {
        if (state == null)
            state = new GameState(room);

    }
}
