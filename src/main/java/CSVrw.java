import java.io.*;
import java.util.ArrayList;

public class CSVrw {

    private String filePath = "D:\\KP\\Pomiary\\urzadzenia_akumulatorowe\\one_aku_wiertarka_udarowa\\csv";
    private String fileName = "";
    private String fixedFilePath = "D:\\KP\\Pomiary\\urzadzenia_akumulatorowe\\one_aku_wiertarka_udarowa\\csv\\poprawione_CSV";
    private String fixedFileName = "";
    private String endFileFormat = ".csv";

    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    private File file;
    private File fixedFile;

    private ArrayList<String> lineStrArr;


    public CSVrw(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;

        String fileString = filePath + "\\" + fileName + endFileFormat;
        file = new File(fileString);
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            System.out.println("[INFO]\tFile found");
            lineStrArr = new ArrayList<String>();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[ERROR]\tFile " + fileName + " not found in: " + filePath);
        }
    }


    public void newCSVfile(String fixedFilePath, String fixedFileName) {
        this.fixedFilePath = fixedFilePath;
        this.fixedFileName = fixedFileName;

        String fileString = fixedFilePath + "\\" + fileName + endFileFormat;
        fixedFile = new File(fileString);
        try {
            printWriter = new PrintWriter(new FileWriter(fixedFile));
            System.out.println("[INFO]\tFile generated");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[ERROR]\tFile " + fileString + " not found in: " + fixedFilePath);
        }
    }

    public String readLine() {
        String line = "";

        do {
            try {
                line = bufferedReader.readLine();

//                System.out.println(line);
            } catch (IOException e) {
                System.out.println("[ERROR]\tCan't read file");
            }


        } while (line != null);

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[ERROR]\tCan't close file");
        }

        return line;
    }


    public void writeToLine(ArrayList array) {
        array = lineStrArr;
        String tmpStr = "";
        int arrLen = array.size();
        for (int i = 0; i < arrLen; i++) {
            tmpStr = array.get(i);
            printWriter.println(tmpStr);
        }
        printWriter.close();
    }

    public void fileToFile (){
        
    }
}
