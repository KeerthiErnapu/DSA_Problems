class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        int l=Integer.MAX_VALUE;
        String st="";
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<l){
                l=strs[i].length();
                st=strs[i];
              
            }
        }
        int i=0;
        for(i=0;i<st.length();i++){
            for(int j=0;j<strs.length;j++){
                String str=strs[j];
                if(st.charAt(i)!=str.charAt(i)){
                    return st.substring(0,i);
                }
            }
        }
        return st;
    }
}
