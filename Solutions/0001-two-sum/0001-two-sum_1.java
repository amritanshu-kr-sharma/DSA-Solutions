class Solution {
    public int[] twoSum(int[] nums, int target) {
        // I will use hash map in which we will store the value of each element by subtracting from the target value in this as well as we will compare by using containsKey() if it contain then we will return its get value and the current index otherwise we will store in the hash map
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}