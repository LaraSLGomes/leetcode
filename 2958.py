class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        d={}
        x=0
        maxi=0
        for y in range(len(nums)):
            d[nums[y]]=d.get(nums[y],0)+1
            while d[nums[y]]>k:
                d[nums[x]]-=1
                x+=1
            maxi=max(maxi,y-x+1)
        return maxi
        