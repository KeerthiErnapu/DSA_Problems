//lps approach
class Solution {
    public static int minChar(String s) {
        // Write your code here
        StringBuilder sb=new StringBuilder(s);
        sb.reverse().toString();
        StringBuilder res=new StringBuilder(s);
        res.append('$');
        res.append(sb);
        int[] lps=new int[res.length()];
        int pre=0,suf=1;
        lps[pre]=0;
        while(suf<res.length()){
            if(res.charAt(pre)==res.charAt(suf)){
                lps[suf]=pre+1;
                suf++;
                pre++;
            }
            else{
                if(pre==0){
                    lps[suf]=0;
                    suf++;
                    
                }
                else{
                    pre=lps[pre-1];
                    
                }
            }
        }
        return s.length()-lps[res.length()-1];
    }
}
