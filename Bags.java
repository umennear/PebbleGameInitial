import java.util.Random;
import java.util.*;
import java.io.*;

public class Bags{
    private String name;
    public List<Integer> bagPebbles = Collections.synchronizedList(new ArrayList<Integer>());
    private File fileName;

    public Bags(String name, File fileName){ //white bag
        this.name = name;
        this.fileName = fileName;
    }
    //we need to axtually add the pebbles to the bag array or no other methods will work 
//    public Bag(String name, String fileName, List<Integer> data) {
//        this.name = name;
//        this.fileName = fileName;
//
//    }

    public void addPebble(Integer weight){
        bagPebbles.add(weight);
    }

    public boolean isEmpty(){
        if(bagPebbles.size() == 0){
            return true;
        }
        return false;
    }
    public void updateFile(String data){
        // some writer function here
    }


    private int randomNumGenerator(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}


