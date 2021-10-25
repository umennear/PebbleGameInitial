import java.util.Random;
import java.IOException;

public class Bags{
    private String name;
    public List<Integer> bagPebbles = Collections.synchronizedList(new ArrayList<Integer>());
    private File fileName;

    public Bags(String name, File fileName, File){ //white bag
        this.name = name;
        this.fileName = fileName;
    }
//    public Bag(String name, String fileName, List<Integer> data) {
//        this.name = name;
//        this.fileName = fileName;
//
//    }

    public static void addPebble(Integer weight){
        this.bagPebbles.add(weight);
    }

    public static boolean isEmpty(){
        if(this.list.size() == 0){
            return true;
        }
        return false;
    }
    public void updateFile(String data){
        // some writer fucntion here
    }


    private void randomNumGenerator(int min, int max){
        Random rand;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}


