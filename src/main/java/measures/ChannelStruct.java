package measures;

import org.joda.time.DateTime;

import java.util.List;

public class ChannelStruct {

    private String channelNo;
    private String description;

    private List<MeasureStruct> measureStructs;

    private void addMeasure(int no, DateTime time, double value, String unit){
        measureStructs.add(new MeasureStruct(no, time, value, unit));
    }
}
