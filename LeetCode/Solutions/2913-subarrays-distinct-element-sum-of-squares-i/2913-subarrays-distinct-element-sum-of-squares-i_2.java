class Solution {
    public int sumCounts(List<Integer> nums) {
        // To generate the every possible subarrray we will use 2 nested loop
        // 1. Outer loop will choose where the array will start
        // 2. inner loop will choose where the array will end
        // then we will use HashSet to store the each element because it doesn't store the duplicate value
        // and the count od size to set array will not store any duplicate value
        int n = nums.size();
        int sum = 0;
        for(int i=0; i<n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<n; j++) {
                set.add(nums.get(j));
                int cnt = set.size();
                sum += cnt * cnt;
            }
        }
        return sum;
    }
}