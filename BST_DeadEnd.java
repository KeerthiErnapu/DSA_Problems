class Solution
{
    public static boolean isDeadEnd(Node root)
    {
        int lower=0;
        int upper=Integer.MAX_VALUE;
        return dead(root,lower,upper);
    }
    public static boolean dead(Node root, int lower, int upper){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            if(root.data-lower==1 && upper-root.data==1){
                return true;
            }
            else{
                return false;
            }
        }
        return dead(root.left,lower,root.data)||
        dead(root.right,root.data,upper);
    }
}
