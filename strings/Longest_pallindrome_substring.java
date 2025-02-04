class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String str=s.substring(0,1);
        int len=1;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                String st=s.substring(i,j+1);
                String ex=isPallindrome(st);
                if(len<ex.length()){
                    str=ex;
                    len=ex.length();
                }
            }
        }
        return str;
    }
    public String isPallindrome(String a){
        int l=0,r=a.length()-1;
        while(l<r){
            if(a.charAt(l)!=a.charAt(r)){
                return "";
            }
            l++;
            r--;
        }
        return a;

    }
}
