import java.util.*;
import java.io.*;

public class PebbleGame {
    private static void createBlackBags(int numberOfPlayers, Bags bag1, Bags bag2, Bags bag3) { // method to give the black bags values at beginning of the game
        int numberOfPebbles = numberOfPlayers * 11; // as in spec
        for (int i = 0; i < numberOfPebbles; i++) { // gives each bag a pebble for numberOfPebble times with a random int value
            bag1.addPebble(randomNumGenerator(0, 25));
            bag2.addPebble(randomNumGenerator(0, 25));
            bag3.addPebble(randomNumGenerator(0, 25));
        }
    }

    private static int randomNumGenerator(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static File checkFileInput(Scanner scan){
        boolean fileVarificationSuccessful = false;
        File blackBagFile = null;
        do {
            System.out.println("Please enter locations of bag number 0 to load:");
            String blackBagXName = scan.nextLine();
            blackBagFile = new File(blackBagXName);
            if (blackBagFile.exists() && !blackBagFile.isDirectory()) {
                fileVarificationSuccessful = true;
            } else {
                System.out.println(blackBagXName + " does not exists. Please re-enter the location of the file.");
            }
        } while (fileVarificationSuccessful == false);
        return blackBagFile;
    }

    public static int checkIntInput(Scanner scan ){

        boolean validationSuccessful = false;
        int noOfPlayersInput = 0;

        System.out.print("Please enter the number of players: ");
        do {
            String numberOfPlayersString = scan.nextLine();
            // validate that the input is an integer
            try {
                noOfPlayersInput = Integer.parseInt(numberOfPlayersString); //Converts String to Int
                // validate that the input is positive
                if (noOfPlayersInput < 0) {
                    System.out.print("Please enter a positive integer: ");
                    continue;
                } else {
                    validationSuccessful = true;
                }
            } catch (NumberFormatException e) { //If String is unable to be converted to an Int
                System.out.println("Please enter an integer number of players:");

            }
        } while (validationSuccessful == false);

        return noOfPlayersInput;
    }

    public static void gameMain() { // this goes through the actions of the game

        // starts by setting up the game
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the pebble game!! \nYou will be asked to enter the number of players.\nand then for the location of three files in turn containing comma seperated integer values the pebble weights.\nThe integer values must strictly positive. \nThe game will then be simulated, and output written to files in this directory.\n"); // opening remarks
        int noOfPlayersInput = checkIntInput(scan);
        File blackBagXFile = checkFileInput(scan);
        File blackBagYFile = checkFileInput(scan);
        File blackBagZFile = checkFileInput(scan);
        //creates the bags files after they have been checked
        // add in try catch for createFile();
        File whiteBagAFile = new File("WhiteBagA.csv");
        File whiteBagBFile = new File("WhiteBagB.csv");
        File whiteBagCFile = new File("WhiteBagC.csv");
        //creates the bags themselves as objects with basic attributes
        Bags blackBagX = new Bags("blackBagX", blackBagXFile); // initialising the bags to create the base objects
        Bags blackBagY = new Bags("blackBagY", blackBagYFile);
        Bags blackBagZ = new Bags("blackBagZ", blackBagZFile);
        Bags whiteBagA = new Bags("whiteBagA", whiteBagAFile);
        Bags whiteBagB = new Bags("whiteBagB", whiteBagBFile);
        Bags whiteBagC = new Bags("whiteBagC", whiteBagCFile);
        // for the black bags, the bags are given the pebbles with the weights
        createBlackBags(noOfPlayersInput, blackBagX, blackBagY, blackBagX);
        // end of setup

    }


    public static String readFile(File fileName) throws FileNotFoundException {
        try{
            Scanner reader = new Scanner(fileName);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                reader.close();
                return data;
            }
            reader.close();
        } catch(FileNotFoundException e){
            System.out.println("File cannot be found please enter a valid file");}

        return null;
    }

    public static String getNextPebble(String data) {
            // takes a string (line from a file) and picks an element of that csv List
        String[] dataList = data.split(",");
        Random rand = new Random();
        int randomNum = rand.nextInt((dataList.length)+1);
        return dataList[randomNum];
    }

    public static void playerWon(String PlayerName){
        //end the threads
        System.out.println("Congratulations to " + PlayerName + ", you have won the game.\nThe game is now over, Goodbye");
    }


    protected boolean winner = false;

    protected synchronized boolean win(ArrayList<Integer> playerPebbles) {
        if (this.winner) {
            return this.winner;
        } else {
            int playerPebbleValue = 0;
            for (Integer sum : playerPebbles) {
                playerPebbleValue += sum;
            }
            if (playerPebbleValue == 100) {
                this.winner = true;
                System.out.println("The game has ended with Pebbles: " + playerPebbles);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
    public void createPlayers(int noOfPlayers) {
        for (Integer j = 0; j < noOfPlayers; j++) {
            Runnable runnable = new Player("Player" + Integer.toString(j));
            Thread thread = new Thread(runnable);
            thread.setName("Player" + Integer.toString(j));
            thread.start();
        }

    }
     */
    public static void pickPebble(){
        // use getPebble method
        // threads?
    }
    public static void discardPebble(){

    }

    class Player {
        private String name;
        private int[] currentHand;


        public Player(String playerName) {
            this.name = playerName;

        }

        public String getName() {
            return this.name;

        }
        public int[] getCurrentHand(){
            return this.currentHand;
        }

        public int getHandSum(){
            int HandSum = 0;
            for(int i = 0; i < this.currentHand.length; i++){
                HandSum = HandSum + i;
            }
            return HandSum;
        }



    }

        public static void main(String args[]) {

            gameMain();


        }


}

