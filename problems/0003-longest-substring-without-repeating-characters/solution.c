
int getLength(char* s) {
    int i = 0;
    while(s[i++] != '\0') {
    }
    return i - 1;
}

int min(int x, int y) {
    return x < y ? x : y;
}

int lengthOfLongestSubstring(char * s){
    if (s[0] == '\0') {
        return 0;
    }
    
    int l = getLength(s);
    int index[UCHAR_MAX];
    int max[l];
    memset(index, -1, UCHAR_MAX*sizeof(int));
    memset(max, 0, l*sizeof(int));
    index[s[0]] = 0;
    max[0] = 1;
    int max_ = 1;
    
    for(int i=1;i<l;i++) {
        if (index[s[i]] != -1) {
            max[i] = min(i - index[s[i]], 1 + max[i-1]);
        } else {
            max[i] = max[i-1] + 1;
        }
        max_ = max_ < max[i] ? max[i] : max_;
        index[s[i]] = i;
    }
    return max_;
}
