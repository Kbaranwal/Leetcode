class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n*n+1];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length;j++){
                freq[grid[i][j]]++;
            }
        }
        int repeated=-1;
        int missing=-1;
        for(int num=1;num<=n*n;num++){
            if(freq[num]==2){
                repeated=num;
            }if(freq[num]==0){
                missing=num;
            }
        }
        return new int[]{repeated,missing};
    }
}