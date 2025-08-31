package DSA.recursion.level1;

public class R2_FirstIndexOfOccurrence {
    public static void main(String[] args) {
        // Question: Implement a recursive function to find the first index of a given element in an array
        // The function should have the following signature:
        // public static int firstIndex(int[] arr, int idx, int x)
        // Where:
        // - arr is the input array
        // - idx is the current index to check (start with 0)
        // - x is the element to find
        // The function should return the first index where x is found, or -1 if not found
        
        // Example:
         int[] arr = {2, 3, 9, 8, 7, 6, 4, 12, 7, 3};
         System.out.println(firstIndex(arr, 0, 7)); // Should print 4
         System.out.println(firstIndex(arr, 0, 3)); // Should print 1
         System.out.println(firstIndex(arr, 0, 99)); // Should print -1
    }
    
    // TODO: Implement the recursive firstIndex function here
    public static int firstIndex(int[] arr, int idx, int x) {
        // Your code here
        if(idx==arr.length){
            return -1;
        }
        if(arr[idx]==x){
            return idx;
        }
        return firstIndex(arr,idx+1,x);
    }
}
