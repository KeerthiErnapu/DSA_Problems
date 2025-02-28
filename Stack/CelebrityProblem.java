

//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> st=new Stack<>();
    	for(int i=n-1;i>=0;i--){
    	    st.push(i);
    	}
    	while(st.size()>1){
    	    int a=st.pop();
    	    int b=st.pop();
    	    if(M[a][b]==1 && M[b][a]==0){
    	        st.push(b);
    	    }
    	    if(M[a][b]==0 && M[b][a]==1){
    	        st.push(a);
    	    }
    	}
    	if(st.isEmpty()){
    	    return -1;
    	}
    	int num=st.pop();
    	int rsum=0,csum=0;
    	for(int i=0;i<n;i++){
    	    rsum+=M[num][i];
    	    csum+=M[i][num];
    	}
    	return rsum==0 && csum==n-1?num:-1;    }
}
