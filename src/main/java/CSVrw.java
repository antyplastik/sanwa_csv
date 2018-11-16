import java.io.File;

public class CSVrw {

    private String filePath = "D:\\KP\\Pomiary\\urzadzenia_akumulatorowe\\one_aku_wiertarka_udarowa\\csv";
    private String fixedFilePath = "D:\\KP\\Pomiary\\urzadzenia_akumulatorowe\\one_aku_wiertarka_udarowa\\csv\\poprawione_CSV";
    private String fileName = "";

    private File file;

    public CSVrw(String filePath, String fileName) {
        file = new File(filePath + "\\" + fileName + ".csv");
    }

    public String readLine(){

        return null;
    }

    public String writeToLine(String str){

        return null;
    }

    public void newCSVfile(){

    }
}
