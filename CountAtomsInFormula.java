package Aug_12_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class CountAtomsInFormula {

    public static void main(String[] args) throws IOException {

        BufferedReader stream = new BufferedReader(new InputStreamReader(System.in));
        String input = stream.readLine();
        LinkedHashMap<String, Integer> atomsMap = new LinkedHashMap<>();
        int i = 0;

        for (i = 0; i < input.length(); i++) {

            if (Character.isUpperCase(input.charAt(i)) && i+1 <= input.length()-1 && i+2 <= input.length()-1 ) {
                Character next = input.charAt(i + 1);
                Character nextToNext = input.charAt(i + 2);

                if (Character.isLowerCase(next) && Character.isDigit(nextToNext)) {
                    String str = new StringBuilder().append(input.charAt(i)).append(next).toString();
                    atomsMap.put(str, Character.getNumericValue(nextToNext));
                } else if (Character.isDigit(next) && Character.isUpperCase(nextToNext)) {
                    String str1 = new StringBuilder(input.charAt(i - 2)).append(input.charAt(i - 1)).toString();
                    atomsMap.put(str1, Character.getNumericValue(next));
                }
                else {
                    atomsMap.put(Character.toString(input.charAt(i)), 1);
                }
            }

            else
                if(Character.isUpperCase(input.charAt(i)) && i <= input.length()-1 ){
                Character next = input.charAt(i + 1);
                if (Character.isLowerCase(next))
                {
                    String str = new StringBuilder(input.charAt(i)).append(next).toString();
                    atomsMap.put(str, 1);
                }
                else if(Character.isDigit(next))
                {
                    atomsMap.put(Character.toString(input.charAt(i)),Character.getNumericValue(next));
                }
                else
                {
                    atomsMap.put(Character.toString(input.charAt(i)), 1);
                }
            }

        }

        atomsMap.entrySet().forEach(entry ->
                System.out.println(entry.getKey() + "->" + entry.getValue()));
    }
}
