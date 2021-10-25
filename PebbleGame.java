import java.util.*;
import java.io.*;

public class PebbleGame() implements interface{
    public static void GameMain(){
        Scanner  scan = new Scanner(System.in);

        System.out.println("Welcome to the pebble game!! \nYou will be asked to enter the number of players.\nand then for the location of three files in turn containing comma seperated integer values the pebble weights.\n The integer values must strictly positive. \nThe game will then be simulated, and output written to files in this directory.\n");
        System.out.println("Please enter the number of players:");

        int noOfPlayersInput = 0;
        boolean validationSuccessful = false;

        System.out.print("Please enter the number of players: ");
        do {
        // validate that the input is an integer
        if (in.hasNextInt() == true) {
        noOfPayersInput = scan.nextInt();
        } else {
        System.out.print("Please enter an integer number of players: ");
        scan.next();
        continue;
        }

        // validate that the input is positive
        if (noOfPlatersInput < 0) {
        System.out.print("Please enter a positive integer: ");
        continue;
        } else {
        validationSuccessful = true;
        }
        }
        while (validationSuccessful == false)

        boolean fileVarificationSuccessful = false;
        do{
        System.out.println("Please enter locations of bag number 0 to load:");
        String blackBag1Name = scan.nextLine();
        if(blackBag1Name.exists() && !blackBag1Name.isDirectory()){
        fileVarificationSuccessful = true;
        }else{
        System.out.println(blackBag1Name + " Does not exists. Please re-enter the location of the file.");
        }
        }while (fileVarificationSuccessful == false)
        System.out.println("Please enter locations of bag number 1 to load:");
        String blackBag2Name = scan.nextLine();
        System.out.println("Please enter locations of bag number 2 to load:");
        String blackBag3Name = scan.nextLine();
        File blackBag1 = new File (blackBag1Name);
        Scanner Reader1 = new Scanner(blackBag1)
        File blackBag2 = new File (blackBag2Name);
        Scanner Reader2 = new Scanner(blackBag2)
        File blackBag3 = new File (blackBag3Name);
        Scanner Reader3 = new Scanner(blackBag3)


    }
    public void readFile(File fileName,Scanner reader ){

        while(myReader.hasNextLine()){
            String data = reader.nextLine();
            return data;
        }
    }
    public void getNextPebble(String data){
        List[String] dataList = data.split(",");
        Random rand;
        int randomNum = rand.nextInt(0,dataList.size());
        return dataList[randomNum]


    }






    class Players{
        //threads and stuff

    }
    class Bags{
        private void randomNumGenerator(int min, int max){
            Random rand;
            int randomNum = rand.nextInt((max - min) + 1) + min;
            return randomNum;
        }
        private void createBlackBags(int numberOfPlayers, File bag1, File bag2, File bag3){
            int numberOfPebbles = numberOfPlayers*11;
            for(int i = 0; i < numberOfPebbles; i++ ){
                bag1.add(randomNumGenerator(0, 25));
                bag2.add(randomNumGenerator(0, 25));
                bag3.add(randomNumGenerator(0, 25));
            }
        }
        private File createWhiteBags(){
            try {
                File file = new File("whiteBag1.csv");
                file.createFile()
            } catch(Exception e) {
                e.printStackTrace();
            }
            try {
                File file = new File("whiteBag2.csv");
                file.createFile();
            } catch(Exception e) {
                e.printStackTrace();
            }
            try {
                File file = new File("whiteBag3.csv");
                file.createFile()
            } catch(Exception e) {
                e.printStackTrace();
            }

        }

        public static void main(String args[]){

        }
    }




}
