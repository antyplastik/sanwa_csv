package csv.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreator implements Creator {

    private Path path;
    private String fileName;
    private File file;

    public FileCreator(Path path, String fileName) {
        this.path = path;
        this.fileName = fileName;
        file = new File(path.toUri());
    }

    @Override
    public boolean create() throws IOException {
        boolean created = false;
        Path pathFile = Paths.get(path.toString() + "/" + fileName);
        File file = new File(pathFile.toUri());
        File dir = new File(path.toUri());

        if (dir.exists())
            System.out.println("[INFO] Directory exist " + path.toUri());
        else {
            System.out.println("[INFO] Directory created " + path.toUri());
            Files.createDirectories(path);
            created = true;
        }

        if (file.exists())
            System.out.println("[INFO] File already exist " + pathFile.toUri());
        else {
            Files.createFile(pathFile);
            System.out.println("[INFO] File created " + path.toUri());
            created = true;
        }
        return created;
    }

    @Override
    public boolean exists() {
        return file.exists();
    }

    @Override
    public boolean destroy() {
        Path destroyPath = Paths.get(path.toString() + "/" + fileName);
        File filePath = new File(destroyPath.toUri());
        boolean deleted = filePath.delete();
        System.out.println("[INFO] " + path.toUri() + " deleted: " + deleted);
        return deleted;
    }
}
