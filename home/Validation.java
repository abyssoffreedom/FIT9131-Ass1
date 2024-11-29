/**
*Class which involves several tools for validation.
*
*@author Shuyang Yan
*version ver 1.0.0
*/
public class Validation
{

    /**
     * Default constructor which creates the object of the class Validation.
     *
     */
    public Validation()
    {

    }

    /**
     * Display method.
     */
    public void display()
    {
        System.out.println();
    }

    /**
     * Check if the input string's length within the range of min to max.
     *
     * @param input         The input string as a string.
     * @param min           The minimal length of the input string.
     * @param max           The maximal length of the input string.
     * @return              The result as a boolean value.
     */
    public boolean isLengthInRange(String input, int min, int max)
    {
        if (input == null)
            return false;
        if (input.length() >= min && input.length() <= max)
            return true;
        return false;
    }

    /**
     * Check if the input string's first character is an alphabetic character.
     *
     * @param input         The input string as a string.
     * @return              The result as a boolean value.
     */
    public boolean isAlphabeticCharacter(String input)
    {
        if (input == null)
            return false;
        //In java every alphabetic character corresponds to a number.
        if (input.charAt(0) >= 65 && input.charAt(0) <= 90 || input.charAt(0) >= 97 && input.charAt(0) <= 122)
            return true;
        return false;
    }

    /**
     * Check if the input string is y or n.
     *
     * @param input         The input string as a string.
     * @return              The result as a boolean value.
     */
    public boolean isYOrN(String input)
    {
        if (input.equals("y") || input.equals("n"))
            return true;
        return false;
    }

}
