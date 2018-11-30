import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class StringFixTest {

    private StringFix stringFix;

    @Before
    public void setUp(){
        stringFix = new StringFix();
    }

    @Test

    public void removeEmptyElementsFromListAndMergeSingleDigitWithNextStringPiece() {
        String testString = "00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,Measure,,,,Current peak values,,";

        String expected = "00:00:00,5440000,DCmV,23700000,oC,Measure,Current peak values";
        String actual;

        stringFix.setInputString(testString);
        actual = stringFix.fixLine();

        assertEquals(expected, actual);
    }

    @Test
    public void removeEmptyElementsFromListAndMergeLone0WithPreviousStringAtLastPosition() {
        String testString = "00:00:00,544000,0,DCmV,,,2370000,0,oC,,,,,,Measure,,,,Current peak values,,";

        String expected = "00:00:00,5440000,DCmV,23700000,oC,Measure,Current peak values";
        String actual;

        stringFix.setInputString(testString);
        actual = stringFix.fixLine();

        assertEquals(expected, actual);
    }


}
