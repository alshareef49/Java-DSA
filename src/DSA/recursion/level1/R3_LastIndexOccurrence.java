package DSA.recursion.level1;

public class R3_LastIndexOccurrence {
    public static void main(String[] args) {
        // Question: Implement a recursive function to find the last index of a given element in an array
        // The function should have the following signature:
        // public static int lastIndex(int[] arr, int idx, int x)
        // Where:
        // - arr is the input array
        // - idx is the current index (start with arr.length - 1 to search from end to beginning)
        // - x is the element to find
        // The function should return the last index where x is found, or -1 if not found
        
        // Example:
         int[] arr = {2, 3, 9, 8, 7, 6, 4, 12, 7, 3};
         System.out.println(lastIndex(arr, arr.length - 1, 7)); // Should print 8
         System.out.println(lastIndex(arr, arr.length - 1, 3)); // Should print 9
         System.out.println(lastIndex(arr, arr.length - 1, 99)); // Should print -1
    }
    
    // TODO: Implement the recursive lastIndex function here
    public static int lastIndex(int[] arr, int n, int x) {
        // Your code here
        if(n==0){
            if(arr[0]==x){
                return 0;
            }else {
                return -1;
            }
        }
        int res = lastIndex(arr,n-1,x);
        if(arr[n]==x){
            return n;
        }
        return res;
    }
}
