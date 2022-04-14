//import java.util.*;

import java.util.List;

public class Helper {
    public static char[] alphabetEnglish = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static double[] expectedValuesEnglish = {0.082, 0.015, 0.027, 0.047, 0.13, 0.022, 0.02, 0.062, 0.069, 0.0014, 0.0078, 0.041, 0.027, 0.067, 0.078, 0.019, 0.0011, 0.059, 0.062, 0.096, 0.027, 0.0097, 0.024, 0.0015, 0.02, 0.00078};

    public static char[] alphabetSpanish = "aábcdeéfghiíjklmnñoópqrstuüúvwxyz".toCharArray();
    private static double[] expectedValuesSpanish = {0.1172, 0.0044, 0.0149, 0.0387, 0.0467, 0.1372, 0.0036, 0.0069, 0.01, 0.0118, 0.0528, 0.007, 0.0052, 0.0011, 0.0524, 0.0308, 0.0683, 0.0017, 0.0844, 0.0076, 0.0289, 0.0111, 0.0641, 0.072, 0.046, 0.0455, 0.0002, 0.0012, 0.0105, 0.0004, 0.0014, 0.0109, 0.0047};


    public static char[] alphabet = alphabetEnglish;
    private static double[] expectedValues = expectedValuesEnglish;

    public static int findIndex(char c){
        for(int i = 0; i< alphabet.length; i++) {
            if (alphabet[i] == c) {
                return(i);
            }
        }
        return -1;
    }

    public static char findLetter(int n){
        return alphabet[(n + alphabet.length) % alphabet.length];
    }

    public static double chiSquare(double[] frequencies){
        double output = 0.0;
        for(int i = 0; i < alphabet.length; i++){
             output += Math.pow(frequencies[i] - expectedValues[i], 2) / expectedValues[i];
        }
        return output;
    }
    public static double[] charFrequencies(String input){
        double[] outputArray = new double[alphabet.length];
        int totalLetters = 0;
        for(char c: input.toCharArray()){
            if(findIndex(c) != -1){
                outputArray[findIndex(c)]++;
                totalLetters++;
            }
        }
        for(int i = 0; i < alphabet.length; i++){
            outputArray[i] /= totalLetters;
        }
        return outputArray;
    }

    static int gcd(int a, int b){
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int findGCD(List<Integer> arr){
        int result = arr.get(0);
        for (int element: arr){
            result = gcd(result, element);
            if(result == 1){
                return 1;
            }
        }
        return result;
    }
}