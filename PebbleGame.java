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

    public static void gameMain() { // this goes through the actions of the game

        // starts by setting up the game
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the pebble game!! \nYou will be asked to enter the number of players.\nand then for the location of three files in turn containing comma seperated integer values the pebble weights.\n The integer values must strictly positive. \nThe game will then be simulated, and output written to files in this directory.\n"); // opening remarks
        int noOfPlayersInput = 0;
        boolean validationSuccessful = false;

        System.out.print("Please enter the number of players: ");
        do {
            String numberOfPlayersString = scan.nextLine();
            // validate that the input is an integer
            try {
                noOfPlayersInput = Integer.parseInt(numberOfPlayersString); //Converts String to Int
            } catch (NumberFormatException e) { //If String is unable to be converted to an Int
                System.out.println("Please enter an integer number of players:");
            }

            // validate that the input is positive
            if (noOfPlayersInput < 0) {
                System.out.print("Please enter a positive integer: ");
                continue;
            } else {
                validationSuccessful = true;
            }
        } while (validationSuccessful == false);


        boolean fileVarification0Successful = false;
        boolean fileVarificantion1Successful = false;
        boolean fileVarificantion2Successful = false;
        // tests that the first file is in the given directory and is of the correct format
        do {
            System.out.println("Please enter locations of bag number 0 to load:");
            blackBagXName = scan.nextLine();
            blackBagXFile = new File(blackBagXName);
            if (blackBagXFile.exists() && !blackBagXFile.isDirectory()) {
                fileVarification0Successful = true;
            } else {
                System.out.println(blackBagXName + " does not exists. Please re-enter the location of the file.");
            }
        } while (fileVarification0Successful == false);
        // tests that the second file is in the given directory and is of the correct format
        do {
            System.out.println("Please enter locations of bag number 1 to load:");
             blackBagYName = scan.nextLine();
            blackBagYFile = new File(blackBagYName);
            if (blackBagYFile.exists() && !blackBagYFile.isDirectory()) {
                fileVarificantion1Successful = true;
            } else {
                System.out.println(blackBagYName + " does not exists. Please re-enter the location of the file.");
            }
        } while (fileVarificantion1Successful == false);
        // tests that the third file is in the given directory and is of the correct format
        do {
            System.out.println("Please enter locations of bag number 2 to load:");
             blackBagZName = scan.nextLine();
             blackBagZFile = new File(blackBagZName);
            if (blackBagZFile.exists() && !blackBagZFile.isDirectory()) {
                fileVarificantion2Successful = true;
            } else {
                System.out.println(blackBag2Name + " Does not exists. Please re-enter the location of the file.");
            }
        } while (fileVarificantion2Successful == false);
        //creates the bags files after they have been checked
        File blackBagX = new File(blackBagXName);
        File blackBagY = new File(blackBagYName);
        File blackBagZ = new File(blackBagZName);
        //creates the bags themselves as objects with basic attributes
        Bag blackBagX = new Bag("blackBagX", blackBagXName); // initialising the bags to create the base objects
        Bag blackBagY = new Bag("blackBagY", blackBagYName);
        Bag blackBagZ = new Bag("blackBagZ", blackBagZName);
        Bag whiteBagA = new Bag("whiteBagA", blackBagAName);
        Bag whiteBagB = new Bag("whiteBagB", blackBagBName);
        Bag whiteBagC = new Bag("whiteBagC", blackBagCName);
        // for the black bags, the bags are given the pebbles with the weights
        createBlackBags(noOfPlayersInput, blackBagX, blackBagY, blackBagX);
        // end of setup


    }


    public void readFile(File fileName, Scanner reader) {

        while (myReader.hasNextLine()) {
            String data = reader.nextLine();
            return data;
        }
    }

    public void getNextPebble(String data) {
        List<String> dataList = data.split(",");
        Random rand;
        int randomNum = rand.nextInt(0, dataList.size());
        return dataList[randomNum];


    }


    protected boolean winner = false;

    protected synchronized boolean win(ArrayList<Integer> playerPebbles) {
        if (this.winner) {
            return this.winner;
        } else {
            int playerPebbleValue = 0;
            for (Ingteger sum : playerPebbles) {
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


    class Player {
        private String name;


        public void createPlayers(int noOfPlayers) {
            for (int j = 0; j < this.noOfPlayers; j++) {
                Runnable runnable = new Player("Player" + j.toString());
                Thread thread = new Thread(runnable);
                thread.setName("Player" + j.toString());
                thread.start();
            }

        }

        public Player(String playerName) {
            this.name = playerName;

        }

        public String getName() {
            return this.name;

        }
    }

        public static void main(String args[]) {

            gameMain();

        }


}

