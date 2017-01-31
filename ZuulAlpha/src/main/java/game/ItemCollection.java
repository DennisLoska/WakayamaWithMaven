package game;

import java.util.HashMap;

/**
 * Created by Dennis on 31.01.2017.
 */
public class ItemCollection {

    private Item scroll;
    private Item key;
    private Item apple;
    private Item defaultItem;
    private Item battery;
    private Item food;
    private Item flashlight;

    private final HashMap<String, Item> itemCollection = new HashMap<String, Item>();

    public ItemCollection() {
    }

    public void fillCollection() {
        itemCollection.put("scroll", scroll);
        itemCollection.put("default", defaultItem);
        itemCollection.put("key", key);
        itemCollection.put("apple", apple);
        itemCollection.put("battery", battery);
        itemCollection.put("food", food);
        itemCollection.put("flashlight", flashlight);
    }

    public void createItems() {
        scroll = new Item(0.4, "scroll", "There is a scroll.");
        key = new Item(0.1, "key", "It is some sort of a key.");
        apple = new Item(0.6, "apple", "It is an apple - it should taste good.");
        defaultItem = new Item("");
        battery = new ItemBattery(0.1, "battery", "a battery - can charge a flashlight");
        food = new ItemFood(0.8, "food", "some food to eat", "deleicous");
        flashlight = new ItemFlashlight(1.3, "flashlight", "a flashlight to see in the dark", true);
    }

    public HashMap<String, Item> getItemCollection() {
        return itemCollection;
    }

    public Item getDefaultItem() {
        return itemCollection.get("default");
    }

}
