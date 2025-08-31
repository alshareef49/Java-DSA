package DSA.recursion.level1;

public class R15_PrintPermutation {
    public static void main(String[] args) {
        // Question: Given a string, print all possible permutations of its characters.
        // A permutation is a rearrangement of all the characters in the string.
        //
        // The function should have the following signature:
        // public static void printPermutations(String str, String ans)
        // Where:
        // - str: The input string (remaining characters to be permuted)
        // - ans: The current permutation being built (start with empty string)
        //
        // Example:
        // String str = "abc";
        // printPermutations(str, "");
        // Should print (order may vary):
        // abc
        // acb
        // bac
        // bca
        // cab
        // cba
        //
        /* PSEUDO APPROACH:
        1. Base Case:
           - If input string is empty: print the current answer and return
        
        2. Recursive Case:
           For each character in the string:
           1. Extract the current character (ch)
           2. Create remaining string without ch
           3. Recurse with:
              - New string = remaining string
              - New answer = ans + ch
              
        Key Points:
        - Each character must appear exactly once in each permutation
        - The order of characters matters
        - The length of each permutation equals the length of the original string
        - The number of permutations is n! (n factorial) where n is string length
        */
        
        // Example usage
        String str = "abc";
        System.out.println("All permutations of \"" + str + "\":");
        printPermutations(str, "");
    }
    
    // TODO: Implement the recursive printPermutations function
    public static void printPermutations(String str, String ans) {
        // Your implementation here
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String ros = str.substring(0,i)+str.substring(i+1);
            printPermutations(ros,ans+ch);
        }
    }
}
