import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
* Venusaur
* @author Heather
* @version 1
*/
public class Venusaur extends GrassType {
    private int babycount = 0;
    private int maxLevel = 80;

    /**
     * Constructor
     * @param x The X position of Venusaur
     * @param y The Y position of Venusaur
     * @param bounds The bounding Rectangle
     */
    public Venusaur(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/venusaur.png"));
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (this instanceof Venusaur && otherPokemon instanceof Venusaur) {
            return true;
        }
        return false;
    }



    @Override
    public Pokemon reproduceWithPokemon(Pokemon otherPokemon) {
        if (this.canReproduceWithPokemon(otherPokemon)
            && this.collidesWithPokemon(otherPokemon)
            && otherPokemon.getLevelUp() >= 40
            && otherPokemon.getLevelUp() <= 45
            && this.getLevelUp() >= 30
            && this.getLevelUp() <= 32
            && babycount <= 5) {
            babycount++;
            Venusaur poke = new Venusaur(this.getXPos(), this.getYPos(),
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
        if (this instanceof Venusaur && otherPokemon instanceof FireType) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (90 / 100 * otherPokemon.getHealth()));
        } else if (this.canHarmPokemon(otherPokemon)
            && this.getChance() == 0.6) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (80 / 100 * otherPokemon.getHealth()));
        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.5) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (50 / 100 * otherPokemon.getHealth()));
        }
        if (this instanceof Venusaur && otherPokemon instanceof Poliwhirl) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (70 / 100 * otherPokemon.getHealth()));
        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.8) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (80 / 100 * otherPokemon.getHealth()));
        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.4) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (40 / 100 * otherPokemon.getHealth()));
        }
    }
}
