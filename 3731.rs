impl Solution {
    pub fn find_missing_elements(nums: Vec<i32>) -> Vec<i32> {
    (*nums.iter().min().unwrap()..=*nums.iter().max().unwrap())
        .filter(|x| !nums.contains(x))
        .collect()
    }
}