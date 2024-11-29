import java.util.ArrayList;

/**
 * Class which involves a connections game.
 *
 * @author Shuyang Yan
 * @version ver1.0.0
 */
public class Connections
{

    private Player player;
    private Grid grid;
    private Validation validation;
    private Input input;

    /**
     * Default constructor which creates the object of the class Connections.
     *
     */
    public Connections()
    {
        //Initialise the four fields as objects of corresponding classes.
        player = new Player();
        grid = new Grid();
        validation = new Validation();
        input = new Input();
    }

    /**
     * Non-Default constructor which creates the object of the class Connections.
     *
     * @param newPlayer          Accepts the game's player as a Player.
     * @param newGrid            Accepts the grid of words as a Grid.
     * @param newValidation      Accepts a tool of validation as a Validation.
     * @param newInput           Accepts a tool of input as an Input.
     */
    public Connections(Player newPlayer, Grid newGrid, Validation newValidation, Input newInput)
    {
        player = newPlayer;
        grid = newGrid;
        validation = newValidation;
        input = newInput;
    }

    /**
     * Check whether the three input words are connected.
     *
     * @param threeInputWords    Accepts the input words as an array of strings.
     * @return                   The result as a boolean value.
     */
    public boolean areConnected(String[] threeInputWords)
    {
        if (WordGroup.checkConnections(threeInputWords).equals("no connection"))
            return false;
        System.out.println("Great work! The word theme is: " + WordGroup.checkConnections(threeInputWords));
        return true;
    }

    /**
     * Compute and display the score after one game.
     *
     * @param successAttempts     Accepts times of success attempts as an integer.
     * @param failureAttempts     Accepts times of failure attempts as an integer.
     * @return                    The score as an integer.
     */
    public int computeAndDisplayScore(int successAttempts, int failureAttempts)
    {
        int score = successAttempts * 2 - failureAttempts;
        //According to TA, the lowest score should be zero.
        if (score < 0)
            score = 0;
        System.out.println("Score: " + score + "\n");
        return score;
    }

    /**
     * Compute and display the highest score after one round.
     *
     * @param scoreCollection     Accepts all the scores as an arraylist of integer.
     */
    public void computeAndDisplayHighestScore(ArrayList<Integer> scoreCollection)
    {
        Integer highestScore = -1;
        for (Integer score: scoreCollection)
        {
            if (score > highestScore)
                highestScore = score;
        }
        System.out.println("\nYour highest score is "+highestScore);
    }

    /**
     * Display attempt times.
     *
     * @param attemptTimes     Accepts times of attempts as an integer.
     */
    public void displayAttempt(int attemptTimes)
    {
        System.out.println("Attempt: #" + attemptTimes + "\n");
    }

    /**
     * Display all the possible themes.
     */
    public void displayThemes()
    {
        System.out.println("All themes:");
        String[] themes = WordGroup.getThemes();
        //Traverse the array of themes to find the max length among all strings.
        int maxStringLength = 0;
        for (String theme: themes)
        {
            if (theme.length() > maxStringLength)
                maxStringLength = theme.length();
        }
        maxStringLength += 5;
        for (int i = 0; i < themes.length; i++)
        {
            //Use printf to control the distance between strings.
            System.out.printf("%-" + maxStringLength + "s", themes[i]);
            //Start a new line after every three words.
            if ((i + 1) % 3 == 0)
                System.out.println();
        }
    }

    /**
     * Display welcome information.
     */
    public void displayWelcome()
    {
        System.out.println("Welcome to the Java Connections game");
    }

    /**
     * Accessor method to get the player of this game.
     *
     * @return              An object of the Player class.
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Accessor method to get the grid of words.
     *
     * @return              An object of the Grid class.
     */
    public Grid getGrid()
    {
        return grid;
    }

    /**
     * Accessor method to get the tool of validation.
     *
     * @return              An object of the Validation class.
     */
    public Validation getValidation()
    {
        return validation;
    }

    /**
     * Accessor method to get the tool of input.
     *
     * @return              An object of the Input class.
     */
    public Input getInput()
    {
        return input;
    }

    /**
     * Prompt the user to input name and then check the name's format.
     *
     * @return          Whether the name passed the validation as a boolean value.
     */
    public boolean inputAndCheckName()
    {
        //Keep asking name until the input name complies with the correct format.
        do
        {
            System.out.print("Enter player name: ");
            player.setName(input.inputName());
            if (! player.isLengthInRange())
                System.out.println("Error: number of characters is not in range: 4 and 8");
            else if (! player.isAlphabeticCharacter())
                System.out.println("first character must be an alphabetic character");
            else
            {
                System.out.println("Hello, " + player.getName() + "\n");
                return true;
            }
        }while (true);
    }

    /**
     * Prompt the user to input y or n and then check the answer.
     *
     * @return          Judge the answer as a boolean value.
     */
    public boolean inputAndCheckYOrN()
    {
        String answer = "";
        //Keep asking until the answer is either y or n.
        do
        {
            System.out.print("Play again? [y/n] ");
            answer = input.inputYOrN();
            if (validation.isYOrN(answer))
                break;
            System.out.println("Invalid input");
        }while (true);

        if (answer.equals("n"))
            return true;
        return false;
    }

    /**
     * Prompt the user to input the word and then check whether the word is in the 
     * word group as well as not duplicate.
     *
     * @param wordNumber       Accepts the number of words to input as an integer.
     * @param threeInputWords  Accepts the collection of words to input as an array of strings.
     * @param Grid             Accepts a grid as an object of Grid.
     * @return                 Whether all words are in the word group and no tduplicate as a boolean value.
     */
    public boolean inputAndCheckWord(int wordNumber, String[] threeInputWords, Grid grid)
    {
        System.out.println("Enter " + wordNumber + " words: ");
        //Do the validation for each word.
        for (int i = 1; i <= wordNumber; i++)
        {
            //Keep prompting to input word until the input word is in the grid and not duplicate.
            do
            {
                System.out.print("Word " + i + ": ");
                String inputWord = input.inputWord();
                //Check if the word is in the group.
                boolean inWordGroup = false;
                for (String word: grid.getWordGroup())
                {
                    if (word.equals(inputWord))
                    {
                        //Store the correct word in the array of input words.
                        threeInputWords[i - 1] = inputWord;
                        inWordGroup = true;
                    }
                }
                //Check if the word is duplicate.
                int count = 0;
                for (String word: threeInputWords)
                {
                    if (word != null && word.equals(inputWord))
                        count++;
                }

                if (inWordGroup && count == 1)
                    break;
                else if (inWordGroup)
                    System.out.println("Duplicate entries");
                else
                    System.out.println("Word, " + inputWord + ", does not exist in grid");
            }while (true);
        }
        //Only when all words are in the grid.
        return true;
    }

    /**
     * Check whether one game is finished.
     * @param scoreCollection  Accepts the collection of all scores an arraylist of integers.
     * @param grid             Accepts a grid as an object of Grid.
     * @return                 The result as a boolean value.
     */
    public boolean isOneGameFinished(ArrayList<Integer> scoreCollection, Grid grid)
    {
        int attemptTimes = 0;
        int failureAttempts = 0;
        int successAttempts = 0;
        //Keep playing game until failing twice or succeeding with no more than one failure.
        do
        {
            //use an array of three strings to store the three input values.
            String[] threeInputWords = new String[3];
            grid.displayGrid();
            attemptTimes++;
            displayAttempt(attemptTimes);
            if (inputAndCheckWord(3, threeInputWords, grid))
                
            if (areConnected(threeInputWords))
            {
                successAttempts++;
                //If the three input words are connected, then delete them from the grid.
                grid.setWordGroup(successAttempts, threeInputWords);
            }
            else
            {
                failureAttempts++;
                //According to the demo video, the second failure will not display the following message.
                if (failureAttempts <= 1)
                    System.out.println("The entered words are not connected.");
            }
            //Fail twice.
            if (failureAttempts > 1)
                System.out.println("Game finished due to more than one failed attempt\n");
            //Succeed.
            else if (grid.getWordGroup().length == 0)
                System.out.println("Game finished\n");
            else
                continue;

            int score = computeAndDisplayScore(successAttempts, failureAttempts);
            //Add the score of one game into the collection of all scores in a round.
            scoreCollection.add(score);
            return true;
        }while (true);
    }

    /**
     * Check whether one round of games is finished.
     * @param scoreCollection  Accepts the collection of all scores an arraylist of integers.
     * @return                 The result as a boolean value.
     */
    public boolean isOneRoundFinished(ArrayList<Integer> scoreCollection)
    {
        //Keep playing the game until the player choose not to play after one game is finished.
        do
        {
            //At the begin of each game, reset the grid.   
            Grid grid = new Grid();
            if (isOneGameFinished(scoreCollection, grid) && inputAndCheckYOrN())
                return true;
        }while (true);
    }

    /**
     * Main method to being the program.
     *
     * @param args          An array of Strings representing command line arguments.
     */
    public static void main(String[] args)
    {
        //Use an arraylist to store all scores.
        ArrayList<Integer> scoreCollection = new ArrayList<Integer>();
        Connections connections = new Connections();
        connections.displayWelcome();
        if (connections.inputAndCheckName())
        connections.displayThemes();
        if (connections.isOneRoundFinished(scoreCollection))
        connections.computeAndDisplayHighestScore(scoreCollection);
        System.out.println("Goodbye");
    }

    /**
     * Mutator method to set the player of the game.
     *
     * @param newPlayer  A new player as an object of Player class.
     */
    public void setPlayer(Player newPlayer)
    {
        player = newPlayer;
    }

    /**
     * Mutator method to set the grid of words.
     *
     * @param newGrid  A new grid as an object of Grid class.
     */
    public void setGrid(Grid newGrid)
    {
        grid = newGrid;
    }

    /**
     * Mutator method to set the tool of validation.
     *
     * @param newValidation  A new tool of validation as an object of Validation class.
     */
    public void setValidation(Validation newValidation)
    {
        validation = newValidation;
    }

    /**
     * Mutator method to set the tool of input.
     *
     * @param newInput  A new tool of input as an object of Input class.
     */
    public void setInput(Input newInput)
    {
        input = newInput;
    }

}
