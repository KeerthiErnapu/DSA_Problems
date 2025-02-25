import java.util.HashMap;

class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> h = new HashMap<>();
        h.put(1, "I");
        h.put(2, "II");
        h.put(3, "III");
        h.put(4, "IV");
        h.put(5, "V");
        h.put(6, "VI");
        h.put(7, "VII");
        h.put(8, "VIII");
        h.put(9, "IX");
        h.put(10, "X");
        h.put(20, "XX");
        h.put(30, "XXX");
        h.put(40, "XL");
        h.put(50, "L");
        h.put(60, "LX");
        h.put(70, "LXX");
        h.put(80, "LXXX");
        h.put(90, "XC");
        h.put(100, "C");
        h.put(200, "CC");
        h.put(300, "CCC");
        h.put(400, "CD");
        h.put(500, "D");
        h.put(600, "DC");
        h.put(700, "DCC");
        h.put(800, "DCCC");
        h.put(900, "CM");
        h.put(1000, "M");
        h.put(2000, "MM");
        h.put(3000, "MMM");

        // StringBuilder for efficient string concatenation
        StringBuilder sb = new StringBuilder();

        // Step 1: Find number of digits (n)
        int n = (int) Math.log10(num) + 1;

        // Step 2: Extract digits from left to right
        int s = num;
        int divisor = (int) Math.pow(10, n - 1);  // Find highest place value

        while (divisor > 0) {
            int digitValue = (s / divisor) * divisor;  // Extract leftmost digit place
            if (h.containsKey(digitValue)) {
                sb.append(h.get(digitValue));  // Append corresponding Roman numeral
            }
            s %= divisor;  // Remove the leftmost digit
            divisor /= 10;  // Reduce divisor
        }

        return sb.toString();  // Return final Roman numeral string
    }

   
}
