class Solution
    def countCommas(n)
        count = 0

        (1..n).each do |i|
            count += 1 if i >= 1000
        end

        count
    end
end