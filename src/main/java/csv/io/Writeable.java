package csv.io;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Writeable<T> {

    void write(String string) throws URISyntaxException, IOException;

}
