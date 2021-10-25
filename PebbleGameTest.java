import.java.util.*;
import java.io.*;
public class GameTest{
    @Before
    public void setUp(){
        File file = new File("");
        Scanner reader = new Scanner(file);
        String expected == //contents of the test file
    }
    @After
    public void cleanUp(){
        reader.close();

    }

    @Test
    public void TestReadFile(File filename, Scanner reader, String expected){
        assert (readFile(filename, reader) == expected);

    }
    @Test
    public void TestGetNextPebble(String data){

    }
}