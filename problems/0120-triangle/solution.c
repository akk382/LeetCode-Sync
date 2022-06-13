
int min(int x, int y) {
    if (x < y) {
        return x;
    } else {
        return y;
    }
}

int minPath(int **triangle, int triangleSize, int* triangleColSize) {
    
    int currRowForMinAggr = triangleSize - 1;
    
    while(currRowForMinAggr > 0) {
        for(int i = 0 ;i < triangleColSize[currRowForMinAggr] - 1; i++) {
            *(*(triangle + currRowForMinAggr) + i) = min(*(*(triangle + currRowForMinAggr) + i), *(*(triangle + currRowForMinAggr) +i+1));
        }
        for(int i=0;i<triangleColSize[currRowForMinAggr - 1];i++) {
            *(*(triangle + currRowForMinAggr - 1) + i) += *(*(triangle + currRowForMinAggr) + i);
        }
        currRowForMinAggr--;
    }
    return *(*(triangle));
}

int minimumTotal(int** triangle, int triangleSize, int* triangleColSize){
    
    if (triangleSize == 1) {
        return triangle[0][0];
    }
    
    return minPath(triangle, triangleSize, triangleColSize);

}
