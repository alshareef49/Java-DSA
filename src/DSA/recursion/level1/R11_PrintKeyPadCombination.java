package DSA.recursion.level1;

public class R11_PrintKeyPadCombination {
    // Keypad mapping (0-9)
    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx","yz"};
    
    public static void main(String[] args) {
        // Question: Given a string representing a sequence of digits (0-9),
        // print all possible letter combinations that the number could represent
        // based on the traditional phone keypad mapping.
        //
        // Keypad mapping:
        // 0 -> ""
        // 1 -> ""
        // 2 -> "abc"
        // 3 -> "def"
        // 4 -> "ghi"
        // 5 -> "jkl"
        // 6 -> "mno"
        // 7 -> "pqrs"
        // 8 -> "tuv"
        // 9 -> "wxyz"
        //
        // The function should have the following signature:
        // public static void printKeypadCombination(String input, String output)
        // Where:
        // - input: The remaining digits to process
        // - output: The current combination being built (start with empty string)
        //
        // Example:
        // String digits = "23";
        // printKeypadCombination(digits, "");
        // Should print (order may vary):
        // ad, ae, af, bd, be, bf, cd, ce, cf
        //
        /* PSEUDO APPROACH:
        1. Base Case:
           - If input is empty: print the current output and return
        
        2. Recursive Case:
           - Take the first digit from input
           - Get the corresponding letters for that digit
           - For each letter:
             1. Add the letter to the current output
             2. Recurse with the remaining digits
             
        Key Points:
        - Handle empty strings for 0 and 1 digits
        - Each digit is processed exactly once
        - The order of combinations doesn't matter
        - The length of each output string equals the number of input digits
          (excluding 0s and 1s which don't map to any letters)
        */
        
        // Example usage
        String digits = "23";
        System.out.println("All possible letter combinations for \"" + digits + "\":");
        printKeypadCombination(digits, "");
    }
    
    // TODO: Implement the recursive printKeypadCombination function
    public static void printKeypadCombination(String input, String output) {
        // Your implementation here
        if(input.isEmpty()){
            System.out.println(output);
            return;
        }
        char ch = input.charAt(0);
        String ros = input.substring(1);
        String charCode = codes[ch-'0'];
        for(int i=0;i<charCode.length();i++){
            printKeypadCombination(ros,output+charCode.charAt(i));
        }
    }
}
