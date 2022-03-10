public class Cipher{
    public static void main(String[] args){
        System.out.println(Vignere.decrypt(Vignere.encrypt("hello world", "ab"), "ab"));

    }
}