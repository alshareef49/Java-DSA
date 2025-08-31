package DSA.recursion.level1;

public class R10_PrintSubSequence {
    public static void main(String[] args) {
        // Question: Print all possible subsequences of a given string.
        // A subsequence is a sequence that can be derived from another sequence by 
        // deleting zero or more elements without changing the order of the remaining elements.
        //
        // The function should have the following signature:
        // public static void printSubsequences(String str, String ans)
        // Where:
        // - str is the input string
        // - ans is the current subsequence being built (start with empty string)
        //
        // Example:
        // String str = "abc";
        // printSubsequences(str, "");
        // Should print (order may vary):
        // ""   (empty string)
        // a
        // b
        // ab
        // c
        // ac
        // bc
        // abc
        //
        /* PSEUDO APPROACH:
        1. Base Case:
           - If input string is empty: print the current answer and return
        
        2. Recursive Case:
           - Take first character of string (ch)
           - Make two recursive calls:
             1. Include the current character in the subsequence
                - Add ch to ans
                - Recurse with remaining string
             2. Exclude the current character from subsequence
                - Keep ans as is
                - Recurse with remaining string
        
        Key Points:
        - Each character has two choices: to be included or excluded
        - The order of characters must be preserved
        - The empty string is always a valid subsequence
        - Total subsequences = 2^n where n is length of string
        */
        
        // Example usage
        String str = "abc";
        System.out.println("All subsequences of \"" + str + "\":");
        printSubsequences(str, "");
    }
    
    // TODO: Implement the recursive printSubsequences function
    public static void printSubsequences(String str, String ans) {
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        //exclude character
        printSubsequences(ros,ans);
        //include character
        printSubsequences(ros,ans+ch);
    }
}
