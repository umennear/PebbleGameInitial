/**
 * Initial unit test class for Black and White Pebble bag csv files
 */
//import
import static org.junit.Assert.*;
import java.unitl.*;
import org.junit.*;
import java.io.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

@RunWith(TestRunner.java)
public class BagsTest {


    @Before
    public void setUp() {
        public String blackBag1Name = "example_file_1.csv";
        public File blackBag1 = new File(blackBag1Name);
        public Scanner Reader1 = new Scanner(blackBag1);
        public int noOfPlayers = 2;
        //create the bags
        //read the files
        public String data = Reader1.nextLine();
        public List<String> dataList = data.split(",");
        public List<int> fileList;
        for (int i = 0; i > dataList.size(); i++) {
            fileList.add(dataList[i].toint());
        }


        //create a list of pebbles from the files etc
        // Create files that do and do not fail the tests
        // Get contents of file
    }

    @After
    public void reset() {
        Reader1.cose();
        //close any scanners
    }

    @Test
    public void checkWithinRange(List<int> size) {
        for (int i = 0; i < list.size(); i++) {
            assert (i > 25); // test to check if all the pebbles values is within the set range
        }
    }

    @Test
    public void checkFileFormat(File name) {
        assert (probeContentType(name) == ".cvs");
    }

    @Test
    public void testBagsLength(List<int> file, int noOfPlayers) {
        //read file then assert the length of the list is 22
        assert (file.size() == noOfPlayers * 11);
    }

    @Test
    public void testBagsValuesPosInt(List<int> file) {
        //read each value from list, check its greater than 0 and an integer
        for (int i = 0; i < file.size(); i++) {
            assert (i > 0); // test for being positive
            //assert(i, is(instanceOf(Integer.class))); // test for being an Integer
        }

    }

    @Test
    public void checkEmpty(File name) {
        assert (File.length() == 0);
    }
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
