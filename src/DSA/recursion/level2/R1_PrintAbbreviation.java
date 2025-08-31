package DSA.recursion.level2;

public class R1_PrintAbbreviation {
    public static void main(String[] args) {
        // Question: Given a string, generate all possible abbreviations of that string.
        // An abbreviation is formed by replacing one or more non-overlapping substrings with their lengths.
        // The substrings being abbreviated must be adjacent and in order.
        //
        // The function should have the following signature:
        // public static void printAbbreviations(String str, String asf, int count, int pos)
        // Where:
        // - str: The input string
        // - asf: Abbreviation so far (start with empty string)
        // - count: Count of characters to be abbreviated (start with 0)
        // - pos: Current position in the string (start with 0)
        //
        // Example:
        // String str = "pep";
        // printAbbreviations(str, "", 0, 0);
        // Should print:
        // pep
        // pe1
        // p1p
        // p2
        // 1ep
        // 1e1
        // 2p
        // 3
        //
        /* PSEUDO APPROACH:
        1. Base Case:
           - If reached end of string:
             - If count > 0: append count to asf
             - Print the current abbreviation
             - return
        
        2. Recursive Case:
           For each character, we have two choices:
           - Include the current character:
             1. If we have a pending count, add it to asf first
             2. Add the current character to asf
             3. Recurse with count=0 and pos+1
             
           - Exclude the current character (abbreviate it):
             1. Recurse with count+1 and pos+1

        Key Points:
        - Need to handle the count properly when including/excluding characters
        - When we decide to include a character after excluding some, we need to add the count
        - The order of recursive calls ensures all combinations are explored
        */
        
        // Example usage
        String str = "pep";
        System.out.println("All abbreviations of \"" + str + "\":");
        printAbbreviations(str, "", 0, 0);
    }
    
    // TODO: Implement the recursive printAbbreviations function
    public static void printAbbreviations(String str, String asf, int count, int pos) {
        // Your implementation here
        if(pos==str.length()){
            if (count == 0) {
                System.out.println(asf);
                return;
            } else {
                System.out.println(asf+count);
                return;
            }
        }
        //include
        if(count>0){
            printAbbreviations(str,asf+count+str.charAt(pos),0,pos+1);
        }else {
            printAbbreviations(str,asf+str.charAt(pos),count,pos+1);
        }
        //exclude
        printAbbreviations(str,asf,count+1,pos+1);
    }
}
