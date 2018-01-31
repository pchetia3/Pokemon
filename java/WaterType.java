import java.awt.Rectangle;
/**
 * A water type pokemon
 *
 * @author Farhan Tejani
 * @version 1
 */



public abstract class WaterType extends Pokemon {
    private double chance;
    /**
     * Constructor
     * @param x The X position of this Water Type Pokemon
     * @param y The Y position of this Water Type Pokemon
     * @param bounds The bounding Rectangle
     */
    public WaterType(int x, int y, Rectangle bounds) {
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
        int randomX = (int) (Math.random() * 3 + 1);
        int randomY = (int) (Math.random() * 3 + 1);
        //Rectangle bounds = new Rectangle(300, 0, 300, 300);

        // when Pokemon is in Water quad
        if (this.getXPos() >= 0 && this.getXPos() < 300
            && this.getYPos() >= 300 && this.getYPos() < 600 - 3)  {
            this.setPosX(this.getXPos() + randomX);
            this.setPosY(this.getYPos() + randomY);
            this.setLevelUp(this.getLevelUp() + 3);

        }


        // when pokemon is in other quads
        // Grass quad and fire quad
        if (this.getXPos() >= 0 && this.getXPos() < 600
            && this.getYPos() >= 0 && this.getYPos() < 300) {
            this.setPosX(this.getXPos() + (int) (Math.random() * 2 + 1));
            this.setPosY(this.getYPos() + (int) (Math.random() * 2 + 3));
            this.setLevelUp(this.getLevelUp() + 1);
        }
        // Ice quad
        if (this.getXPos() >= 300 && this.getXPos() < 600 - 2
            && this.getYPos() >= 300 && this.getYPos() < 600 - 4) {
            this.setPosX(this.getXPos() + (int) (Math.random() * 2 + 1));
            this.setPosY(this.getYPos() + (int) (Math.random() * 4 + 1));
            this.setLevelUp(this.getLevelUp() + 1);
        }
        if (this.getXPos() >= 600 - 90 && this.getXPos() <= 600) {
            this.setPosX(400);
            this.setPosY(300);
            this.setLevelUp(this.getLevelUp() + 1);

        }
        if (this.getYPos() >= 600 - 90 && this.getYPos() <= 600) {
            this.setPosX(100);
            this.setPosY(400);
            this.setLevelUp(this.getLevelUp() + 1);
        }
        this.setHealth(this.getHealth() - 1);
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (this instanceof WaterType && otherPokemon instanceof WaterType) {
            return true;
        }
        return false;
    }


    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        if (this instanceof WaterType
            && otherPokemon instanceof GrassType) {
            this.setChance(0.7);
            return true;
        }
        if (this instanceof WaterType
            && otherPokemon instanceof FireType) {
            this.setChance(0.9);
            return true;
        }
        if (this instanceof WaterType
            && otherPokemon instanceof WaterType) {
            this.setChance(0.8);
            return true;
        }
        if (this instanceof WaterType
            && otherPokemon instanceof IceType) {
            this.setChance(0.2);
            return true;
        }
        return false;
    }
}
