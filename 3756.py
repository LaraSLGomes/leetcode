class Solution:
    MOD = 10**9 + 7

    def power(self, a: int, b: int) -> int:
        res = 1
        while b:
            if b & 1:
                res = (res * a) % self.MOD
            a = (a * a) % self.MOD
            b >>= 1
        return res

    def sumAndMultiply(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)

        prefSum = [0] * n

        prefNonZeroNum = [0] * n

        prefNonZeroCnt = [0] * n

        for i in range(n):
            digit = int(s[i])

            if i:
                prefSum[i] = prefSum[i - 1]
                prefNonZeroNum[i] = prefNonZeroNum[i - 1]
                prefNonZeroCnt[i] = prefNonZeroCnt[i - 1]

            if digit:
                prefSum[i] = (prefSum[i] + digit) % self.MOD

                prefNonZeroCnt[i] += 1

                prefNonZeroNum[i] = (prefNonZeroNum[i] * 10 + digit) % self.MOD

        ans = []

        for l, r in queries:
            total = prefSum[r] - (prefSum[l - 1] if l else 0)
            total = (total % self.MOD + self.MOD) % self.MOD

            cnt = prefNonZeroCnt[r] - (prefNonZeroCnt[l - 1] if l else 0)

            num = prefNonZeroNum[r] - (
                (prefNonZeroNum[l - 1] * self.power(10, cnt)) % self.MOD if l else 0
            )
            num = (num % self.MOD + self.MOD) % self.MOD

            ans.append((num * total) % self.MOD)

        return ans