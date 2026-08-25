class Solution:
    def missingMultiple(self, nums, k):
        contains = [False] * 101

        for ele in nums:
            contains[ele] = True

        ans = k

        while ans <= 100 and contains[ans]:
            ans += k

        return ans