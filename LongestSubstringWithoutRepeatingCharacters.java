class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Set<Character> arr=new HashSet<>();
        int first=0,second=0,l=0;
        while(second<s.length()){
            char c=s.charAt(second);
            while(arr.contains(c)){
                arr.remove(s.charAt(first));
                    first++;
            }
            arr.add(c);
            l=Math.max(l,(second-first+1));
            second++;
        }
        return l;
    }
}
