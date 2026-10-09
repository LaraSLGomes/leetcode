var minInsertions = function(s) {
    let st = [];
    let res = 0;

    for(let i = 0; i < s.length; i++) {
        let ch = s[i];

        if(ch === '(') {
            st.push(ch);
        }
        else {
            if(st.length === 0) {
                if(i < s.length - 1 && s[i + 1] === ')') {
                    i++;
                }
                else {
                    res++;
                }
                res++;
            }
            else {
                if(i < s.length - 1 && s[i + 1] === ')') {
                    i++;
                }
                else {
                    res++;
                }
                st.pop();
            }
        }
    }

    return res + st.length * 2;
};