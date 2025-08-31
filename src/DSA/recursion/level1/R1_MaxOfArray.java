package DSA.recursion.level1;

public class R1_MaxOfArray {
    public static void main(String[] args) {
        // Question: Implement a recursive function to find the maximum element in an array
        // The function should have the following signature:
        // public static int findMax(int[] arr, int index)
        // Where:
        // - arr is the input array
        // - index is the current position in the array (start with 0)
        // The function should return the maximum element in the array
        
        // Example:
         int[] arr = {13, 1, -3, 22, 5};
         System.out.println(findMax(arr, arr.length-1)); // Should print 22
    }
    
    // TODO: Implement the recursive findMax function here
    public static int findMax(int[] arr, int n) {
        // Your code here
        if(n==0){
            return arr[n];
        }
        int max = findMax(arr,n-1);
        return Math.max(max,arr[n]);
    }
}
