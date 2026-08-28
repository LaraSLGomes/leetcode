impl Solution {
    pub fn lex_palindromic_permutation(s: String, target: String) -> String {
        let mut freq = [0i32; 26];
        for b in s.bytes() {
            freq[(b - b'a') as usize] += 1;
        }

        let check = |f: &[i32; 26]| -> bool {
            for &v in f {
                if v < 0 {
                    return false;
                }
            }
            true
        };

        let mut cent = 0u8;
        for i in 0..26 {
            if freq[i] % 2 != 0 {
                if cent != 0 {
                    return "".to_string();
                }
                cent = b'a' + i as u8;
                freq[i] -= 1;
            }
        }

        let sz = s.len();
        let half = sz / 2;
        let target_bytes = target.as_bytes();

        for i in 0..half {
            freq[(target_bytes[i] - b'a') as usize] -= 2;
        }

        if check(&freq) {
            let head = &target[..half];
            let rev: String = head.chars().rev().collect();
            let mut tail = String::new();
            if cent != 0 {
                tail.push(cent as char);
            }
            tail.push_str(&rev);
            if tail > target[half..] {
                return head.to_string() + &tail;
            }
        }

        for i in (0..half).rev() {
            let w = target_bytes[i] - b'a';
            freq[w as usize] += 2;
            if !check(&freq) {
                continue;
            }

            for j in (w as usize + 1)..26 {
                if freq[j] == 0 {
                    continue;
                }
                freq[j] -= 2;

                let mut res = Vec::from(&target_bytes[..=i]);
                res[i] = b'a' + j as u8;

                for k in 0..26 {
                    let cnt = freq[k] / 2;
                    for _ in 0..cnt {
                        res.push(b'a' + k as u8);
                    }
                }

                let mut part = res.clone();
                part.reverse();

                if cent != 0 {
                    res.push(cent);
                }
                res.extend(part);

                return String::from_utf8(res).unwrap();
            }
        }

        "".to_string()
    }
}