/**
 * Initial unit test class for Black and White Pebble bag csv files
 */
//import
import static org.junit.Assert.*;
public class BagsTest{


    @Before
    public void setUp(){
        int noOfPlayers = 2;
        // also need to call the file creator here?
        //read file here
        List[Int] file = read...


    }
    @After
    public void reset(){

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

    public static main(String args[]){
    }
}