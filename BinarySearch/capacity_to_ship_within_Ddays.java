class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0,m=Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            m=Math.max(weights[i],m);
            sum+=weights[i];
        }
        int start=m,end=sum;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int d=1,count=0;
            for(int i=0;i<weights.length;i++){
                if(mid>=count+weights[i]){
                    count+=weights[i];
                }
                else{
                    d++;
                    count=weights[i];
                }
            }
            if(d<=days){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}
