
int getLength(char* c) {
    int i = 0;
    int len = 0;
    while(c[i++] != '\0') {
        len++;
    }
    return len;
}

int max(int x, int y) {
    return x > y ? x : y;
}

int LCS(char* x, char* y) {
    int l1 = getLength(x);
    int l2 = getLength(y);
    unsigned dp[l1 + 1][l2 + 1];
    for(int i=0;i<=l1;i++) {
        dp[i][0] = 0;
    }
    for(int i=0;i<=l2;i++) {
        dp[0][i] = 0;
    }
    for(int i=1;i<=l1;i++) {
        for(int j=1;j<=l2;j++) {
            if(x[i-1] == y[j-1]) {
                dp[i][j] = 1 + dp[i-1][j-1];
            } else {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    return dp[l1][l2] == 0 ? l1+l2 : l1+l2-2*dp[l1][l2];
}

int minDistance(char * word1, char * word2){
    return LCS(word1, word2);
}
