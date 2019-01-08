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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setHardDefinedResourcesDir() throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        //      /home/kamil/Workspace/JAVA_SDA/ChuckNorris/out/production/resources/jokesIDdb.txt
        resourcesDir = Arrays.stream(path.toString().split("/"))
                .map(e -> !e.equals(fileName) ? e + "/" : "")
                .collect(Collectors.joining())
        .replaceFirst(".$","");

        path = Paths.get(resourcesDir);
        buildDirStructure(path);
    }

    public void setManualPathToDir(String resourcesDir) throws IOException {
        Path path = Paths.get(resourcesDir);
        this.resourcesDir = path.toString();
        buildDirStructure(path);
    }

    private void buildDirStructure(Path path) throws IOException {
        Path pathFile = Paths.get(path.toString() + "/" + fileName);
        File file = new File(pathFile.toUri());
        File dir = new File(path.toUri());

        if (dir.exists())
            System.out.println("[INFO] Directory exist " + path.toUri());
        else {
            System.out.println("[INFO] Directory created " + path.toUri());
            Files.createDirectories(path);
        }

        if (file.exists())
            System.out.println("[INFO] File already exist " + pathFile.toUri());
        else {
            Files.createFile(pathFile);
            System.out.println("[INFO] File created " + path.toUri());
        }
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
