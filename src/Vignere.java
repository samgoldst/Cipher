import java.util.Arrays;

public class Vignere {
    public static String encrypt(String input, String keys){
        char[] key_array = keys.toCharArray();
        int[] shifts = new int[key_array.length];
        for(int i = 0; i < key_array.length; i++){
            shifts[i] = Helper.find_index(key_array[i]);
        }

        StringBuilder output_builder = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if (Helper.find_index(input.charAt(i)) != -1){
                output_builder.append(Helper.find_letter(Helper.find_index(input.charAt(i)) + shifts[i % shifts.length]));
            }
            else{
                output_builder.append(input.charAt(i));
            }
        }
        String output = output_builder.toString();
        return output;
    }

    public static String decrypt(String input, String keys){
        char[] key_array = keys.toCharArray();
        int[] shifts = new int[key_array.length];
        for(int i = 0; i < key_array.length; i++){
            shifts[i] = Helper.find_index(key_array[i]);
        }

        StringBuilder output_builder = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if (Helper.find_index(input.charAt(i)) != -1){
                output_builder.append(Helper.find_letter(Helper.find_index(input.charAt(i)) - shifts[i % shifts.length]));
            }
            else{
                output_builder.append(input.charAt(i));
            }
        }
        String output = output_builder.toString();
        return output;
    }
}
