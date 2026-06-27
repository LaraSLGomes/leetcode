class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long val = nums[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int ans = 1;

        if (map.containsKey((long)1)) {
            int f = map.get((long)1);
            if (f % 2 == 0) {
                ans = Math.max(ans, f - 1);
            } else {
                ans = Math.max(ans, f);
            }
        }

        ArrayList<Long> keys = new ArrayList<>(map.keySet());

        for (int i = 0; i < keys.size(); i++) {

            long cur = keys.get(i);

            if (cur == (long)1) {
                continue;
            }

            long temp = cur;
            int len = 0;

            while (true) {

                if (!map.containsKey(temp) || map.get(temp) < 2) {
                    break;
                }

                len += 2;
                temp = temp * temp;
            }

            if (map.containsKey(temp) && map.get(temp) == 1) {
                len++;
            } else {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
