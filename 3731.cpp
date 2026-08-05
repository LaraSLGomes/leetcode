#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        auto seen = nums | std::views::all | std::ranges::to<unordered_set<int>>();
        auto [minval, maxval] =ranges::minmax(nums);
        
        return views::iota(minval,maxval+1)
                |views::filter([&](int i) {return !seen.count(i);})
                |ranges::to<vector<int>>();
    }
};