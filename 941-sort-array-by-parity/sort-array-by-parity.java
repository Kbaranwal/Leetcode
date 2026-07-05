class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int[] ans = new int[nums.length];

        int e = 0;
        int o = nums.length - 1;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] % 2 == 0){
                ans[e] = nums[i];
                e++;
            }else{
                ans[o] = nums[i];
                o--;
            }
        }

        return ans;
    }
}