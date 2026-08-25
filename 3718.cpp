class Solution {
public:
    int missingMultiple(vector<int>& nums, int k) {
        vector<bool> contains(101, false);

        for (int ele : nums) {
            contains[ele] = true;
        }

        int ans = k;

        while (ans <= 100 && contains[ans]) {
            ans += k;
        }

        return ans;
    }
};