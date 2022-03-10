//import java.util.*;

public class Helper {
    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static int find_index(char c){
        for(int i = 0; i< alphabet.length; i++) {
            if (alphabet[i] == c) {
                return(i);
            }
        }
        return -1;
    }

    public static char find_letter(int n){
        return alphabet[(n + alphabet.length) % alphabet.length];
    }
}