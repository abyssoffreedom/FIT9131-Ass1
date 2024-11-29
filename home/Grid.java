import java.util.ArrayList;

/**
 * Class which involves a Grid of words.
 *
 * @author Shuyang Yan
 * @version ver1.0.0
 */
public class Grid
{

    private String[] wordGroup;

    /**
     * Default constructor which creates the object of the class Grid.
     *
     */
    public Grid()
    {
        wordGroup = WordGroup.generateGroup();
    }

    /**
     * Non-Default constructor which creates the object of the class Grid.
     *
     * @param newWordGroup          Accepts a new word group as an array of strings.
     */
    public Grid(String[] newWordGroup)
    {
        wordGroup = newWordGroup;
    }

    /**
     * Display method to display a 3 * n grid.
     */
    public void displayGrid()
    {
        System.out.println("\nWord Grid\n=========");
        int stringLength = 30;
        for (int i = 0; i < wordGroup.length; i++)
        {
            System.out.printf("%-" + stringLength + "s", wordGroup[i]);
            //Start a new line after each three words.
            if ((i + 1) % 3 == 0)
                System.out.println();
        }
        System.out.println();
    }

    /**
     * Accessor method to get the wordGroup.
     *
     * @return              The word group as an array of strings.
     */
    public String[] getWordGroup()
    {
        return wordGroup;
    }

    /**
     * Mutator method to set the wordGroup.
     *
     * @param successAttempts    Accepts the times of success attempts as an integer.
     * @param threeInputWords    Accepts the three input words as an array of strings.
     */
    public void setWordGroup(int successAttempts, String[] threeInputWords)
    {
        //Create a new array of words with a new size after each success attempt.
        String[] newWordGroup = new String[12 - successAttempts *3];
        //The index of the new wordGroup.
        int index = 0;
        /*
        Iterate in order to select the unused words in the original grid
        and then move them into the new grid.
        */
        for (int i = 0; i < wordGroup.length; i++)
        {
            boolean isUsed = false;
            for (String inputWord: threeInputWords)
            {
                if (wordGroup[i].equals(inputWord))
                {
                    isUsed = true;
                    break;
                }
            }
            if (! isUsed)
            {
                newWordGroup[index] = wordGroup[i];
                /*
                The final index will precisely be the length of wordGroup minus 3
                because every inputWord has a corresponding word in the original grid.
                */
                index++;
            }
        }
        wordGroup = newWordGroup;
    }

}
