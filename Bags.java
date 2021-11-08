import java.util.Random;
import java.util.*;
import java.io.*;

public class Bags {
    private String name;
    public ArrayList<Integer> bagPebbles = new ArrayList<Integer>();
    private File fileName;

    /**
     *
     * @param name
     * @param fileName
     */

    public Bags(String name, File fileName) {
        this.name = name;
        this.fileName = fileName;
    }
    public Bags(){

    }

    /**
     * Removes the pebbles
     * @param index
     */
    public void removePebble(int index) {
        bagPebbles.remove(index);
    }

    /**
     * Adds the pebbles
     * @param weight
     */
    public void addPebble(Integer weight) {
        bagPebbles.add(weight);
    }

    /**
     * Check to see if the array list containing the current pebbles is empty
     * @return
     */
    public boolean isEmpty() {
        if (bagPebbles.size() == 0) {
            return true;
        }
        return false;
    }

/**
 public void updateFileAdd(String data) {
 // some writer function here
 BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));
 writer.write(data);
 writer.close();
 }

 public void updateFileAdd(List<Integer> list) {
 */
    /**
     * Delete the contents of the file and rewrites the new array list of the pebbles
     * @param list
     */
    public void updateFile(ArrayList<Integer> list) throws IOException {
        // some writer function here

        //TODO empty the file
        try {

            BufferedWriter buffer = new BufferedWriter(new FileWriter(this.fileName));
            buffer.write(list.toString().replaceAll("[\\[\\]]", "")); // have you added the new arraylist??
            buffer.close();
        }
        catch( IOException e){
            System.out.println("Something has gone really and truly wrong :( ");
        }
    }

     public void updateFileRemove() throws IOException{
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, false));
            writer.close();
        }
        catch( IOException e){
            System.out.println("Something has gone really and truly wrong :( ");
     }


    /**
     *
     * @return
     */
    public ArrayList<Integer> getBagPebbles() {
        return bagPebbles;
    }

    public void empty(){
        //TODO empty the file
    }
}