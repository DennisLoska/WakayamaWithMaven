package game;

import java.util.HashMap;

/**
 * Created by Dennis on 11.01.2017.
 */
public class Item {
    private Double weight;
    private String description;
    private String name;
    final static double MAXWEIGHT = 1.0;

    public Item() {

    }

    public Item(String description) {
        this.description = description;
    }

    public Item(Double weight, String name, String description) {
        this.weight = weight;
        this.name = name;
        this.description = description;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public static double getMAXWEIGHT() {
        return MAXWEIGHT;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
