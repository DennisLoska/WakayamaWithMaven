package game;

import java.util.HashMap;

/**
 * Created by Dennis on 11.01.2017.
 */
public class Item {
    private Double weight;
    private String describtion;
    private String name;
    private static HashMap<String, Item> itemCollection = new HashMap<String, Item>();
    private static Item item = new Item();
    private static Item scroll = new Item(0.3, "scroll", "There is a scroll.");
    private static Item key = new Item(0.1, "key", "It is some sort of a key.");
    private static Item apple = new Item(0.4, "apple", "It is an apple - it should taste good.");
    private static Item defaultItem = new Item("");

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

    public void fillCollection() {
        itemCollection.put("scroll", scroll);
        itemCollection.put("default", defaultItem);
        itemCollection.put("key", key);
        itemCollection.put("apple", apple);
    }

    public static Item getInstance() {
        return item;
    }
}
