package game;

/**
 * Created by Dennis on 13.01.2017.
 */
public class ItemFood extends Item {

    private String taste;

    public ItemFood(Double weight, String name, String describtion, String taste){
        super(weight, name, describtion);
        this.taste = taste;
    }
    public String getTaste() {
        return taste;
    }

}
