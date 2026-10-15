class Solution {
    public int maxValue(int n) {
        // code here
        // Start with the given number n.
        // Check whether it contains 111.
        // If it does, identify a group of three consecutive 1s.
        // Clear the least significant bit in that group.
        // Repeat until no group of three consecutive 1s remains.
        // Return the resulting number.
        
        int consecutive = 0;
        for (int i = 30; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                consecutive++;
                if (consecutive == 3) {
                    n = n & ~(1 << i);
                    consecutive = 0;
                }
            } 
            else {
                consecutive = 0;
            }
        }

        return n;
    }
}