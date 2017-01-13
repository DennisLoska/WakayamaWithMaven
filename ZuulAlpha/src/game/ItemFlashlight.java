package game;

/**
 * Created by Dennis on 13.01.2017.
 */
public class ItemFlashlight extends Item {

    private boolean isCharged = true;

    private ItemFlashlight(Double weight, String name, String describtion) {
       super(weight, name, describtion);

    }

    public boolean isCharged() {
        return isCharged;
    }

    private void setCharged(boolean charged) {
        isCharged = charged;
    }

    public void changeBatteries(ItemBattery battery){
        setCharged(true);
    }

}
