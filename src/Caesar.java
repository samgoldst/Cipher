public class Caesar{
    public static String encrypt(String input, char key){
        int shift = Helper.find_index(key);
         StringBuilder output_builder = new StringBuilder();
        for(char c: input.toCharArray()){
            if (Helper.find_index(c) != -1){
                output_builder.append(Helper.find_letter(Helper.find_index(c) + shift));
            }
            else{
                output_builder.append(c);
            }
        }
        String output = output_builder.toString();
        return output;
    }

    public static String decrypt(String input, char key){
        int shift = Helper.find_index(key);
        StringBuilder output_builder = new StringBuilder();
        for(char c: input.toCharArray()){
            if (Helper.find_index(c) != -1){
                output_builder.append(Helper.find_letter(Helper.find_index(c) - shift));
            }
            else{
                output_builder.append(c);
            }
        }
        String output = output_builder.toString();
        return output;
    }
}