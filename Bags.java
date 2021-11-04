import java.util.Random;
import java.util.*;
import java.io.*;

public class Bags {
    private String name;
    public List<Integer> bagPebbles = Collections.synchronizedList(new ArrayList<Integer>());
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
*/
    /**
     * Delete the contents of the file and rewrites the new array list of the pebbles
     * @param list
     */
    public void updateFile(List<Integer> list) {
        // some writer function here

        //TODO empty the file
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));
        writer.write(list.toString().replaceAll("[\\[\\]]", ""));
        writer.close();
    }
/**

    public void updateFileRemove(List<Integer> list) {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));
        //TODO empty the file
        writer.write(list.toString().replaceAll("[\\[\\]]", ""));
        writer.close();
    }
 */

    /**
     *
     * @return
     */
    public List<Integer> getBagPebbles() {
        return bagPebbles;
    }

}