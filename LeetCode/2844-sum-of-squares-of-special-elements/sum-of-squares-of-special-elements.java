class Solution {
    public int sumOfSquares(int[] nums) {
        // In this case we have to check the no of the element in the array and then we will chek that the array index start with 1 whose module with no of element(n) is 0 
        // then we will square the index-1 element because we know that array use 0 indexing system
        int n = nums.length;
        int sum = 0;
        for(int i=1; i<=nums.length; i++) {
            if(n % i == 0) {
                sum += nums[i-1]*nums[i-1];
            }
        }
        return sum;
    }
}
