import java.util.ArrayList;

public class SANWAstringFix {
    private char defaultSeparator = ',';
    String inputString;

    private ArrayList<String> outputArray;

    public SANWAstringFix() {
        this.outputArray = new ArrayList<String>();
    }

    public SANWAstringFix(String inputString) {
        this.inputString = inputString;
        this.outputArray = new ArrayList<String>();
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public void setDefaultSeparator(char defaultSeparator) {
        this.defaultSeparator = defaultSeparator;
    }

    public char getDefaultSeparator() { return defaultSeparator; }

    public ArrayList<String> fixLine(ArrayList<String> inputArray) {
        ArrayList<String> tmpArray = new ArrayList<String>();
        int index = 0;
        String inputLine;

        do {
            inputLine = inputArray.get(index);
//            outputArray.add(getFixedLine(fixLineList(parseLine(inputLine))));

            tmpArray = parseLine(inputLine);
            tmpArray = fixLineList(tmpArray);
            outputArray.add(getFixedLine(tmpArray));
            System.out.println(index + ": " + inputLine);
            index++;

        } while (inputArray.get(index + 1).charAt(0) != ',');

        outputArray = tmpArray;
        System.out.println("Done!");
        return outputArray;
    }

    public String fixLine() {
        String result = "";
        if (inputString != null || inputString != "") {
            outputArray = fixLineList(parseLine(inputString));
            result = getFixedLine(outputArray);

        }
        return result;
    }

    public ArrayList<String> getOutputArray() {
        System.out.println("[INFO]\tGet output array");
        return outputArray;
    }

    // 00:00:00,5,440000,DCmV,,,2,3700000,oC,,,,,,Measure,,,,Current peak values,,
    private ArrayList<String> parseLine(String inputString) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String tmpStr = "";
        int strLen = inputString.length();
        int comma = 0;
        int strIndex = 0;
        char currentChar;

        for (int i = 0; i < strLen; i++) {
            currentChar = inputString.charAt(i);
            if (currentChar == defaultSeparator) {
                arrayList.add(tmpStr);
                comma++;
                tmpStr = "";
//                if(i !=1)
//                    tmpStr = "";
            } else
                tmpStr = tmpStr + currentChar;

        }


//        System.out.println(comma); // 20 jest prawidlowo

        return arrayList;
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
                tmpStr = strList.get(i).toString();
            }

            ifInt = getNumberFromString(tmpStr);

            if ((ifInt > 0) && (ifInt < 10)) {
                tmpStr = tmpStr + strList.get(i + 1).toString();
                strList.set(i, tmpStr);
                strList.remove(i + 1);
                removed++;
            } else if (ifInt == 0) {
                strList.remove(i);
                removed++;
            }
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


    public String getFixedLine(ArrayList arrayList) {
        int arrlen = arrayList.size();
        String resultStr = "";
        String currentStr = "";

        for (int i = 0; i < arrlen; i++) {
            currentStr = arrayList.get(i).toString();
            if (i > 0)
                resultStr = resultStr + defaultSeparator + currentStr;
            else if (i == 0)
                resultStr = currentStr;
        }

        return resultStr;
    }

}
