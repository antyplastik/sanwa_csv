import java.util.ArrayList;

public class PClink7CSVfix {

    private String newFile = "";
    private String newFilePath = "";

    private char defaultSeparator = ',';
    private String line;
    private ArrayList<String> parametersInLine = new ArrayList<String>();

    public PClink7CSVfix(String line) {
        this.line = line;
    }

    public PClink7CSVfix(String newFile, String newFilePath) {
        this.newFile = newFile;
        this.newFilePath = newFilePath;
    }

    public String fixLine() {
        String result = "";
        if (line != null || line != "" && !parametersInLine.isEmpty()) {
            parseLine(line);
            result = getFixedLine(fixLineList(parametersInLine));

        }
        return result;
    }

    // 00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,Measure,,,,Current peak values,,
    public String parseLine(String readedLine) {
        String reasultStr = "";
        String tmpStr = "";
        int strLen = readedLine.length();
        int comma = 0;
        int strIndex = 0;
        char currentChar;
        char nextChar = 0;
        char nextAfterNextChar = 0;

        do{
            currentChar = readedLine.charAt(strIndex);

            if (strIndex<strLen -1)
                nextChar = readedLine.charAt(strIndex+1);
            if (strIndex < strLen - 2)
                nextAfterNextChar = readedLine.charAt(strIndex+2);

            if (nextChar == defaultSeparator){
                comma++;
            }

            else if (currentChar != defaultSeparator && nextChar != defaultSeparator && nextAfterNextChar != defaultSeparator){

            }

            else if (currentChar != defaultSeparator && nextChar != defaultSeparator && nextAfterNextChar == defaultSeparator) {
                parametersInLine.add(tmpStr);
                tmpStr = "";
            }

            else if (currentChar != defaultSeparator && nextChar == defaultSeparator) {
                tmpStr = tmpStr + currentChar;
                parametersInLine.add(tmpStr);
                tmpStr = "";
            }

            if ((currentChar >= 48 && currentChar <=57) && (nextChar == defaultSeparator) && (nextAfterNextChar >= 48 && nextAfterNextChar <=57)){ // jezeli liczby dzieli przecinek
                strIndex++;
            }

//                tmpStr = tmpStr + currentChar;



            if (strIndex < strLen -1)
                strIndex++;
            else
                break;
        } while(true);


        System.out.println(comma); // 20 jest prawidlowo

        for (int j = 0; j < comma; j++) {

        }

        return reasultStr;
    }

    public ArrayList<String> fixLineList(ArrayList strList) {
        int listLen = strList.size();
        int tmpInt = 0;
        String tmpStr = "";
        String nextStr = "";
//        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < listLen; i++) {
            tmpStr = strList.get(i).toString();

            if (i == 1) {
                tmpStr = tmpStr + strList.get(i + 1).toString();
                strList.set(i, tmpStr);
                strList.remove(i + 1);
            }
        }
        return strList;
    }


    public String getFixedLine(ArrayList strList) {
        int arrlen = strList.size();
        String resultStr = "";

        for (int i = 9; i < arrlen; i++)
            if (i > 0) {
                resultStr = resultStr + defaultSeparator + strList.get(i).toString();
            }
        return resultStr;
    }

}
