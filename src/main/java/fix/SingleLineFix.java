package fix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SingleLineFix {
    private String defaultSeparator = ",";

    public String fix(String inputString) {
        if (inputString != null || inputString != "") {
            List<String> arrayList = Arrays.stream(inputString
                    .split(defaultSeparator))
                    .collect(Collectors.toList());

            arrayList = removeEmptyPositions(arrayList);
            arrayList = mergingSingleDigitsWithTheRestOfTheNumber(arrayList);

            return arrayList.stream()
                    .map(x -> x + defaultSeparator)
                    .collect(Collectors.joining())
                    .replaceFirst(".$","");
        } else
            return "[ERROR] Input string is empty";
    }

    private List<String> removeEmptyPositions(List<String> strList) {
        int listLen = strList.size();
        int removed = 0;

        for (int i = 0; i < listLen - removed; i++) {
            String actual = strList.get(i);
            String next = null;
            if (actual.equals("")) {
                do {
                    strList.remove(i);
                    removed++;
                    if (i < listLen - 1)
                        next = strList.get(i);
                } while (next.equals(""));
            }
        }
        return strList;
    }

    private List<String> mergingSingleDigitsWithTheRestOfTheNumber(List<String> strList) {          // scala pojedyncze cyfry z reszta cyfry ktora znajduje sie w innej kolumnie
        int tmpInt = 0;
        String tmpStr;
        int ifInt;

        int listLen = strList.size();
        int removed = 0;

        for (int i = 0; i < listLen - removed; i++) {
            tmpStr = strList.get(i);
            ifInt = getNumberFromString(tmpStr);

            if ((ifInt > 0) && (ifInt < 10)) {                      //for single digit in front of next element with large number
                tmpStr = tmpStr + strList.get(i + 1);
                strList.set(i, tmpStr);
                strList.remove(i + 1);
                removed++;
            } else if (ifInt == 0) {                                //for single 0 in back of previous element with large number
                tmpStr = strList.get(i - 1);
                strList.set(i - 1, tmpStr + tmpInt);
                strList.remove(i);
                removed++;
            }
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
}
