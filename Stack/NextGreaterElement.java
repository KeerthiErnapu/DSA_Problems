class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int[] temp=new int[arr.length];
        Arrays.fill(temp,-1);
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                temp[st.pop()]=arr[i];
                
            }
            st.push(i);
        }
        ArrayList<Integer> num=new ArrayList<>();
        for(int i=0;i<temp.length;i++){
            num.add(temp[i]);
        }
        return num;
    }
}
