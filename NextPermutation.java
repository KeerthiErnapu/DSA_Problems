class Solution {
    public void nextPermutation(int[] nums) {
        int p=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                p=i;
                break;
            }
        }
        if(p==-1){
            int l=0,r=n-1;
            while(l<r){
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                r--;
                l++;
            }
        }
        else{
            int ng=-1;
            for(int i=n-1;i>p;i--){
                if(nums[i]>nums[p]){
                    ng=i;
                    break;
                }
            }
            int temp=nums[p];
            nums[p]=nums[ng];
            nums[ng]=temp;
            int l=p+1,r=n-1;
            while(l<r){
                int c=nums[l];
                nums[l]=nums[r];
                nums[r]=c;
                l++;
                r--;
            }
        }
        System.out.println(nums);
    }
}
