/*Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
  Example 1:
Input: s = "3+2*2"
Output: 7
Example 2:
Input: s = " 3/2 "
Output: 1
Example 3:
Input: s = " 3+5 / 2 "
Output: 5
  Constraints:
1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.*/ 
class Solution {
    public static int calculate(String s) {
        s = s.replaceAll("\\s","");
        Stack<StringBuilder> expr = new Stack<>(); 
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) == '+') {
                expr.push(tmp);
                tmp = new StringBuilder();
            }
            else if(s.charAt(i) == '-') {
                expr.push(tmp);
                tmp = new StringBuilder();
                tmp.append('-');
            }
            else {
                tmp.append(s.charAt(i));
            }
                
        }
        if (tmp.length() > 0)
            expr.push(tmp);
        int ans = 0;
        while(!expr.isEmpty()) {
            tmp = expr.pop();
            int tmpCalc = 0;
            int currNum = 0;
            StringBuilder tmpNum = new StringBuilder();
            char operator = '0';
            for(int i = 0; i < tmp.length(); i++) {
                char c = tmp.charAt(i);
                if (c == '*' || c == '/') {
                    currNum = Integer.parseInt(tmpNum.toString());
                    if(operator == '0') {
                        tmpCalc = currNum;
                    }
                    else {
                        if (operator == '*')
                            tmpCalc *= currNum;
                        if (operator == '/')
                            tmpCalc /= currNum;
                    }
                    tmpNum = new StringBuilder();
                    operator = c;
                }
                else {
                    tmpNum.append(c);
                }
            }
            currNum = Integer.parseInt(tmpNum.toString());
            if(operator == '0')
                tmpCalc = currNum;
            if (operator == '*')
                tmpCalc *= currNum;
            if (operator == '/')
                tmpCalc /= currNum;

            ans += tmpCalc;
        }
        return ans;
    }
}
