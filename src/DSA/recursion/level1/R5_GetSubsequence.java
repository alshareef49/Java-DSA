package DSA.recursion.level1;

import java.util.ArrayList;
import java.util.List;

public class R5_GetSubsequence {
    public static void main(String[] args) {
        // Question: Implement a recursive function to get all possible subsequences of a string
        // A subsequence is a sequence that can be derived from another sequence by deleting zero or more elements 
        // without changing the order of the remaining elements
        // 
        // The function should have the following signature:
        // public static List<String> getSubsequence(String str)
        // 
        // Example:
         String str = "abc";
         List<String> result = getSubsequence(str);
         System.out.println(result);
//         Should print: [, a, b, ab, c, ac, bc, abc] (order may vary)
        // 
        // Note: 
        // - The order of subsequences in the result list doesn't matter
        // - An empty string should return a list containing one empty string [""]
        // - Each character should be included or excluded to generate all possible combinations
    }
    
    // TODO: Implement the recursive getSubsequence function here
    public static List<String> getSubsequence(String str) {
        // Your code here
        if(str.isEmpty()){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        List<String> temp = getSubsequence(ros);
        List<String> res = new ArrayList<>();
        for(String val:temp){
            res.add(val);
            res.add(ch+val);
        }
        return res;
    }
}
