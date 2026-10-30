class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // In this method we have use two pointer because it is sorted array 
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) return new int[]{left+1, right+1}; // Add one due to 1-indexed array
            else if(sum > target) right--;
            else left++;
        }
        return new int[]{};
    }
}