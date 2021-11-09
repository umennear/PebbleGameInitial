import junit.textui.TestRunner;
import org.junit.*;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class BagsTest {



    @Before
    public void setUp() {

        String blackBag1Name = "example_file_1.csv";
        File blackBag1 = new File(blackBag1Name);
        String data = "";
        try {
            Scanner Reader1 = new Scanner(blackBag1);
            data = Reader1.nextLine();
        }
        catch(FileNotFoundException e){

        }
        int noOfPlayers = 2;
        //create the bags
        //read the files

        String[] dataList = data.split(",");
        ArrayList<Integer> fileList = new ArrayList<Integer>();
        for (int i = 0; i > dataList.length ; i++) {
            fileList.add(Integer.valueOf(dataList[i]));
        }



        //create a list of pebbles from the files etc
        // Create files that do and do not fail the tests
        // Get contents of file
    }

    @After
    public void reset() {
        //close any scanners
    }

    @Test
    public void checkWithinRange(List<Integer> size) {
        for (int i = 0; i < size.size(); i++) {
            assert (i > 25); // test to check if all the pebbles values is within the set range
        }
    }

    @Test
    public void checkFileFormat(File name) {
        assert (name.getName().contains(".csv"));
    }

    @Test
    public void testBagsLength(List<Integer> file, int noOfPlayers) {
        //read file then assert the length of the list is 22
        assert (file.size() == noOfPlayers * 11);
    }

    @Test
    public void testBagsValuesPosInt(List<Integer> file) {
        //read each value from list, check its greater than 0 and an integer
        for (int i = 0; i < file.size(); i++) {
            assert (i > 0); // test for being positive
            //assert(i, is(instanceOf(Integer.class))); // test for being an Integer
        }

    }

    //@Test
    //public void checkEmpty(File name) {
    //    assert (name.length == 0);
   // }
    //    @Test
    //    public void checkFilesNotEqual(String name1, String name2, String name3){
    //        assert(name1 != name2 && name2 !== name3 && name1 != name3);
    //    @Test
    //    public void
    //    public static void main(String args[]) {
    //        setUp();
    //        checkWithinRange(fileList);
    //        checkFileFormat(blackBag1);
    //        testBagsLength(fileList, noOfPlayers);
    //        testBagsBaluesPosInt(fileList);
    //        reset();
    //    }
}