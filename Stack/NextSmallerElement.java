public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> arr1=new ArrayList<>();
        int[] arr=new int[A.size()];
        Arrays.fill(arr,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=A.size()-1;i>=0;i--){
            while(!st.isEmpty() && A.get(st.peek())>A.get(i)){
                arr[st.pop()]=A.get(i);
            }
            st.push(i);
        }
        for(int i=0;i<A.size();i++){
            arr1.add(arr[i]);
        }
        return arr1;
        
    }
}
