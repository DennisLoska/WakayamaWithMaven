package game;

import java.util.HashMap;

/**
 * Created by Dennis on 11.01.2017.
 */
public class Item {
    private Double weight;
    private String describtion;
    private String name;
    private HashMap<String, Item> itemCollection = new HashMap<String, Item>();
    private Item scroll;
    private Item key;
    private Item apple;
    private Item defaultItem;
    private Item battery;
    private Item food;
    private Item flashlight;
    final double MAXWEIGHT = 1.0;

    public Item() {

    }

    public Item(String describtion) {
        this.describtion = describtion;
    }

    public Item(Double weight, String name, String describtion) {
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


    public double getMAXWEIGHT() {
        return MAXWEIGHT;
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

    public Item getBattery() {
        return battery;
    }

    public void setBattery(Item battery) {
        this.battery = battery;
    }

    public Item getFood() {
        return food;
    }

    public void setFood(Item food) {
        this.food = food;
    }

    public Item getFlashLight() {
        return flashlight;
    }

    public void setFlashLight(Item flashLight) {
        this.flashlight = flashLight;
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
}
