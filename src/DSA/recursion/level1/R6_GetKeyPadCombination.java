package DSA.recursion.level1;

import java.util.ArrayList;
import java.util.List;

public class R6_GetKeyPadCombination {
    // Keypad mapping (0-9)
    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx","yz"};
    
    public static void main(String[] args) {
        // Question: Implement a recursive function to get all possible keypad combinations
        // for a given numeric string, similar to old mobile phone keypads.
        // 
        // The function should have the following signature:
        // public static List<String> getKeypadCombination(String str)
        // 

        // Example:
         String str = "678";
         List<String> result = getKeypadCombination(str);
         System.out.println(result.size());
        // Should print: [ad, ae, af, bd, be, bf, cd, ce, cf]
        // 
        // Note: 
        // - The order of combinations in the result list doesn't matter
        // - For empty string or invalid input, return a list with empty string [""]
    }
    
    // TODO: Implement the recursive getKeypadCombination function here
    public static List<String> getKeypadCombination(String str) {
        if(str.isEmpty()){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        List<String> temp = getKeypadCombination(ros);
        List<String> res = new ArrayList<>();
        String charCode = codes[ch-'0'];
        for(int i=0;i<charCode.length();i++){
            for (String val:temp){
                res.add(charCode.charAt(i)+val);
            }
        }
        return res;
    }
}
