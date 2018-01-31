import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Graphics;

/**
 * The abstract Pokemon for the PokeBattle Simulation
 *
 * @author Heather, Aniruddha
 * @version 1
 */

public abstract class Pokemon {

    private Rectangle bounds;
    private int xPos;
    private int yPos;
    private ImageIcon image;
    private int levelUp = 10;
    private int health = 100;


    /**
     * Constructor
     *
     * Represents a Pokemon in the PokeWorld. Each Pokemon
     * has a location in the world and attributes which help
     * it reproduce and thrive.
     * @param xPos The X position of this Pokemon
     * @param yPos The Y position of this Pokemon
     * @param bounds The boundaries of the PokeWorld where
     *               the Pokemon can exist
     */
    public Pokemon(int xPos, int yPos, Rectangle bounds) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.bounds = bounds;
    }

    /**
     * @return the X position of this Pokemon
     */
    public int getXPos() {
        return this.xPos;
    }

    /**
     * @param xP the x position to which it is set
     * sets the X position of this Pokemon
     */

    public void setPosX(int xP) {
        this.xPos = xP;
    }

    /**
     * @return the Y position of this Pokemon
     */
    public int getYPos() {
        return this.yPos;
    }

    /**
     * @param yP the y position to which it is set
     * sets the Y position of this Pokemon
     */
    public void setPosY(int yP) {
        this.yPos = yP;
    }

    /**
     * @return the bounding rectangle of the PokeWorld
     *             that this Pokemon exists in
     */
    public Rectangle getBounds() {
        return this.bounds;
    }

    /**
     * @return the level of the Pokemon
     */

    public int getLevelUp() {
        return this.levelUp;
    }
    /**
     * @param l the level to which it is set
     * sets the level of this Pokemon
     */
    public void setLevelUp(int l) {
        this.levelUp = l;
    }
    /**
     * @return the health of the Pokemon
     */
    public int getHealth() {
        return this.health;
    }
    /**
     * @param h the health to which it is set
     * sets the health of this Pokemon
     */
    public void setHealth(int h) {
        this.health = h;
    }

    /**
    * Sets the image attribute for this pokemon
    * @param image the ImageIcon to use to represent this Pokemon
    */
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     * Should draw the Pokemon at its location.
     * @param g object for drawing use
     */
    public void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }

    /**
    * Will move the Pokemon instance
    * each time the instance moves its level increases and it health decreases.
    *
    */
    public abstract void move();


    /**
    * Determines whether or not the current instance of Pokemon collides with
    * another instance of a Pokemon.
    * @param otherPokemon an instance of Pokemon with which the current instance
    * collides
    * @return true if the Pokemons collide false if not
    */
    public boolean collidesWithPokemon(Pokemon otherPokemon) {
        if (this.getXPos() <=  otherPokemon.getXPos()
            && otherPokemon.getXPos() <= this.getXPos() + 90
            && this.getYPos() <= otherPokemon.getYPos()
            && otherPokemon.getXPos() <= this.getYPos() + 90) {
            return true; // check location and dimention
        }
        if (this.getXPos() >=  otherPokemon.getXPos()
            && otherPokemon.getXPos() + 90 >= this.getXPos()
            && this.getYPos() >= otherPokemon.getYPos()
            && otherPokemon.getXPos() + 90 >= this.getYPos()) {
            return true;
        }
        return false;
    }

    /**
    * Determines whether the two pokemons can reproduce
    * @param otherPokemon the pokemon with which the current pokemon can
    * reproduce
    * @return the string to be displayed if the pokemon can reproduce
    */
    public abstract boolean canReproduceWithPokemon(Pokemon otherPokemon);
    // find a method that checks the species and tries to match if they are
    // equal


    /**
    * Reproduces a new Pokemon of the same type at the same location
    * @param otherPokemon the pokemon with which the current pokemon reproduces
    * @return pokemon a pokemon of the same type if reproduction happens or else
    * should return null.
    */

    public abstract Pokemon reproduceWithPokemon(Pokemon otherPokemon);
    // if canReproduce is true, reproduce a Pokemon of same type at same
    // location,
    // should limit the no. of babies, give reproduction some random chance of
    // happening if they collide


    /**
    * Determines whether or not an instance of Pokemon has surpassed some
    * determined maximum level
    * @return string the string to be displayed if the instance has surpassed
    * the maximum level
    */
    public abstract boolean isOld();
    // determine the max level for each species and return a string stating that
        // it reached the max level


    /**
    * Determines if the current instance of Pokemon can harm another instance
    * through combat
    * @param otherPokemon the pokemon which can be harmed by the current pokemon
    * @return the string to be displayed if the combat is successful
    */
    public abstract boolean canHarmPokemon(Pokemon otherPokemon);


    /**
    * if the current instance of Pokemon can harm another instance decreases
    * the other pokemon's health by some amount.
    * @param otherPokemon the pokemon which is harmed by the current pokemon
    */

    public abstract void harmPokemon(Pokemon otherPokemon);
        // how lethal a pokemon is can be set by me
        // by decreasing its health
        // display a string that says how much the health deteriorated


    /**
    * Called when the instance of Pokemon faints for one reason or another
    */
    public void faint() {
        if (this.isOld()) {
            this.setHealth(0);
        }
    }
         //called when instance faints
        // change the health


    /**
    * Determines if the pokemon has fainted
    * @return true if the health is zero or exceeds the maximum level.
    */

    public boolean hasFainted() {
        if (this.getHealth() == 0 || this.getHealth() > 200) {
            return true;
        }
        return false;
    }
        // returns whether or not the instance has fainted
        // health == 0 or health > max level.
}
