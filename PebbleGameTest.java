import java.util.*;
import java.io.*;
import org.junit.*;
import java.lang.*;

public class PebbleGameTest{
    @Before
    public void setUp(){
        File file = new File("");
        Scanner reader = new Scanner(file);
        PebbleGame game = new PebbleGame();
        String data = "2,3,4,5,6,7,8,9,10";
        /*File creationBlackBagXFile = new File("testBlackBagX.csv"); // the creation versions will be used to test our game set up with empty bags
        File creationBlackBagYFile = new File("testBlackBagY.csv");// this will allow us to add in new pebbles and check that the code is working correctly with the base case
        File creationBlackBagZFile = new File("testBlackBagZ.csv");
        Bags creationBlackBagX = new Bags("blackBagX", blackBagXFile); // initialising the bags to create the base objects
        Bags creationBlackBagY = new Bags("blackBagY", blackBagYFile);
        Bags creationBlackBagZ = new Bags("blackBagZ", blackBagZFile);*/
        File blackBagXFile = new File("example_file_1.csv");
        File blackBagYFile = new File("example_file_2.csv");
        File blackBagZFile = new File("example_file_3.csv");
        Bags blackBagX = new Bags("blackBagX", blackBagXFile); // initialising the bags to create the base objects
        Bags blackBagY = new Bags("blackBagY", blackBagYFile);
        Bags blackBagZ = new Bags("blackBagZ", blackBagZFile);
        int noOfPlayers = 2;
        Player player1 = new Player("Player 1");
    }

    @Test
    public void TestReadFile(File filename, String expected){
        assert (readFile(filename) == expected);

    }
    @Test
    public void TestGetNextPebble(String data){
        assert (data.split(",").contains(game.getNextPebble(data)));

    }
    @Test
    public void TestRandomNumGenerator(){ // not very rigorous, however is one of the best ways we can test when deasling with random numbers

        for(int i = 0; i < 20; i++){
            int number = this.Game.RandomNumberGenerator(0, 25);
            assert(number <=25 && number >= 0);
        }
    }
    @Test
    public void TestCreateBlackBags(int noOfPlayers, Bags blackX, Bags blackY, Bags blackZ){
        game.createBlackBags(noOfPlayers, blackX, blackY, blackZ);
        assert(game.readFile(blackX).size() == 22);
        assert(game.readFile(blackY).size() == 22);
        assert(game.readFile(blackZ).size() == 22);


    }
    @Test
    public void TestCheckIntInput(){
        assert(editiedVersionCheckIntInput("5") == 5); //correct data
        assert(editiedVersionCheckIntInput("-1") == null); //erronous data
        assert(editiedVersionCheckIntInput("hello") == null); // erronous data
        assert(editiedVersionCheckIntInput("0") == null); // boundary erronous data
        assert(editiedVersionCheckIntInput("1") == 1); // boundary correct data
    }
    @Test
    public void TestCheckFileInput(){ //what kinds of data to test?
        editedVersionCheckFileInput("");

    }

    // players tests
    @Test
    public void TestGetName(){
        assert(player1.getName() == "Player 1");
    }
    @Test
    void TestGetCurrentHand(int[] expectedHand){
        assert(player1.getCurrentHand() == expectedHand);
    }
    @Test
    void TestHandSum(int expected){
        assert(player1.handSum() == expected );
    }
    @Test
    public void TestRun(){

    }
    @Test
    public void TestDicard(){
        String[] before = player.getCurrentHand();
        Discard();
        String[] After = player.getCurrentHand();
        assert(before.length == after.length-1);
    }
    @Test
    public void TestPickUp(){
        String[] before = player.getCurrentHand();
        PickUp();
        String[] After = player.getCurrentHand();
        assert(before.length == after.length +1);
    }
    @Test
    public void TestUpdateFile(){

        PickUp();
        UpdateFile();
        ArrayList<String> handAfter = player.getCurrentHand();
        ArrayList<String> fileAfter = readFile();

        assert(handAfter == fileAfter);

    }
    @Test
    public void TestCheckBags(Bags bag1){
        checkBags(bag1);

    }



    public int editiedVersionCheckIntInput(String input){ // these are exact replicas of the functions, however they take hard-coded strings instead of inputs, for testing purposes
        boolean validationSuccessful = false;
        int noOfPlayersInput;

        System.out.print("Please enter the number of players: ");
        do {
            String numberOfPlayersString = scan.nextLine();
            // validate that the input is an integer
            try {
                noOfPlayersInput = Integer.parseInt(input); //Converts String to Int
            } catch (NumberFormatException e) { //If String is unable to be converted to an Int
                return null;
            }

            // validate that the input is positive
            if (noOfPlayersInput < 0) {
                return null;
            } else {
                validationSuccessful = true;
            }
        } while (validationSuccessful == false);

        return noOfPlayersInput;
    }
    public int editedVersionCheckFileInput(String input){
        boolean fileVarificationSuccessful = false;
        File blackBagFile = null;
        do {
            //System.out.println("Please enter locations of bag number 0 to load:");
            String blackBagXName = input;
            blackBagXFile = new File(blackBagXName);
            if (blackBagXFile.exists() && !blackBagXFile.isDirectory()) {
                fileVarificationSuccessful = true;
            } else {
                return null;
            }
        } while (fileVarificationSuccessful == false);
        return blackBagFile;
    }




}