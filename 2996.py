class Solution:
    def missingInteger(self, nums: List[int]) -> int:
        
        ans = nums[0]

        for n1, n2 in pairwise(nums):

            if n2 - n1 == 1:  ans+= n2
            else: break
        
        while ans in nums:  ans+= 1

        return ans