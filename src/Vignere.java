import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vignere {
    public static String encrypt(String input, String keys){
        char[] keyArray = keys.toCharArray();
        int[] shifts = new int[keyArray.length];
        for(int i = 0; i < keyArray.length; i++){
            shifts[i] = Helper.findIndex(keyArray[i]);
        }

        StringBuilder outputBuilder = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if (Helper.findIndex(input.charAt(i)) != -1){
                outputBuilder.append(Helper.findLetter(Helper.findIndex(input.charAt(i)) + shifts[i % shifts.length]));
            }
            else{
                outputBuilder.append(input.charAt(i));
            }
        }
        String output = outputBuilder.toString();
        return output;
    }

    public static String decrypt(String input, String keys){
        char[] keyArray = keys.toCharArray();
        int[] shifts = new int[keyArray.length];
        for(int i = 0; i < keyArray.length; i++){
            shifts[i] = Helper.findIndex(keyArray[i]);
        }

        StringBuilder outputBuilder = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if (Helper.findIndex(input.charAt(i)) != -1){
                outputBuilder.append(Helper.findLetter(Helper.findIndex(input.charAt(i)) - shifts[i % shifts.length]));
            }
            else{
                outputBuilder.append(input.charAt(i));
            }
        }
        String output = outputBuilder.toString();
        return output;
    }

    public static Map<String, Integer> findSubStrings(String input){
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        for(int end = 1; end <= input.length(); end++){
            for(int start = 0; start < end - 1; start++){
                String key = input.substring(start, end);
                if(counter.containsKey(key)){
                    counter.put(key, counter.get(key) + 1);
                }
                else{
                    counter.put(key, 1);
                }
            }
        }
        HashMap<String, Integer> output = new HashMap<String, Integer>();

        for(Map.Entry<String, Integer> pair : counter.entrySet()) {
            if(pair.getValue() > 1 && pair.getKey().length() > 4){
                output.put(pair.getKey(), pair.getValue());
            }
        }
        return output;
    }
    public static int findDistances(Map<String, Integer> inputDictionary, String message){
        List<Integer> distances = new ArrayList<Integer>();
        for(String substring : inputDictionary.keySet()){
            int last_see = 0;
            for(int i = 0; i < (message.length() - substring.length()); i++) {
                if (message.substring(i, i + substring.length()).equals(substring)) {
                    if (last_see == 0) {
                        last_see = i;
                    } else {
                        distances.add(i - last_see);
                        last_see = i;
                    }
                }
            }
        }
        return Helper.findGCD(distances);
    }

    public static String split(String message, int period) {
        String[] outputStrings = new String[period];
        StringBuilder[] stringBuilders = new StringBuilder[period];
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < period; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        for (int i = 0; i < message.length(); i++) {
            stringBuilders[i % period].append(message.charAt(i));
        }
        for (int i = 0; i < period; i++) {
            outputStrings[i] = stringBuilders[i].toString();
            outputStrings[i] = Caesar.decode(outputStrings[i]);
        }
        for (int i = 0; i < message.length(); i++) {
            output.append(outputStrings[i % period].charAt(i / period));
        }
        return output.toString();
    }
}