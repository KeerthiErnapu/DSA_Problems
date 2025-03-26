class Solution
{   
    //Function to return a list of BST elements in a given range.
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        ArrayList<Integer> ans=new ArrayList<>();
        find(root,low,high,ans);
        return ans;
    }
    public static void find(Node root, int low, int high, ArrayList<Integer> ans){
        if(root==null){
            return;
        }
        if(root.data>low && root.data>high){
            find(root.left,low,high,ans);
        }
        else if(root.data<low && root.data<high){
            find(root.right,low,high,ans);
        }
        else{
            find(root.left,low,high,ans);
            ans.add(root.data);
            find(root.right,low,high,ans);
        }
    }
    
}
