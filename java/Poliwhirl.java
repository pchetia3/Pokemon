import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
* Poliwhirl
* @author Heather
* @version 1
*/
public class Poliwhirl extends WaterType {
    private int babycount = 0;
    private int maxLevel = 200;

    /**
     * Constructor
     * @param x The X position of Poliwhirl
     * @param y The Y position of Poliwhirl
     * @param bounds The bounding Rectangle
     */
    public Poliwhirl(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/poliwhirl.png"));
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (this instanceof Poliwhirl && otherPokemon instanceof Poliwhirl) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon otherPokemon) {
        if (this.canReproduceWithPokemon(otherPokemon)
            && this.collidesWithPokemon(otherPokemon)
            && otherPokemon.getLevelUp() >= 40
            && otherPokemon.getLevelUp() <= 50
            && this.getLevelUp() >= 30
            && this.getLevelUp() <= 35
            && babycount <= 15) {
            babycount++;
            Poliwhirl poke = new Poliwhirl(this.getXPos(), this.getYPos(),
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
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.9) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (80 / 100 * otherPokemon.getHealth()));

        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.7) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (40 / 100 * otherPokemon.getHealth()));
        }
        if (otherPokemon instanceof Poliwhirl) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (88 / 100 * otherPokemon.getHealth()));
        } else if (this.canHarmPokemon(otherPokemon)
            && this.getChance() == 0.8) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (100 / 100 * otherPokemon.getHealth()));
        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.2) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (70 / 100 * otherPokemon.getHealth()));
        }
    }
}
