public class Caesar{
    public static String encrypt(String input, char key){
        int shift = Helper.findIndex(key);
         StringBuilder outputBuilder = new StringBuilder();
        for(char c: input.toCharArray()){
            if (Helper.findIndex(c) != -1){
                outputBuilder.append(Helper.findLetter(Helper.findIndex(c) + shift));
            }
            else{
                outputBuilder.append(c);
            }
        }
        String output = outputBuilder.toString();
        return output;
    }

    public static String decrypt(String input, char key){
        int shift = Helper.findIndex(key);
        StringBuilder outputBuilder = new StringBuilder();
        for(char c: input.toCharArray()){
            if (Helper.findIndex(c) != -1){
                outputBuilder.append(Helper.findLetter(Helper.findIndex(c) - shift));
            }
            else{
                outputBuilder.append(c);
            }
        }
        String output = outputBuilder.toString();
        return output;
    }
    public static String decode(String input) {
        double minValue = Double.MAX_VALUE;
        int winningKey = -1;
        for (int i = 0; i < Helper.alphabet.length; i++) {
            String possibleString = decrypt(input, Helper.findLetter(i));
            double result = Helper.chiSquare(Helper.charFrequencies(possibleString));
            if (result < minValue) {
                minValue = result;
                winningKey = i;
            }
        }
        return decrypt(input, Helper.findLetter(winningKey));
    }
}