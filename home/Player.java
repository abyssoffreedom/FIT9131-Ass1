/**
*This class will specify the attributes and behaviours of a player
*
*@author Shuyang Yan
*version ver 1.0.0
*/
public class Player
{

    private String name;
    /*
    Considering the score is calculated as (number of correct attempts * 2) - 
    number of unsuccessful attempts, it must be an integer.
    */ 
    private int score;
    private Validation validation;

    /**
     * Default constructor which creates the object of the class Player.
     *
     */
    public Player()
    {
        name = "default";
        score = 0;
        validation = new Validation();
    }

    /**
     * Non-Default constructor which creates the object of the class Player.
     *
     * @param newName          Accepts the players full name as a string.
     */
    public Player(String newName)
    {
        name = newName;
    }

    /**
    * Check the name's length whether it conforms to the format.
    *
    * @return            The result as a boolean value.
    */
    public boolean isLengthInRange()
    {
        if (validation.isLengthInRange(name, 4, 8))
            return true;
        return false;
    }

    /**
    * Check the name's first character whether it conforms to the format.
    *
    * @return            The result as a boolean value.
    */
    public boolean isAlphabeticCharacter()
    {
        if (validation.isAlphabeticCharacter(name))
            return true;
        return false;
    }
    
    /**
    * Accessor method to get the players name
    *
    * @return              The players name as a String.
    */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor method to get the players score.
     *
     * @return              The players score as an integer.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Mutator method to set the players name
     *
     * @param newName  The players name as a String.
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Mutator method to set the players score
     *
     * @param newScore  The players score as an integer.
     */
    public void setScore(int newScore)
    {
        score = newScore;
    }

    /**
    * toString method to transform the players state into the String form
    *
    * @return             The players state as a String.
    */
    public String toString()
    {
        return name + "scores" + score;
    }
    
}
