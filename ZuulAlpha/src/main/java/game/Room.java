package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private HashMap<String, Item> roomItems = new HashMap<String, Item>();
    private ItemCollection item;

    public Room() {
    }

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    public void createRooms(GameState state) {
        Room templeEntrance, library, toilets, secretRoom, cellarHallway, atelier, bridge,
                forrest, forrestEntrance, closedShops, trainStation, s45, hallway,
                storageRoom, room_a, room_b, room_c;
        // create the rooms
        templeEntrance = new Room("at the temple entrance");
        secretRoom = new Room("at this wall - looks suspicious...");
        library = new Room("in the library");
        toilets = new Room("at the toilets");
        cellarHallway = new Room("in the cellar");
        atelier = new Room("in the atelier");
        bridge = new Room("at an abandoned bridge that looks spooky");
        forrest = new Room("in the forrest");
        forrestEntrance = new Room("at the forrest entrance");
        closedShops = new Room("at some closed shops");
        trainStation = new Room("at the train station");
        s45 = new Room("in the s45");
        hallway = new Room("in a hallway");
        storageRoom = new Room("in the storage room");
        room_a = new Room("in room a");
        room_b = new Room("in room b");
        room_c = new Room("in room c");
        // initialise room exits
        templeEntrance.setExits("east", library);
        templeEntrance.setExits("west", toilets);
        templeEntrance.setExits("south", secretRoom);
        templeEntrance.setExits("north", bridge);
        secretRoom.setExits("north", templeEntrance);
        bridge.setExits("south", templeEntrance);
        bridge.setExits("north", forrest);
        forrest.setExits("south", bridge);
        forrest.setExits("north", forrestEntrance);
        forrestEntrance.setExits("south", forrest);
        forrestEntrance.setExits("east", closedShops);
        forrestEntrance.setExits("north", trainStation);
        closedShops.setExits("west", forrestEntrance);
        trainStation.setExits("south", forrestEntrance);
        trainStation.setExits("north", s45);
        s45.setExits("south", trainStation);
        toilets.setExits("east", templeEntrance);
        toilets.setExits("down", cellarHallway);
        cellarHallway.setExits("up", toilets);
        cellarHallway.setExits("east", atelier);
        atelier.setExits("west", cellarHallway);
        library.setExits("west", templeEntrance);
        library.setExits("up", hallway);
        hallway.setExits("down", library);
        hallway.setExits("east", storageRoom);
        storageRoom.setExits("west", hallway);
        storageRoom.setExits("east", room_a);
        room_a.setExits("north", room_c);
        room_a.setExits("west", storageRoom);
        room_a.setExits("south", room_b);
        room_b.setExits("north", room_a);
        room_c.setExits("south", room_a);
        //adding items
        item = new ItemCollection();
        item.createItems();
        item.fillCollection();
        library.addItem("scroll", item);
        library.addItem("key", item);
        library.addItem("apple", item);
        atelier.addItem("scroll", item);
        room_c.addItem("scroll", item);

        //setting initial gamestate
        state.setCurrentRoom(templeEntrance);  // start game inside the temple entrance
        state.setLastRoom(templeEntrance);
        state.getLastRooomStack().push(templeEntrance);
    }

    public HashMap<String, Item> getRoomItems() {
        return roomItems;
    }

    public void setRoomItems(HashMap<String, Item> roomItems) {
        roomItems = roomItems;
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
        if (!(roomItems.size() < 1))
            return description + " There might be an item somewhere around here.";
        else
            return description;
    }

    /**
     * @return
     */
    public String getItemDescriptions() {
        String result = "";
        for (Map.Entry<String, Item> entry : roomItems.entrySet()) {
            String key = entry.getKey();
            Item value = entry.getValue();

            result += value.getDescription() + "\n";
        }
        return result;
    }

    public ItemCollection getItem() {
        return item;
    }

    /**
     * @param key
     */
    public void addItem(String key, ItemCollection item) {
        roomItems.put(key, item.getItemCollection().get(key));
    }

    public void addItem(String key, Item item) {
        roomItems.put(key, item);
    }

    public void removeItem(String key) {
        roomItems.remove(key);
    }

}