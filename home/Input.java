import java.util.Scanner;

/**
 * Class which involves several tools for input.
 *
 * @author Shuyang Yan
 * @version ver1.0.0
 */
public class Input
{

    Scanner console;

    /**
     * Default constructor which creates the object of the class Input.
     *
     */
    public Input()
    {
        console = new Scanner(System.in);
    }

    /**
     * Non-Default constructor which creates the object of the class Input.
     *
     * @param newConsole          Accepts a new console as an object of Scanner.
     */
    public Input(Scanner newConsole)
    {
        console = newConsole;
    }

    /**
     * Display method.
     */
    public void display()
    {
        System.out.println();
    }

    /**
     * Accessor method to get the console.
     *
     * @return              The console as an object of Scanner.
     */
    public Scanner getConsole()
    {
        return console;
    }

    /**
     * Input method to get the player's name.
     *
     * @return              The input name as a String.
     */
    public String inputName()
    {
        return console.nextLine();
    }

    /**
     * Input method to get the word in a game.
     *
     * @return              The input word as a String.
     */
    public String inputWord()
    {
        return console.nextLine();
    }

    /**
     * Input method to get the player's answer.
     *
     * @return              The answer to whether continue the game as a String.
     */
    public String inputYOrN()
    {
        return console.nextLine();
    }

    /**
     * Mutator method to set the console.
     *
     * @param newConsole    a new console as an object of the Scanner.
     */
    public void setConsole(Scanner newConsole)
    {
        console = newConsole;
    }

}
