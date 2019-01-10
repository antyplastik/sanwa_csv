import csv.CSVImpl;
import csv.io.FileCreator;
import csv.io.FileReader;
import csv.io.FileWriter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class CSVImplTest {

    public String testFile = "test_file.csv";
    public String testDirectory = "D:\\KP\\Workspace\\Java\\sanwa_csv\\src\\resources";

    public FileWriter fw;
    public FileReader fr;
    public FileCreator fc;

    public CSVImpl fileHistory;

    @Before
    public void setUp() {
        fw = new FileWriter(testFile);
        fr = new FileReader(testFile);
    }

    @Test
    public void checkCreatingADirectoryWithAFileTest() throws IOException {
        Path filePath = Paths.get(testDirectory);
        fc = new FileCreator(filePath,testFile);

        assertThat(fc.exists(), is(true));
    }

    @Test
    public void checkFileReaderReadMethodInTheTestDirectoryTest() throws IOException, URISyntaxException {
        fr.setManualPathToDir(testDirectory);
        String read = fr.read();

        List<String> arrayList = Arrays.stream(read.split("\n"))
                        .collect(Collectors.toList());

        assertThat(arrayList, is(notNullValue()));
    }

    @Ignore
    @Test
    public void checkFileWriterWriteMethodAndFileReaderReadMethodInResourcesDirectoryTest() throws URISyntaxException, IOException {
        String testFileName = "jokesIDdb.txt";
        String testString = "Ala ma kota,\na kot ma Alę";

        fw.setFileName(testFileName);
        fw.setHardDefinedResourcesDir();

        fr.setFileName(testFileName);
        fr.setHardDefinedResourcesDir();

        fw.write(testString);
        String read = fr.read();
        fw.write("");
        assertThat(read, is(equalTo(testString)));
    }

    @Ignore
    @Test
    public void checkDeletingTheDirectoryWithTheFileTest() {

    }
}