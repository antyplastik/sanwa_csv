package csv.io;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Readable<T> {

    T read() throws URISyntaxException, IOException;

}
