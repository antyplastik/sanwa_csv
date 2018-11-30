import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SANWAstringFixTest {

    private SANWAstringFix stringFix;

    @Before
    public void setUp(){
        stringFix = new SANWAstringFix();
    }

    // 00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,Measure,,,,Current peak values,,
    @Test
//    @Parameters({"00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,Measure,,,,Current peak values,,", ""})
    public void removeEmptyElementsFromListAndMergeSingleDigitWithNextStringPiece() {
        String testString = "00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,Measure,,,,Current peak values,,";
//        IntStream stream = testString.chars();
//
        String expected = "00:00:00,5440000,DCmV,23700000,oC,Measure,Current peak values";
        String actual;

        stringFix.setInputString(testString);
        actual = stringFix.fixLine();

        assertEquals(expected, actual);
    }

    @Test
//    @Parameters({"00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,Measure,,,,Current peak values,,", ""})
    public void removeEmptyElementsFromListAndMergeLone0WithPreviousStringAtLastPosition() {
        String testString = "00:00:00,544000,0,DCmV,,,2370000,0,oC,,,,,,Measure,,,,Current peak values,,";
//        IntStream stream = testString.chars();
//
        String expected = "00:00:00,5440000,DCmV,23700000,oC,Measure,Current peak values";
        String actual;

        stringFix.setInputString(testString);
        actual = stringFix.fixLine();

        assertEquals(expected, actual);
    }

//    @Test
//    @Parameters()
    public void mergingTheMeasurementWithASingleDigitInFront(String string) {

    }

//    @Test
//    @Parameters()
    public void mergingTheMeasurementWithASingleDigitInTheBack() {

    }

//    @Test
    public void fixedLineResult() {

    }

}
