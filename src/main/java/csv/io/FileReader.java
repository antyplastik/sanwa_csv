package csv.io;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileReader implements Readable<String> {

    private String fileName;
    private String resourcesDir;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public FileReader(String fileName, String resourcesDir) {
        this.fileName = fileName;
        setManualPathToDir(resourcesDir);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setHardDefinedResourcesDir() throws URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        resourcesDir = Arrays.stream(path.toString().split("/"))
                .map(e -> !e.equals(fileName) ? e + "/" : "")
                .collect(Collectors.joining())
                .replaceFirst(".$","");
    }

    public void setManualPathToDir(String resourcesDir) {
        this.resourcesDir = Paths.get(resourcesDir).toString();
    }

    @Override
    public String read() throws IOException {
        Path path = Paths.get(resourcesDir + "/" + fileName);

        byte[] fileBytes = Files.readAllBytes(path);
        String output = new String(fileBytes);
        return output;
    }


    public Object decode() {
        return null;
    }


    public Object decompress() {
        return null;
    }
}
