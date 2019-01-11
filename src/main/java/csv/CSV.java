package csv;

import java.io.IOException;

public interface CSV <T> {

   T read() throws IOException;
   void write(T toWrite) throws IOException;

}
