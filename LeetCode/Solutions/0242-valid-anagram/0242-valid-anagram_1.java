class Solution {
    public boolean isAnagram(String s, String t) {
        // By using Frequency Array approach
        if(s.length() != t.length()) return false;
        int freq[] = new int[26];       // 26 because there is only 26 alphabet
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i)-'a']++;        // It is increasing the character count
            freq[t.charAt(i)-'a']--;        // It is decreasing the character count
        }
        for(int i=0; i<26; i++) {
            if(freq[i] != 0) return false;  // When character is not equals to 0
        }
        return true;
    }
}