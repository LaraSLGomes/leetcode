class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        n=len(nums)
        if n<=2:
            return n
        mx=-1
        for i in range(32):
            if n&(1<<i)!=0:
                mx=i
        return 2**(mx+1)