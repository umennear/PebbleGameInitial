import java.util.Random;
import java.IOException;

public class Bags{
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
            file.crea
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File("whiteBag2.csv");
            file.crea
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File("whiteBag3.csv");
            file.crea
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

   public static void main(String args[]){

   }
}


