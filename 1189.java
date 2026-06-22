class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int[] freq = new int[26];
        for(char c: text.toCharArray()){
            freq[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans, freq ['b' - 'a']);
        ans = Math.min(ans, freq ['a' - 'a']);
        ans = Math.min(ans, freq ['l' - 'a']/2);
        ans = Math.min(ans, freq ['o' - 'a']/2);
        ans = Math.min(ans, freq ['n' - 'a']);

        return ans;
    }
}