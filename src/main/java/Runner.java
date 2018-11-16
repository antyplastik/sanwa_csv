import java.io.IOException;

public class Runner {



    public static void main(String[] args) {

        String testStr = "00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,Measure,,,,Current peak values,,";

        String filePath = "D:\\KP\\Pomiary\\urzadzenia_akumulatorowe\\one_aku_wiertarka_udarowa\\csv";
        String fileName = "20181115_4_mlotowiertarka_2Ah_wiercenie_beton_8mm_CT";

        String fixedFilePath = "D:\\KP\\Pomiary\\urzadzenia_akumulatorowe\\one_aku_wiertarka_udarowa\\csv\\poprawione_CSV";
        String fixedFileName = "test";

        CSVrw csVrw = new CSVrw(filePath,fileName);
        PClink7CSVstringFix csvStrfixer = new PClink7CSVstringFix(testStr);
        csVrw.newCSVfile(fixedFilePath,fixedFileName);

       csVrw.writeToLine(csvStrfixer.fixLine());

//        csVrw.writeToLine("test");

//
//        System.out.println(csvStrfixer.fixLine());


    }

}
