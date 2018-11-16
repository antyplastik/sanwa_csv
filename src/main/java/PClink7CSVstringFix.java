import java.util.ArrayList;

public class PClink7CSVstringFix {
    private char defaultSeparator = ',';
    private ArrayList<String> lineStringArray = new ArrayList<String>();

    public PClink7CSVstringFix() {}

    public String fixLine(String inputLine) {
        String result = "";
        if (inputLine != null || inputLine != "" && !lineStringArray.isEmpty()) {
            parseLine(inputLine);
            fixLineList(lineStringArray);
            result = getFixedLine();

        }
        return result;
    }

    // 00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,Measure,,,,Current peak values,,
    private String parseLine(String inputString) {
        String reasultStr = "";
        String tmpStr = "";
        int strLen = inputString.length();
        int comma = 0;
        int strIndex = 0;
        char currentChar;

        for (int i = 0; i < strLen; i++) {
            currentChar = inputString.charAt(i);
            if (currentChar == defaultSeparator) {
                lineStringArray.add(tmpStr);
                comma++;
                tmpStr = "";
//                if(i !=1)
//                    tmpStr = "";
            } else
                tmpStr = tmpStr + currentChar;

        }


//        System.out.println(comma); // 20 jest prawidlowo

        return reasultStr;
    }

    private ArrayList<String> fixLineList(ArrayList strList) {
        int listLen = strList.size();
        int tmpInt = 0;
        String tmpStr = "";
        String nextStr = "";
        String nextAfterNextStr = "";
        int removed = 0;
        int ifInt;
//        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < listLen - removed; i++) {
            tmpStr = strList.get(i).toString();
            if (tmpStr.equals("")) {
                do {
                    strList.remove(i);
                    removed++;
                    if (i < (listLen - removed) - 1)
                        nextStr = strList.get(i).toString();
                } while (nextStr.equals(""));
                tmpStr = nextStr;
            }

            ifInt = getNumberFromString(tmpStr);

            if ((ifInt > 0) && (ifInt < 10)) {
                tmpStr = tmpStr + strList.get(i + 1).toString();
                strList.set(i, tmpStr);
                strList.remove(i + 1);
                removed++;
            } else if (ifInt == 0)
                strList.remove(i);
//            if ((i < (listLen - removed) -1) && tmpStr.equals(','))
//                strList.add(i+1, defaultSeparator);;
        }
        return strList;
    }

    private int getNumberFromString(String str) {
        int digit;
        try {
            digit = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
        return digit;
    }


    public String getFixedLine() {
        int arrlen = lineStringArray.size();
        String resultStr = "";
        String currentStr = "";

        for (int i = 0; i < arrlen; i++) {
            currentStr = lineStringArray.get(i);
            if (i > 1)
                resultStr = resultStr + defaultSeparator + currentStr;
            else if (i == 0)
                resultStr = currentStr;
        }

        return resultStr;
    }

}
