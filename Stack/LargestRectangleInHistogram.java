class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> st=new Stack<>();
        int[] right=new int[height.length];
        int[] left=new int[height.length];
        Arrays.fill(left,-1);
        for(int i=0;i<height.length;i++){
            while(!st.isEmpty() && height[st.peek()]>height[i]){
                right[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            right[st.pop()]=height.length;
        }
        for(int i=height.length-1;i>=0;i--){
            while(!st.isEmpty() && height[st.peek()]>height[i]){
                left[st.pop()]=i;
            }
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<left.length;i++){
            ans=Math.max(ans,height[i]*(right[i]-left[i]-1));
        }
        return ans;

    }
}
