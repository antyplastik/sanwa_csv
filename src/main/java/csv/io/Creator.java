package csv.io;

import java.io.IOException;

public interface Creator {
    boolean create() throws IOException;
    boolean exists();
    boolean destroy();
}
