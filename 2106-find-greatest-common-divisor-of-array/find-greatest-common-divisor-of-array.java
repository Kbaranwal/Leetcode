class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        return gcd(max, min);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}