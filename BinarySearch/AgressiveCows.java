class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n=stalls.length;
        int s=1,end=stalls[n-1]-stalls[0];
        int ans=-1;
        while(s<=end){
            int mid=s+(end-s)/2;
            int c=1,pos=stalls[0];
            for(int i=1;i<n;i++){
                if(pos+mid<=stalls[i]){
                    c++;
                    pos=stalls[i];
                }
            }
            if(c<k){
                end=mid-1;
            }
            else{
                ans=mid;
                s=mid+1;
            }
        }
        return ans;
    }
}
