import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class PebbleGameTest {
    public PebbleGame game = new PebbleGame();

    @Before
    public void setUp() {
        File file = new File("");
        try {
            Scanner reader = new Scanner(file);
        }catch(FileNotFoundException e){
            System.out.println("File does not exist");
        }
        String data = "2,3,4,5,6,7,8,9,10";
        File blackBagXFile = new File("example_file_1.csv");
        File blackBagYFile = new File("example_file_2.csv");
        File blackBagZFile = new File("example_file_3.csv");
        Bags blackBagX = new Bags("blackBagX", blackBagXFile); // initialising the bags to create the base objects
        Bags blackBagY = new Bags("blackBagY", blackBagYFile);
        Bags blackBagZ = new Bags("blackBagZ", blackBagZFile);
        int noOfPlayers = 2;
        PebbleGame.Player player = new PebbleGame.Player("Player 1");
        
    }

    @Test
    public void TestReadFile(File filename, String expected) throws FileNotFoundException {
        assert (PebbleGame.readFile(filename) == expected);

    }

    @Test
    public void TestGetNextPebble(String data, PebbleGame game) {
        assert (data.contains(game.getNextPebble(data)));

    }

    @Test
    public void TestRandomNumGenerator(PebbleGame game) { // not very rigorous, however is one of the best ways we can test when deasling with random numbers

        for (int i = 0; i < 20; i++) {
            int number = game.randomNumGenerator(0, 25);
            assert (number <= 25 && number >= 0);
        }
    }

    @Test
    public void TestCreateBlackBags(int noOfPlayers, File blackXFile, File blackYFile, File blackZFile, PebbleGame game, Bags blackX, Bags blackY, Bags blackZ) throws IOException {
        game.createBlackBags(noOfPlayers, blackX, blackY, blackZ);
        assert (game.readFile(blackXFile).length() == 22);
        assert (game.readFile(blackYFile).length() == 22);
        assert (game.readFile(blackZFile).length() == 22);
    }

    @Test
    public void TestCheckIntInput(Scanner scan) {
        assert (editiedVersionCheckIntInput("5", scan) == 5); //correct data
        assert (editiedVersionCheckIntInput("-1", scan) == -1); //erronous data
        assert (editiedVersionCheckIntInput("hello", scan) == -1); // erronous data
        assert (editiedVersionCheckIntInput("0", scan) == -1); // boundary erronous data
        assert (editiedVersionCheckIntInput("1", scan) == 1); // boundary correct data
    }

    @Test
    public void TestCheckFileInput() { //what kinds of data to test?
        editedVersionCheckFileInput("");

    }

   /**
    *  // players tests
    @Test
    public void TestGetName(PebbleGame.Player player) {
        assert (player.getName() == "Player 1");
    }

    @Test
    void TestGetCurrentHand(ArrayList<Integer> expectedHand, PebbleGame.Player player) {
        assert (player.getCurrentHand() == expectedHand);
    }

    @Test
    void TestHandSum(int expected, PebbleGame game) {
        assert (game.getHandSum() == expected);
    }

    @Test
    public void TestRun() {

    }

    @Test
    public void TestDiscard(PebbleGame.Player player) {
        String[] before = player.getCurrentHand();
        discard();
        String[] after = player.getCurrentHand();
        assert (before.length == after.length - 1);
    }

    @Test
    public void TestPickUp(PebbleGame.Player player) {
        String[] before = player.getCurrentHand();
        pickUp();
        String[] after = player.getCurrentHand();
        assert (before.length == after.length + 1);
    }

    @Test
    public void TestUpdateFile(PebbleGame.Player player) {

        pickUp();
        updateFile();
        ArrayList<String> handAfter = player.getCurrentHand();
        ArrayList<String> fileAfter = readFile();

        assert (handAfter == fileAfter);

    }

    @Test
    public void TestCheckBags(Bags bag1) {
        checkBags(bag1);
    }
    */


    public int editiedVersionCheckIntInput(String input, Scanner scan) { // these are exact replicas of the functions, however they take hard-coded strings instead of inputs, for testing purposes
        boolean validationSuccessful = false;
        int noOfPlayersInput;
        

        System.out.print("Please enter the number of players: ");
        do {
            String numberOfPlayersString = scan.nextLine();
            // validate that the input is an integer
            try {
                noOfPlayersInput = Integer.parseInt(input); //Converts String to Int
            } catch (NumberFormatException e) { //If String is unable to be converted to an Int
                return -1;
            }

            // validate that the input is positive
            if (noOfPlayersInput < 0) {
                return -1;
            } else {
                validationSuccessful = true;
            }
        } while (validationSuccessful == false);

        return noOfPlayersInput;
    }


    public File editedVersionCheckFileInput(String input) {
        boolean fileVarificationSuccessful = false;
        File blackBagFile = null;
        do {
            //System.out.println("Please enter locations of bag number 0 to load:");
            String blackBagXName = input;
            File blackBagXFile = new File(blackBagXName);
            if (blackBagXFile.exists() && !blackBagXFile.isDirectory()) {
                fileVarificationSuccessful = true;
            } else {
                return null;
            }
        } while (fileVarificationSuccessful == false);
        return blackBagFile;
    }


}


