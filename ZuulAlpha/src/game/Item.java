package game;

import java.util.HashMap;

/**
 * Created by Dennis on 11.01.2017.
 */
public class Item {
    private Double weight;
    private String describtion;
    private String name;
    private boolean canBePickedUp = true;
    private static HashMap<String, Item> itemCollection = new HashMap<String, Item>();
    private static Item item = new Item();
    private static Item scroll = new Item(0.3, "scroll", "There is a scroll.");
    private static Item key = new Item(0.1, "key", "It is some sort of a key.");
    private static Item apple = new Item(0.4, "apple", "It is an apple - it should taste good.");
    private static Item defaultItem = new Item("");
    private static Item battery = new ItemBattery(0.1, "battery", "a battery - can charge a flashlight");
    private static Item food = new ItemFood(0.8, "food", "some food to eat", "deleicous");
    private static Item flashlight = new ItemFlashlight(1.3, "flashlight", "a flashlight to see in the dark", true);

    public Item() {

    }

    private Item(String describtion) {
        this.describtion = describtion;
    }

    private Item(Double weight, String name, String describtion) {
        this.weight = weight;
        this.name = name;
        this.describtion = describtion;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Item> getItemCollection() {
        return itemCollection;
    }

    public Item getDefaultItem() {
        return itemCollection.get("default");
    }

    public static Item getBattery() {
        return battery;
    }

    public static void setBattery(Item battery) {
        Item.battery = battery;
    }

    public static Item getFood() {
        return food;
    }

    public static void setFood(Item food) {
        Item.food = food;
    }

    public static Item getFlashLight() {
        return flashlight;
    }

    public static void setFlashLight(Item flashLight) {
        Item.flashlight = flashLight;
    }

    public boolean isCanBePickedUp() {
        return canBePickedUp;
    }

    public void setCanBePickedUp(boolean canBePickedUp) {
        this.canBePickedUp = canBePickedUp;
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

    public static Item getInstance() {
        return item;
    }
}
