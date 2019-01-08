import csv.io.FileReader;
import csv.io.FileWriter;
import csv.io.io.FileReader;
import csv.io.io.FileWriter;
import org.junit.Before;
import org.junit.Test;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CSVImplTest {

    public String testFile = "test_file.txt";
    public String testDirectory = "D:\\KP\\Workspace\\Java\\sanwa_csv\\src\\resources";

    public FileWriter fw;
    public FileReader fr;

    public CSVio fileHistory;

    @Before
    public void setUp() {
        fw = new FileWriter(testFile);
        fr = new FileReader(testFile);
    }

    @Test
    public void checkCreatingADirectoryWithAFileTest() throws IOException {
        Path filePath = Paths.get((testDirectory + "/" + testFile));
        File file = new File(filePath.toUri());
        File dir = new File(testDirectory);
        fw.setManualPathToDir(testDirectory);

        assertThat(file.exists(), is(true));
    }

    @Test
    public void checkFileWriterWriteMethodAndFileReaderReadMethodInTheTestDirectoryTest() throws IOException, URISyntaxException {
        String testString = "Ala ma kota,\na kot ma Alę";

        fw.setManualPathToDir(testDirectory);
        fr.setManualPathToDir(testDirectory);

        fw.write(testString);
        String read = fr.read();
        fw.write("");
        assertThat(read, is(equalTo(testString)));
    }

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

    @Test
    public void checkDeletingTheDirectoryWithTheFileTest() {

    }
}