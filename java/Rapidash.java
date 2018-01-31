import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
* Rapidash
* @author Heather
* @version 1
*/
public class Rapidash extends FireType {
    private int babycount = 0;
    private int maxLevel = 130;


    /**
     * Constructor
     * @param x The X position of Rapidash
     * @param y The Y position of Rapidash
     * @param bounds The bounding Rectangle
     */
    public Rapidash(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/rapidash.png"));
    }



    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (this instanceof Rapidash && otherPokemon instanceof Rapidash) {
            return true;
        }
        return false;
    }



    @Override
    public Pokemon reproduceWithPokemon(Pokemon otherPokemon) {
        if (this.canReproduceWithPokemon(otherPokemon)
            && this.collidesWithPokemon(otherPokemon)
            && otherPokemon.getLevelUp() >= 40
            && otherPokemon.getLevelUp() <= 55
            && this.getLevelUp() >= 40
            && this.getLevelUp() <= 45
            && babycount <= 20) {
            babycount++;
            Rapidash poke = new Rapidash(this.getXPos(), this.getYPos(),
                this.getBounds());
            poke.move();
            return poke;
        }
        return null;
    }


    @Override
    public boolean isOld() {
        if (this.getLevelUp() >= this.maxLevel) {
            return true;
        }
        return false;
    }





    @Override
    public void harmPokemon(Pokemon otherPokemon) {
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 1.0
            && this.getLevelUp() > otherPokemon.getLevelUp()) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (90 / 100 * otherPokemon.getHealth()));
        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 1.0
            && this.getLevelUp() < otherPokemon.getLevelUp()) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (12 / 100 * otherPokemon.getHealth()));
        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.9) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (80 / 100 * otherPokemon.getHealth()));
        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.7) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (70 / 100 * otherPokemon.getHealth()));
        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.5) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (50 / 100 * otherPokemon.getHealth()));
        }
    }
}
