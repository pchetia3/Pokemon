import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
* Pikachu
* @author pchetia3
* @version 1
*/
public class Pikachu extends IceType {
    private int babycount = 0;
    private int maxLevel = 150;
    /**
     * Constructor
     * @param x The X position of Pikachu
     * @param y The Y position of Pikachu
     * @param bounds The bounding Rectangle
     */
    public Pikachu(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/pikachu.png"));
    }


    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (this instanceof Pikachu && otherPokemon instanceof Pikachu) {
            return true;
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon otherPokemon) {
        if (this.canReproduceWithPokemon(otherPokemon)
            && this.collidesWithPokemon(otherPokemon)
            && otherPokemon.getLevelUp() >= 20
            && otherPokemon.getLevelUp() <= 25
            && this.getLevelUp() >= 30
            && this.getLevelUp() <= 32
            && babycount <= 8) {
            babycount++;
            Pikachu poke = new Pikachu(this.getXPos(), this.getYPos(),
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
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.8) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (80 / 100 * otherPokemon.getHealth()));

        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.4) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (40 / 100 * otherPokemon.getHealth()));

        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 0.9) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (90 / 100 * otherPokemon.getHealth()));

        }
        if (this.canHarmPokemon(otherPokemon) && this.getChance() == 1.0) {
            otherPokemon.setHealth(otherPokemon.getHealth()
                - (70 / 100 * otherPokemon.getHealth()));

        }

    }


}
