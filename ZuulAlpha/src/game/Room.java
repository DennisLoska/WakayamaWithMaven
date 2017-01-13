package game;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class game.Room - a room in an adventure game.
 * <p>
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * A "game.Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north,
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<String, Room>();
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        Item.getInstance().fillCollection();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setExits(String direction, Room exit) {
        this.exits.put(direction, exit);
    }

    /**
     * @return All exits of the room.
     */
    public String getExits() {
        String exit = "";
        for (String key : exits.keySet()) {
            exit += key + ", ";
        }
        //removing the comma at the end
        exit = exit.substring(0, exit.length() - 2);
        return exit;
    }

    public Room getExitsRoom(String key) {
        return exits.get(key);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        if (!(items.size() < 1))
            return description + " There might be an item somewhere around here.";
        else
            return description;
    }

    /**
     *
     * @return
     */
    public String getItemDescriptions() {
        String result = "";
        for (int i = 0; i < items.size(); i++) {
            result += items.get(i).getDescribtion() + "\n";
        }
        return result;
    }

    /**
     *
     * @param key
     */
    public void addItem(String key) {
        items.add(Item.getInstance().getItemCollection().get(key));
    }
}