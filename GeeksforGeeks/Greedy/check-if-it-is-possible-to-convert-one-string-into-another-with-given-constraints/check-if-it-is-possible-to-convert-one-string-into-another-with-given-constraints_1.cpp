class Solution {
    public boolean isItPossible(String s1, String s2) {
        // code here
        // in this there is important point that is as we found "A" in s1 then in s2 it should be left side of index
        // And for the"B" we will move towards right side of the index 
        // And to skip the "#" we will use while loop
        int i = 0;
        int j = 0;
        int n = s1.length();
        if(s1.length() != s2.length()) {
            return false;
        }
        while(i<n && j <n) {
            // to remove the index for the "#" in s1
            while(i<n && s1.charAt(i) == '#') {
                i++;
            }
            // to remove the index for the "#" in s2
            while(j<n && s2.charAt(j) == '#') {
                j++;
            }
            // If one string has no more A/B characters
            if(i == n || j == n) {
                return i==n && j==n;
            }
            // The characters must appear in the same order
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            // To check the position of "A" in s2 as compare to s1
            if(s1.charAt(i) == 'A' && j>i) {
                return false;
            }
            // To check the position of "B" in s2 as compare to s1
            if(s1.charAt(i) == 'B' && j<i) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
};