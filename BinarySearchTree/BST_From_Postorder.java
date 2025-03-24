class GFG {
    public static Node bst(int[] post, AtomicInteger index, int lower, int upper){
        if(index.get()<0 || lower>post[index.get()] || upper<post[index.get()]){
            return null;
        }
        Node root=new Node(post[index.getAndDecrement()]);
        root.right=bst(post,index,root.data,upper);
        root.left=bst(post,index,lower,root.data);
        return root;
    }
    public static Node constructTree(int post[], int n) {
        AtomicInteger index=new AtomicInteger(n-1);
        int lower=Integer.MIN_VALUE;
        int upper=Integer.MAX_VALUE;
        return bst(post,index,lower,upper);
    }
}
