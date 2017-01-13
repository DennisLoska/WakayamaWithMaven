package game;

/**
 * Created by Dennis on 13.01.2017.
 */
public class ItemFlashlight extends Item {

    private boolean charged = true;

    public ItemFlashlight(Double weight, String name, String describtion, Boolean charged) {
       super(weight, name, describtion);
        this.charged = charged;
    }

    public boolean isCharged() {
        return charged;
    }

    private void setCharged(boolean charged) {
        this.charged = charged;
    }

    public void changeBatteries(ItemBattery battery){
        setCharged(true);
    }

}
