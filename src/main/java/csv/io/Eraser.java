package csv.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Eraser {

    public void erase(String pathToErease) {
        Path path = Paths.get(pathToErease);
        File filePath = new File(path.toUri());
        boolean deleted = filePath.delete();
        System.out.println("[INFO] " + path.toUri() + " deleted: " + deleted);
    }
}
