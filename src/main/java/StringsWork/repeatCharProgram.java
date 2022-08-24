package StringsWork;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class repeatCharProgram {
    public static void main(String[] args) {
        repeatCharProgram thisClass = new repeatCharProgram();
        String str1 =  "WinterIsComming";
        System.out.println("The given string is: "+str1);
        System.out.println("The new string is: " + thisClass.repeatAllTwice(str1));

    }

    public static String repeatAllTwice(String someChar) {
        int len = someChar.length();
        String newstring = "";

        for (int i= 0; i< len; i++) {
            newstring += someChar.substring(i,i+1) + someChar.substring(i, i+1);
        }
        return newstring;
    }

    /*
     * this test calculate the frequency of country is in this array
     *
     */
    public static class CalculateTest {
        static String[] COUNTRY_NAMES
                = { "China", "Australia", "India", "USA", "USSR", "UK", "China",
                "France", "Poland", "Austria", "India", "USA", "Egypt", "China" };

    /*
     * Map With an Integer Array
     * Next, let's use a Map that wraps a counter within an Integer array used as a value:
     */

        @Test
        public void whenMapWithPrimitiveArrayCounter_runsSuccessfully() {
            Map<String, int[]> counterMap = new HashMap<>();

            counterWithPrimitiveArray(counterMap);

            assertEquals(3, counterMap.get("China")[0]);
            assertEquals(2, counterMap.get("India")[0]);
            //System.out.println(counterMap.get("China")[0]);
            //System.out.println(counterMap.get("India")[0]);
        }

        private void counterWithPrimitiveArray(Map<String, int[]> counterMap) {
            for (String country : COUNTRY_NAMES) {
                counterMap.compute(country, (k, v) -> v == null ?
                        new int[] { 0 } : v)[0]++;
            }
            System.out.println("China frequency " + counterMap.get("China")[0]);
            System.out.println("India frequency " + counterMap.get("India")[0]);
        }




    }
}
