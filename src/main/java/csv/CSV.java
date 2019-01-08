package csv;

public interface CSV <T> {

   T read();
   void write(T toWrite);

}
