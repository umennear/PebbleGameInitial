/**
 * Initial unit test class for Black and White Pebble bag csv files
 */
//import
import static org.junit.Assert.*;
import java.unitl.*;
import java.io.*;

public class BagsTest{


    @Before
    public void setUp(){
        String blackBag1Name = "example_file_1.csv";
        File blackBag1 = new File(blackBag1Name);
        Scanner Reader1 = new Scanner(blackBag1);
        int noOfPlayers = 2;

        //create the bags
        //read the files
        String data = Reader1.nextLine();
        List[String] = data.
        //create a list of pebbles from the files etc
        // Create files that do and do not fail the tests
        // Get contents of file
    }
    @After
    public void reset(){
        //close any scanners
    }
    @Test
    public void checkWithinRange(List[Int] size){
        for ( int i = 0 ; i < list.size(); i++) {
            assert(i > 25); // test to check if all the pebbles values is within the set range
        }
    }
    @Test
    public void checkFileFormat(File name){
        assert(probeContentType(name) == ".cvs")
    }

    @Test
    public void testBagsLength(List[Int] file, Int noOfPlayers){
        //read file then assert the length of the list is 22
        assert(file.size() == noOfPlayers * 11)
    }
    @Test
    public void testBagsValuesPosInt(List[Int] file){
        //read each value from list, check its greater than 0 and an integer
        for (int i = 0; i < file.size() ; i++;){
            assert(i>0); // test for being positive
            assert(i, is(instanceOf(Integer.class))); // test for being an Integer
        }

    }
    @Test
    public void checkEmpty(File name){
        assert(File.length() == 0);
    }
    @Test
    public void checkFilesNotEqual(String name1, String name2, String name3){
        assert(name1 != name2 && name2 !== name3 && name1 != name3);
    }

    public static main(String args[]){
        setup();
        checkWithinRange();
        checkFileFormat("blackBag3.csv");
        testBagsLength();
        testBagsBaluesPosInt();
        checkEmpty();
        checkFilesNotEqual();
        reset();
    }

}