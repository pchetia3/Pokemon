import java.awt.Rectangle;
/**
 * A grass type pokemon
 *
 * @author Farhan Tejani
 * @version 1
 */
public abstract class GrassType extends Pokemon {
    private double health;
    private double chance;

    /**
     * Constructor
     * @param x The X position of the Grass type Pokemon
     * @param y The Y position of the Grass type Pokemon
     * @param bounds The bounding Rectangle
     */
    public GrassType(int x, int y, Rectangle bounds) {
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
        int randomX = (int) (Math.random() * 2 + 1);
        int randomY = (int) (Math.random() * 1 + 1);
        //Rectangle bounds = new Rectangle(300, 0, 300, 300);

        // when Pokemon is in Grass quad
        if (this.getXPos() >= 0 && this.getXPos() < 300
            && this.getYPos() >= 0 && this.getYPos() < 300)  {
            this.setPosX(this.getXPos() + randomX);
            this.setPosY(this.getYPos() + randomY);
            this.setHealth(this.getHealth() + 2);
        }


        // when pokemon is in other quads
        //  fire quad
        if (this.getXPos() >= 300 && this.getXPos() <= 600 - 2
            && this.getYPos() >= 0 && this.getYPos() <= 300) {
            this.setPosX(this.getXPos() + (int) (Math.random() * 2 + 1));
            this.setPosY(this.getYPos() + (int) (Math.random() * 2 + 3));
            this.setHealth(this.getHealth() - 1);

        }
        // Ice quad and water quad
        if (this.getXPos() >= 0 && this.getXPos() <= 600 - 2
            && this.getYPos() >= 300 && this.getYPos() <= 600 - 4) {
            this.setPosX(this.getXPos() + (int) (Math.random() * 2 + 1));
            this.setPosY(this.getYPos() + (int) (Math.random() * 4 + 1));
            this.setHealth(this.getHealth() - 1);

        }

        if (this.getXPos() >= 600 - 90 && this.getXPos() <= 600) {
            this.setPosX(150);
            this.setPosY(300);
            this.setHealth(this.getHealth() - 1);

        }
        if (this.getYPos() >= 600 - 90 && this.getYPos() <= 600) {
            this.setPosX(300);
            this.setPosY(400);
            this.setHealth(this.getHealth() - 1);

        }

        this.setLevelUp(this.getLevelUp() + 1);



    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (this instanceof GrassType && otherPokemon instanceof GrassType) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        if (this instanceof GrassType
            && otherPokemon instanceof GrassType) {
            this.setChance(0.5);
            return true;
        }
        if (this instanceof GrassType
            && otherPokemon instanceof WaterType) {
            this.setChance(0.8);
            return true;
        }
        if (this instanceof GrassType
            && otherPokemon instanceof FireType) {
            this.setChance(0.6);
            return true;
        }
        if (this instanceof GrassType
            && otherPokemon instanceof IceType) {
            this.setChance(0.4);
            return true;
        }
        return false;
    }
}
