class Solution {
    public int find(int[] inorder,int a,int s,int e){
        for(int i=s;i<=e;i++){
            if(inorder[i]==a){
                return i;
            }
        }
        return -1;
    }
    public TreeNode tree(int[] preorder, int[] inorder,int start,int end,int index){
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(preorder[index]);
        int pos=find(inorder,preorder[index],start,end);
        root.left=tree(preorder,inorder,start,pos-1,index+1);
        root.right=tree(preorder,inorder,pos+1,end,index+(pos-start)+1);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return tree(preorder,inorder,0,inorder.length-1,0);
    }
}
