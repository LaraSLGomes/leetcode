import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int maxSoFar = 0;
  
        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxSoFar);
        }
  
        Arrays.sort(prefixGcd);
   
        long totalSum = 0;
        for (int i = 0; i < n / 2; i++) {
            totalSum += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }
        
        return totalSum;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}