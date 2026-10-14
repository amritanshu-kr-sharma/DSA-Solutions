class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // In this method we will use greedy method in which we can see that we are not maximizing the num directly while we are maximizing its sum of squred digit
        // Now how to think that which no will come 
        // So we will 1stly prefer 9 in the leftmost side because suppose there is num = 2 then let a & b are two digits and both are +ve and there sum is at most 9
        // then we found there sum of square of it's digit is less than single square value of the 9

        // check that a digit cannot exceed 9
        if(sum > num * 9) {
            return "";
        }
        // Count the no of 9
        int count = sum / 9;
        // Then remaining digits will be
        int rem = sum % 9;

        StringBuilder ans = new StringBuilder();
        // Add as many as 9 comes
        ans.append("9".repeat(count));
        // Add remainder
        if(rem > 0) {
            ans.append(rem);
        }
        // Fill the remaining position with the '0'
        ans.append("0".repeat(num-ans.length()));
        return ans.toString();
    }
}