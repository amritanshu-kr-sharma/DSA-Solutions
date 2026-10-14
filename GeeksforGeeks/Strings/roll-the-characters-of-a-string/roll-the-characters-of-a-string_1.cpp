class Solution {
    public String findRollOut(String s, int[] roll) {
        // code here
        // This is brute Force approach in which we will use two nested loop 1st is for the roll
        // 2nd is for the updating the character
        // It's TC = O(n^2) but expected is O(n) so it will give TLE
        // StringBuilder ans = new StringBuilder(s);
        // for(int cnt : roll) {
        //     for(int i=0; i<cnt; i++) {
        //         char ch = ans.charAt(i);
        //         if(ch == 'z') {
        //             ch = 'a';
        //         }
        //         else ch++;
        //         ans.setCharAt(i, ch);
        //     }
        // }
        // return ans.toString();
        
        // 2nd Method
        // By using Difference array Approach
        // In this we will make a difference array in this in the begining we will increment by one
        // And at the roll element value we will decrement by one
        // Then we will use running sum in which we will add the next index value to the perv index value
        int n = s.length();
        int[] diff = new int[n+1];
        // Record the Diff
        for(int i=0; i<roll.length; i++) {
            diff[0]++;
            diff[roll[i]]--;
        }
        StringBuilder ans = new StringBuilder();
        int count = 0;
        // Calculate the running sum
        for(int i=0; i<n; i++) {
            // Defining the running sum
            count += diff[i];
            int shift = count % 26;     // Only to confirf that count shouldn't exceed to 26
            char ch = s.charAt(i);
            char update = (char) ('a'+(ch - 'a' + shift) % 26);
            // (ch - 'a' + shift) % 26 it use to calculate the new position of the character in the alphabet 
            // after applying the shift. It also ensures that the position stays between 0 and 25, 
            // so the character wraps around from z to a.
            ans.append(update);
        }
        return ans.toString();
    }
}