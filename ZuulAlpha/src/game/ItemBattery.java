package game;

/**
 * Created by Dennis on 13.01.2017.
 */
public class ItemBattery extends Item {

    private double batteryLife = 100.00;

    private ItemBattery(Double weight, String name, String describtion) {
        super(weight, name, describtion);
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(double batteryLife) {
        this.batteryLife = batteryLife;
    }


}
