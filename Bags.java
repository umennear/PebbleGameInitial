import java.util.Random;
import java.util.*;
import java.io.*;

public class Bags {
    private String name;
    public List<Integer> bagPebbles = Collections.synchronizedList(new ArrayList<Integer>());
    private File fileName;

    public Bags(String name, File fileName) { //white bag
        this.name = name;
        this.fileName = fileName;
    }

    public void removePebble(int index) {
        bagPebbles.remove(index);
    }

    public void addPebble(Integer weight) {
        bagPebbles.add(weight);
    }

    public boolean isEmpty() {
        if (bagPebbles.size() == 0) {
            return true;
        }
        return false;
    }
    public void updateFile(String data){
        // some writer function here
    }

    public List<Integer> getBagPebbles() {
        return bagPebbles;
    }
}