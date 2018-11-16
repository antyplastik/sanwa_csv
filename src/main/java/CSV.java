import java.io.*;
import java.util.ArrayList;

public class CSV {

    private String filePath = "";
    private String fileName = "";

    private String endFileFormat = ".csv";

    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    private File file;

    private ArrayList<String> readedStringArray;


    public CSV(String filePath, String fileName, String osType) {
        this.filePath = filePath;
        this.fileName = fileName;

        String fileString = filePath + fileName + endFileFormat;

        file = new File(fileString);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("[INFO]\tFile created");
            }
        }

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            System.out.println("[INFO]\tFile found");
            readedStringArray = new ArrayList<String>();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[ERROR]\tFile: " + fileName + " not found in: " + filePath);
        }
    }


    public ArrayList readFile() {
        String line = "";
        String tmpString;
        SANWAstringFix fixStr = new SANWAstringFix();
        while (line != null) {
            try {
                line = bufferedReader.readLine();
                if (line != null) {
                    readedStringArray.add(line);
                }
            } catch (IOException e) {
                System.out.println("[ERROR]\tCan't read file");
            }
        }
        System.out.println("[INFO]\tFile readed");
        try {
            bufferedReader.close();
            System.out.println("[INFO]\tReaded file was closed");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[ERROR]\tCan't close readed file");
        }
        return readedStringArray;
    }

    public void writeFile(ArrayList<String> listToWrite) {
        System.out.println("[INFO]\tStart write to file");
        String tmpStr = "";
        int arrLen = listToWrite.size();
        for (int i = 0; i < arrLen; i++) {
            tmpStr = listToWrite.get(i);
            printWriter.println(tmpStr);
        }
        printWriter.close();
        System.out.println("[INFO]\tSaved to file");
    }
}
