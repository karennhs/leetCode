package ibm.sample.tests;


import java.util.Map;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Romanizer
 * The following table contains some reference values for converting between
 * Arabic, Roman
 * 1, I
 * 2, II
 * 3, III
 * 4, IV
 * 5, V
 * 6, VI
 * 7, VII
 * 8, VIII
 * 9, IX
 * 10, X
 * 40, XL
 * 50, L
 * 90, XC
 * 100, C
 * 400, CD
 * 500, D
 * 900, CM
 * 1000, M
 * Given an Integer, convert it to its numeral equivalent.
 * Example:
 * Input: numbers = [1, 49, 23, 65]
 * Output: ["I","XLIX","XIII", "LXV"]
 * Constraints: 1 <= n <= 1000
 * @author Karennhs
 */
public class Romanizer {

    private static String[] getRomanicValues(Integer[] arabicNumbers) {
        String[] romanicValues = new String[arabicNumbers.length];

        for (int i = 0; i < arabicNumbers.length; i++) {
            Integer arabicNumber = arabicNumbers[i];

            if (arabicNumber < 1 || arabicNumber > 1000) {
                return null;
            }

            romanicValues[i] = getRomanicValue(getConversionTable(), arabicNumber, "");
        }


        return romanicValues;
    }

    private static String getRomanicValue(Map<Integer, String> conversionTable, Integer arabicNumber, String romanicValue) {

        if (arabicNumber <= 0) {
            return romanicValue;
        }

        int previousArabic = 1;
        String previousRomanic = "I";

        for (Map.Entry<Integer, String> entry : conversionTable.entrySet()) {
            if (entry.getKey() > arabicNumber) {
                // if (previousArabic % arabicNumber >= 0) {
                romanicValue = romanicValue + previousRomanic;
                arabicNumber -= previousArabic;
                romanicValue = getRomanicValue(conversionTable, arabicNumber, romanicValue);
                break;
                //}
            }
            if (entry.getKey().equals(arabicNumber)) {
                romanicValue = romanicValue + entry.getValue();
                arabicNumber -= entry.getKey();
                romanicValue = getRomanicValue(conversionTable, arabicNumber, romanicValue);
                break;
            } else {
                previousArabic = entry.getKey();
                previousRomanic = entry.getValue();
            }
        }

        return romanicValue;
    }

    private static Map<Integer, String> getConversionTable() {
        Map<Integer, String> conversionTable = new LinkedHashMap<>();
        conversionTable.put(1, "I");
        conversionTable.put(2, "II");
        conversionTable.put(3, "III");
        conversionTable.put(4, "IV");
        conversionTable.put(5, "V");
        conversionTable.put(6, "VI");
        conversionTable.put(7, "VII");
        conversionTable.put(8, "VIII");
        conversionTable.put(9, "IX");
        conversionTable.put(10, "X");
        conversionTable.put(40, "XL");
        conversionTable.put(50, "L");
        conversionTable.put(90, "XC");
        conversionTable.put(100, "C");
        conversionTable.put(400, "CD");
        conversionTable.put(500, "D");
        conversionTable.put(900, "CM");
        conversionTable.put(1000, "M");
        return conversionTable;
    }

    public static void main(String[] args) {
        Integer[] arabicNumbers = {2,999,1000, 1000};

        System.out.println("result:" + Arrays.toString(getRomanicValues(arabicNumbers)));

    }

}
