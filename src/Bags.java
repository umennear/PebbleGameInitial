
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public class Bags {
    public volatile CopyOnWriteArrayList<Integer> bagPebbles = new CopyOnWriteArrayList<Integer>();
    private String name;
    private File fileName;

    /**
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
     *
 
     */
    public int removeRandomPebble() {
        Random rand = new Random();
        int index =rand.nextInt(this.bagPebbles.size());
        bagPebbles.remove(index);
        return index;
    }
    public void removePebble(int index){
        bagPebbles.remove(index);
    }

    /**
     * Adds the pebbles
     *
     * @param weight
     */
    public void addPebble(Integer weight) {
        bagPebbles.add(weight);
    }

    /**
     * Check to see if the array list containing the current pebbles is empty
     *
     * @return
     */
    public boolean isEmpty() {
        if (bagPebbles.size() == 0) {
            return true;
        }
        return false;
    }


    /**
     * Delete the contents of the file and rewrites the new array list of the pebbles
     *
     * @param list
     */
    public void updateFile(CopyOnWriteArrayList<Integer> list) throws IOException {
        // some writer function here
        try {

            BufferedWriter buffer = new BufferedWriter(new FileWriter(this.fileName));

            buffer.write(list.toString().replaceAll("[\\[\\]]", "")); //adding arraylist to file
            buffer.close();
        } catch (IOException e) {
            System.out.println("Unable to write to bag file.");
        }
    }

    public void updateFileRemove() throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, false));
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to remove contents from bag file.");
        }
    }


    /**
     * @return
     */
    public CopyOnWriteArrayList<Integer> getBagPebbles() {
        return bagPebbles;
    }

}