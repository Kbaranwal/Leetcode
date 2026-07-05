class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0, right = n - 1;
        int pos = n - 1;   // ans array ko end se fill karenge

        while(left <= right){
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if(leftSq > rightSq){
                ans[pos] = leftSq;
                left++;
            } else {
                ans[pos] = rightSq;
                right--;
            }
            pos--;
        }
        return ans;
    }
}