class Solution {
    public int countAlwaysFound(int[] arr) {
        // code here
        // In this method Generally the question is discussing about that the any no in array 
        // whose all left side element should be smaller while in the right side it should be greater
        // so for this we will use two new array to store the value
        // 1. Suffix MIN in the right side which store the min value from the end
        // 2. Whlie prefix max will store the max value from the 0 index
        // Then we will compare both that makes the comparison easy 
        // Because at the any index we will found that max value from the left anf min value from the right
        int n = arr.length;
        int[] suffixMin = new int[n];
        suffixMin[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i+1]);
        }
        int count = 0;
        int prefixMax = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            prefixMax = Math.max(prefixMax, arr[i]);
            if(arr[i] == prefixMax && arr[i] == suffixMin[i]) {
                count++;
            }
        }
        return count;
    }
}