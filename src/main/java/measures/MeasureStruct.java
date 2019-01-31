package measures;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

public class MeasureStruct {

    private int no;
    private DateTime time;
    private double value;
    private String unit;

    public MeasureStruct(int no, DateTime time, double value, String unit) {
        this.no = no;
        this.value = value;
        this.unit = unit;
        this.time = time;
    }
}
