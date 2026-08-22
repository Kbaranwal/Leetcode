class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int prod=1;
        int original=n;
        while(n!=0){
            int digit=n%10;
            sum=sum+digit;
            prod=prod*digit;
            n/=10;
        }
        return original%(sum+prod)==0;
    }
}