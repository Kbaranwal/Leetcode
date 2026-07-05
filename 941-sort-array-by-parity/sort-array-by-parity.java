class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int left=0,right=n-1;
        while(left<right){
            if(nums[left]%2!=0 && nums[right]%2==0){
                swap(nums,left,right);
            }
            if(nums[left]%2==0){
                left++;
            }
            if(nums[right]%2!=0){
                right--;
            }
        }
        return nums;
    }
    static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}