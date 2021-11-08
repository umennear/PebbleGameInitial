import org.junit.Before;
import org.junit.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PebbleGameTest {
    @Before
    public void setUp() {
        File file = new File("");
        try {
            Scanner reader = new Scanner(file);
        }catch(FileNotFoundException e){
            System.out.println("File does not exist");
        }
        PebbleGame game = new PebbleGame(); //we dont have a constructor for pebble game
        String data = "2,3,4,5,6,7,8,9,10";
        File creationBlackBagXFile = new File("testBlackBagX.csv"); // the creation versions will be used to test our game set up with empty bags
        File creationBlackBagYFile = new File("testBlackBagY.csv");// this will allow us to add in new pebbles and check that the code is working correctly with the base case
        File creationBlackBagZFile = new File("testBlackBagZ.csv");
        Bags creationBlackBagX = new Bags("blackBagX", creationBlackBagXFile); // initialising the bags to create the base objects
        Bags creationBlackBagY = new Bags("blackBagY", creationBlackBagYFile);
        Bags creationBlackBagZ = new Bags("blackBagZ", creationBlackBagZFile);
        File blackBagXFile = new File("example_file_1.csv");
        File blackBagYFile = new File("example_file_2.csv");
        File blackBagZFile = new File("example_file_3.csv");
        Bags blackBagX = new Bags("blackBagX", blackBagXFile); // initialising the bags to create the base objects
        Bags blackBagY = new Bags("blackBagY", blackBagYFile);
        Bags blackBagZ = new Bags("blackBagZ", blackBagZFile);
        int noOfPlayers = 2;
        //PebbleGame.Player player1 = new PebbleGame.Player("Player 1");
        
    }

    @Test
    public void TestReadFile(File filename, String expected) throws FileNotFoundException {
        assert (PebbleGame.readFile(filename) == expected);

    }

    @Test
    public void TestGetNextPebble(String data) {
        assert (data.split(",").contains(game.getNextPebble(data)));

    }

    @Test
    public void TestRandomNumGenerator() { // not very rigorous, however is one of the best ways we can test when deasling with random numbers

        for (int i = 0; i < 20; i++) {
            int number = this.game.RandomNumberGenerator(0, 25);
            assert (number <= 25 && number >= 0);
        }
    }

    @Test
    public void TestCreateBlackBags(int noOfPlayers, Bags blackX, Bags blackY, Bags blackZ) {
        game.createBlackBags(noOfPlayers, blackX, blackY, blackZ);
        assert (game.readFile(blackX).size() == 22);
        assert (game.readFile(blackY).size() == 22);
        assert (game.readFile(blackZ).size() == 22);


    }

    @Test
    public void TestCheckIntInput() {
        assert (editiedVersionCheckIntInput("5") == 5); //correct data
        assert (editiedVersionCheckIntInput("-1") == -1); //erronous data
        assert (editiedVersionCheckIntInput("hello") == -1); // erronous data
        assert (editiedVersionCheckIntInput("0") == -1); // boundary erronous data
        assert (editiedVersionCheckIntInput("1") == 1); // boundary correct data
    }

    @Test
    public void TestCheckFileInput() { //what kinds of data to test?
        editedVersionCheckFileInput("");

    }

    // players tests
    @Test
    public void TestGetName() {
        assert (player1.getName() == "Player 1");
    }

    @Test
    void TestGetCurrentHand(int[] expectedHand) {
        assert (player1.getCurrentHand() == expectedHand);
    }

    @Test
    void TestHandSum(int expected) {
        assert (player1.handSum() == expected);
    }

    @Test
    public void TestRun() {

    }

    @Test
    public void TestDicard() {
        String[] before = player.getCurrentHand();
        discard();
        String[] After = player.getCurrentHand();
        assert (before.length == after.length - 1);
    }

    @Test
    public void TestPickUp() {
        String[] before = player.getCurrentHand();
        pickUp();
        String[] After = player.getCurrentHand();
        assert (before.length == after.length + 1);
    }

    @Test
    public void TestUpdateFile() {

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


    public int editiedVersionCheckIntInput(String input) { // these are exact replicas of the functions, however they take hard-coded strings instead of inputs, for testing purposes
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