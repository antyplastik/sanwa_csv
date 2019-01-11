package processor;

import java.io.IOException;
import java.util.List;

public interface Processor<T> {

    void addToProcessing(T toProcessing);

    void toProcess() throws IOException;

    List<T> getFromProcessing();
}
