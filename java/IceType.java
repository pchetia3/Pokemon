import java.awt.Rectangle;
/**
 * An Ice type pokemon
 *
 * @author pchetia3
 * @version 1
 */



public abstract class IceType extends Pokemon {
    private double chance;

    /**
     * Constructor
     * @param x The X position of this Fire type
     * @param y The Y position of this Fire type
     * @param bounds The bounding Rectangle
     */
    public IceType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }
    /**
     * a getter method for the chance of harming a pokemon
     * @return this.chance chance of harming the pokemon
     */
    public double getChance() {
        return this.chance;
    }
    /**
     * a setter method for the chance of harming a pokemon
     * @param c chance of harming the pokemon
     */
    public void setChance(double c) {
        this.chance = c;
    }

    @Override
    public void move() {
        int randomX = (int) (Math.random() * 1 + 1);
        int randomY = (int) (Math.random() * 1 + 1);

        // Grass quad and fire quad
        if (this.getXPos() >= 0 && this.getXPos() < 600 - 6
            && this.getYPos() >= 0 && this.getYPos() <  300) {
            this.setPosX(this.getXPos() + (int) (Math.random() * 3 + 4));
            this.setPosY(this.getYPos() + (int) (Math.random() * 3 + 4));
        }

        // Water quad
        if (this.getXPos() >= 0 && this.getXPos() < 300
            && this.getYPos() >= 300 && this.getYPos() < 600 - 4) {
            this.setPosX(this.getXPos() + (int) (Math.random() * 2 + 1));
            this.setPosY(this.getYPos() + (int) (Math.random() * 4 + 1));
        }
        // if pokemon is at the boundaries

        // when Pokemon is in Ice quad, it is the slowest
        if (this.getXPos() >= 300 && this.getXPos() < 600 - 1
            && this.getYPos() >= 300 && this.getYPos() < 600 - 1)  {
            this.setPosX(this.getXPos() + randomX);
            this.setPosY(this.getYPos() + randomY);
        }
        if (this.getXPos() >= 600 - 90 && this.getXPos() <= 600) {
            this.setPosX(300);
            this.setPosY(200);
        }
        if (this.getYPos() >= 600 - 90 && this.getYPos() <= 600) {
            this.setPosX(200);
            this.setPosY(300);
        }
        this.setLevelUp(this.getLevelUp() + 1);
        this.setHealth(this.getHealth() - 1);


    }


    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (this instanceof IceType && otherPokemon instanceof IceType) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        if (this instanceof IceType
            && otherPokemon instanceof GrassType) {
            this.setChance(0.4);
            return true;
        }
        if (this instanceof IceType
            && otherPokemon instanceof FireType) {
            this.setChance(0.8);
            return true;
        }
        if (this instanceof IceType
            && otherPokemon instanceof WaterType) {
            this.setChance(0.9);
            return true;
        }
        if (this instanceof IceType
            && otherPokemon instanceof IceType) {
            this.setChance(1.0);
            return true;
        }
        return false;
    }
}
