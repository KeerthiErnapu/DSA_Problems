class Solution {
    public int romanToInt(String s) {
         HashMap<Character,Integer> h=new HashMap<>();
        h.put('I',1);
        h.put('V',5);
        h.put('X',10);
        h.put('L',50);
        h.put('C',100);
        h.put('D',500);
        h.put('M',1000);
        int sum=0,i;
        for(i=0;i<s.length()-1;i++){
            if(h.get(s.charAt(i))>=h.get(s.charAt(i+1))){
                sum=sum+h.get(s.charAt(i));
            }
            else{
                sum=sum-h.get(s.charAt(i));
            }
        }
        sum+=h.get(s.charAt(i));
        return sum;
    }
}
