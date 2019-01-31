import fix.SingleLineFix;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SingleLineFixTest {

    private SingleLineFix singleLineFix;

    @Before
    public void setUp(){
        singleLineFix = new SingleLineFix();
    }

    @Test

    public void removeEmptyElementsFromListAndMergeSingleDigitWithNextStringPiece() {
        String testString = "00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,measures.MeasureStruct,,,,Current peak values,,";

        String expected = "00:00:00,5440000,DCmV,23700000,oC,measures.MeasureStruct,Current peak values";
        String actual;

        actual = singleLineFix.fix(testString);

        assertEquals(expected, actual);
    }

    @Test
    public void removeEmptyElementsFromListAndMergeLone0WithPreviousStringAtLastPosition() {
        String testString = "00:00:00,544000,0,DCmV,,,2370000,0,oC,,,,,,measures.MeasureStruct,,,,Current peak values,,";

        String expected = "00:00:00,5440000,DCmV,23700000,oC,measures.MeasureStruct,Current peak values";
        String actual;
        actual = singleLineFix.fix(testString);

        assertEquals(expected, actual);
    }


}
