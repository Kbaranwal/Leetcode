class Solution {
    public long sumAndMultiply(int n) {
        long x = 0, sum = 0;
        long place = 1;
        while(n>0){
            int digit = n%10;
            sum+=digit;
            if(digit!=0){
                x+=digit*place;
                place*=10;
            }
            n/=10;
        }
        return x*sum;

    }
}