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

    public void updateFileAdd(String data) {
        // some writer function here
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName));
        writer.write(data);
        writer.close();
    }

    public void updateFileRemove(List<Integer> list) {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.FileName));
        writer.write(list.toString().replaceAll("[\\[\\]]", ""));
        writer.close();
    }

    public List<Integer> getBagPebbles() {
        return bagPebbles;
    }
}