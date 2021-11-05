import java.util.*;
import java.io.*;

/**
 * The type Pebble game.
 */
public class PebbleGame {
    /**
     * Adds pebbles which fit our given parameters to black bag files
     *
     * @param numberOfPlayers
     * @param bag1
     * @param bag2
     * @param bag3
     */

    static Bags blackBagX;
    static Bags blackBagY;
    static Bags blackBagZ;
    static Bags whiteBagA;
    static Bags whiteBagB;
    static Bags whiteBagC;
    private static void createBlackBags(int numberOfPlayers, Bags bag1, Bags bag2, Bags bag3) { // method to give the black bags values at beginning of the game
        int numberOfPebbles = numberOfPlayers * 11; // as in spec
        for (int i = 0; i < numberOfPebbles; i++) { // gives each bag a pebble for numberOfPebble times with a random int value
            bag1.addPebble(randomNumGenerator(0, 25));
            bag2.addPebble(randomNumGenerator(0, 25));
            bag3.addPebble(randomNumGenerator(0, 25));
        }

        //TODO maybe need to update file
    }

    /**
     * Random number generator which generates integer numbers in a given range
     *
     * @param min
     * @param max
     * @return random number
     */
    private static int randomNumGenerator(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * Check file input file.
     *
     * @param scan the scan
     * @return the file
     */
    public static File checkFileInput(Scanner scan, int counter) {
        boolean fileVarificationSuccessful = false;
        File blackBagFile = null;
        // TODO if empty then this else something else
        do {
            System.out.println("Please enter locations of bag number " + counter.toString() + " to load:");
            String blackBagName = scan.nextLine();
            if (blackBagName.equals("E")) {
                System.exit(0);
            }
            blackBagFile = new File(blackBagName);
            if (blackBagFile.exists() && !blackBagFile.isDirectory()) {
                fileVarificationSuccessful = true;
            } else {
                System.out.println(blackBagName + " does not exists. Please re-enter the location of the file.");
            }
        } while (fileVarificationSuccessful == false);
        return blackBagFile;
    }

    /**
     * Check int input int.
     *
     * @param scan the scan
     * @return the int
     */
    public static int checkIntInput(Scanner scan) {

        boolean validationSuccessful = false;
        int noOfPlayersInput = 0;

        System.out.print("Please enter the number of players: ");
        do {
            String numberOfPlayersString = scan.nextLine();
            // validate that the input is an integer
            if (numberOfPlayersString.equals("E")) {
                System.exit(0);
                continue;
            } else {
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
            }

        } while (validationSuccessful == false);

        return noOfPlayersInput;
    }

    /**
     * Game main.
     */
    public static void gameMain() {
        // this goes through the actions of the game
        // starts by setting up the game
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the pebble game!! \nYou will be asked to enter the number of players.\nand then for the location of three files in turn containing comma seperated integer values the pebble weights.\nThe integer values must strictly positive. \nThe game will then be simulated, and output written to files in this directory.\n"); // opening remarks
        int noOfPlayersInput = checkIntInput(scan);
        File blackBagXFile = checkFileInput(scan, 1);
        File blackBagYFile = checkFileInput(scan, 2);
        File blackBagZFile = checkFileInput(scan, 3);
        //creates the bags files after they have been checked
        // add in try catch for createFile();
        File whiteBagAFile = new File("WhiteBagA.csv");
        File whiteBagBFile = new File("WhiteBagB.csv");
        File whiteBagCFile = new File("WhiteBagC.csv");
        //creates the bags themselves as objects with basic attributes
         blackBagX = new Bags("blackBagX", blackBagXFile); // initialising the bags to create the base objects
        blackBagY = new Bags("blackBagY", blackBagYFile);
        blackBagZ = new Bags("blackBagZ", blackBagZFile);
        whiteBagA = new Bags("whiteBagA", whiteBagAFile);
        whiteBagB = new Bags("whiteBagB", whiteBagBFile);
        whiteBagC = new Bags("whiteBagC", whiteBagCFile);
        // for the black bags, the bags are given the pebbles with the weights
        createBlackBags(noOfPlayersInput, blackBagX, blackBagY, blackBagX);
        // end of setup

    }


    /**
     * Reads the first line of the inputted file, useful for black and white bags as their data will always
     * be on the first line
     *
     * @param fileName the file name
     * @return the string
     * @throws FileNotFoundException the file not found exception
     */
    public static String readFile(File fileName) throws FileNotFoundException {
        try {
            Scanner reader = new Scanner(fileName);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                reader.close();
                return data;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File cannot be found please enter a valid file");
        }

        return null;
    }

    /**
     * Gets next pebble.
     *
     * @param data the data
     * @return the next pebble
     */
    public static String getNextPebble(String data) {
        // takes a string (line from a file) and picks an element of that csv List
        String[] dataList = data.split(",");
        Random rand = new Random();
        int randomNum = rand.nextInt((dataList.length) + 1);
        return dataList[randomNum];
    }

    /**
     * Player won.
     *
     * @param PlayerName the player name
     */
    public static void playerWon(String PlayerName) {
        //TODO end the threads
        System.out.println("Congratulations to " + PlayerName + ", you have won the game.\nThe game is now over, Goodbye");
    }


    /**
     * The Winner.
     */
    protected boolean winner = false;

    /**
     * Win boolean.
     *
     * @param playerPebbles the player pebbles
     * @return the boolean
     */
    protected synchronized boolean win(ArrayList<Integer> playerPebbles) { //TODO need to notify all that the game has finished
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
                // ends game
                return true;
            } else {
                return false;
            }
        }
    }


    /**
     * The type Player.
     */
    class Player extends Thread  {
        //TODO threads should be created before initial pebbles are given to players
        //TODO make the action listener work
        public String name;
        public ArrayList<Integer> currentHand = new ArrayList<Integer>();
        public String lastPickUp;
        public File fileName;
        public boolean discard;

        /**
         * Instantiates a new Player.
         *
         * @param playerName the player name
         */
        public Player(String playerName) {

            this.name = playerName;
            try {
                fileName = new File(playerName + ".txt");
                if (fileName.createNewFile()) {
                    return;
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            for(int i = 0; i <10; i++){
                pickUp();
            }

        }


        /**
         * @param e

        public String ActionPeformed(ActionEvent e) {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if (input.equals("E")) {
                System.exit(0);
            } else {
                return null;
            }
        }
        */

        public void run() {
            boolean ENotInput = true;
            Scanner scan = new Scanner(System.in);
            do {
                turn();
                //TODO check if winner
                try {
                    wait();
                } catch (Exception e) {

                }
                if(scan.nextLine().equals("E")){
                    ENotInput = false;
                }
                //TODO need to notify next player that they can now start their turn
            } while(ENotInput);

        }

        synchronized public void turn() {
            discard();
            checkBags();
            pickUp();
            // blackBag.updateFile(pebbles);
            //TODO: write to file for black bag
        }

        /**
         * Gets name.
         *
         * @return the name
         */

        synchronized public void discard() {
            //put bag setters here
            discard = true;
            Random rand = new Random();
            int pebbleNumber = rand.nextInt(10);
            int pebbleWeight = this.currentHand.get(pebbleNumber);
            this.currentHand.remove(pebbleNumber);
            String whiteBagLetter;
            ArrayList<Integer> pebbles;
            int bag;
            Bags whiteBag = new Bags();
            if (lastPickUp == null) {
                bag = randomNumGenerator(0, 3);
                if (bag == 1) {
                    whiteBag = whiteBagA;
                    whiteBagLetter = "A";
                } else if (bag == 2) {
                    whiteBag = whiteBagB;
                    whiteBagLetter = "B";
                } else if (bag == 3) {
                    whiteBag = whiteBagC;
                    whiteBagLetter = "C";
                }
            } else if (lastPickUp == "X") {
                 whiteBag = whiteBagA;
                 whiteBagLetter = "A"
            } else if (lastPickUp == "Y") {
                 whiteBag = whiteBagB;
                 whiteBagLetter = "B";
            } else if (lastPickUp == "Z") {
                 whiteBag = whiteBagC;
                 whiteBagLetter = "C";
            }
            whiteBag.addPebble(pebbleWeight);
            //whiteBag.updateFile(pebbleWeight);
            updateFile(discard, currentHand, pebbleWeight ,whiteBagLetter);

        }

        synchronized public void checkBags(Bags bag1, Bags bag2, Bags bag3){
        //TODO check if bags are empty
            bag1.isEmpty();
            bag2.isEmpty();
            bag3.isEmpty();



        }

        synchronized public void pickUp() {
            discard = false;
            Bags bag = new Bags();
            int newBag = randomNumGenerator(0, 3);

            if (newBag == 1) {
                bag = blackBagX;
                this.lastPickUp = "X";

            } else if (newBag == 2) {
                bag = blackBagY;
                this.lastPickUp = "Y";
            } else if (newBag == 3) {
                bag = blackBagZ;
                this.lastPickUp = "Z";
            }
            ArrayList<Integer> pebbles = bag.getBagPebbles();
            int pebblesize = pebbles.size();
            int pebbleIndex = randomNumGenerator(0, pebblesize - 1);
            int pick = pebbles.get(pebbleIndex);
            bag.removePebble(pebbleIndex);
            currentHand.add(pick);
            updateFile(discard, currentHand,pick, lastPickUp);

            //TODO: write to player file and black bag
        }


        /**
         * @return
         */
        public String getPlayersName() {
            return this.name;
        }

        /**
         * @return
         */
        public ArrayList<Integer> getCurrentHand() {
            return this.currentHand;
        }

        /**
         * Get hand sum int.
         *
         * @return the int
         */
        public int getHandSum() {
            int HandSum = 0;
            for (int i = 0; i < this.currentHand.size(); i++) {
                HandSum = HandSum + i;
            }
            return HandSum;
        }


        public void updateFile(boolean disgard, ArrayList<Integer> list, String data, String bag) { //focus on player output file
            try {
                String log = "";
                if (disgard) {
                    log += this.getPlayersName() + " has discarded " + data + " pebble to bag " + bag;
                }else {
                    log +=  this.getPlayersName() + " has drawn a " + data + " pebble from bag " + bag;
                }
                log += "\n" + this.getPlayersName() + " hand is " + list.toString().replaceAll("[\\[\\]]", "") + "\n";
                BufferedWriter buffer = new BufferedWriter(new FileWriter(this.fileName));
                buffer.write(log);
                buffer.close();
            }
            catch(IOException e){
                System.out.println("Something has gone really and truly wrong :( ");
            }
        }

    }



    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

            gameMain();


        }


}


