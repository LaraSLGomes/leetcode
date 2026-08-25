class Solution {

    public int missingMultiple(int[] nums, int k) {
        boolean[] contains = new boolean[101];

        for (int ele : nums) {
            contains[ele] = true;
        }

        int ans = k;

        while (ans <= 100 && contains[ans]) {
            ans += k;
        }

        return ans;
    }
}