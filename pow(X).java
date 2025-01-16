class Solution {
    public double myPow(double x, int n) {
       long a = Math.abs((long) n);
       double res=Math.pow(x,a);
        
        if(n>0){
            return res;
        }
        else{
            return 1/res;
        }
    }
}
