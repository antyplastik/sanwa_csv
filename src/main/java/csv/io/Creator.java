package csv.io;

import java.io.IOException;

public interface Creator {
    void create() throws IOException;
    boolean exists();
    void destroy();
}
