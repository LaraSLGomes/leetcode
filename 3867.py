from math import gcd
from typing import List


class Solution:
    def gcdSum(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0

        prefix_gcd = [0] * n
        max_so_far = 0

        for i, num in enumerate(nums):
            max_so_far = max(max_so_far, num)
            prefix_gcd[i] = gcd(num, max_so_far)

        prefix_gcd.sort()

        total_sum = 0
        for i in range(n // 2):
            total_sum += gcd(prefix_gcd[i], prefix_gcd[-1 - i])

        return total_sum
