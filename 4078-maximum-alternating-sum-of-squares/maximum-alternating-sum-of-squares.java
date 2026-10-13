class Solution {
    public long maxAlternatingSum(int[] nums) {
        // In this case we 1stly make all the digit positive then arrange it in the ascending order then 
        // we will make an another array in which at the even place we will write from the right side because it is larger than the small side and at the odd place start writng from the left side
        // then sum the square of even place and and odd place simultaneously 
        // finally return its difference
        int n = nums.length;
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int left = 0;
        int right = n-1;
        int a = 0;
        if(n % 2 == 1) {    // For the odd no of element in which we have extra middle element
            arr[n-1] = nums[n/2];
        }
        while(left < right) {   // In the even digit no we have equal no of the odd and even value
            arr[a++] = nums[right--];
            arr[a++] = nums[left++];
        }
        long even = 0;
        long odd = 0;
        for(int i=0; i<n; i=i+2) {      // For the even places
            even += arr[i]*arr[i];
        }
        for(int i=1; i<n; i=i+2) {      // For the odd places
            odd += arr[i]*arr[i];
        }
        return even-odd;
    }
}