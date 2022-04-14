import java.util.Map;

public class Cipher{
    public static void main(String[] args){
        String input = "agdmsvklvtbcnottwtsvhvklfhkyutaokkrxegeiicvjgppkyugjlicoryaullmugjlicorvzffvcmrmcpzmnpawiicbvqjrkrxegvrkbrfgxrkrxulsivdikpbvkrxnwbhvbbpsomdkmkgomexhxsumfxttgvrudagupveokcfesruecfexyoeclfwkcmqhjrkrxdszeiotvwdlsyhobvwkwbpmuijkpcqciiuxnwzmjgagjfxyoggpukvxxtsumfxhhssxzcmulimeuxtkjrmogvgswrxwegeiicttwbpcqtvzfvzxzclulvmhfwswtrhqdciiuxnwzavgtplusuyfqjfxykglmtxkotezdsusgiofarxmckqmisgiuphvblvgvwvdagasrvgyqmohgkluaprrctulftgsgikuseomqlimeubpypykcbfwulvlhzstenkrvgdlrxggdulvskkvfejsgcusirdbxwxepkgfepwksfrgsxrxmnqusykogxvrzxmgjfwkowdgporpkgwuvzkevgeepkgfofazvedwjrkyneztlfbmnquskoenqpydykg";
        Map<String, Integer> output = Vignere.findSubStrings(input);
        System.out.println((Vignere.split(input, Vignere.findDistances(output, input))));
    }
}