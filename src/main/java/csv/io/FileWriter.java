package csv.io;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWriter implements Writeable {

    private String fileName;
    private String resourcesDir;

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    public FileWriter(String fileName, String resourcesDir) throws IOException {
        this.fileName = fileName;
        setManualPathToDir(resourcesDir);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setHardDefinedResourcesDir() throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        resourcesDir = Arrays.stream(path.toString().split("/"))
                .map(e -> !e.equals(fileName) ? e + "/" : "")
                .collect(Collectors.joining())
        .replaceFirst(".$","");

        path = Paths.get(resourcesDir);
    }

    public void setManualPathToDir(String resourcesDir) throws IOException {
        Path path = Paths.get(resourcesDir);
        this.resourcesDir = path.toString();
    }

    @Override
    public void write(String string) throws IOException {
        Path path = Paths.get(resourcesDir + "/" + fileName);
        byte[] write = string.getBytes();

        Files.write(path, write, StandardOpenOption.TRUNCATE_EXISTING);

    }

    public Object code(String string) {
        return null;
    }

    public Object compress(String string) {
        return null;
    }
}
