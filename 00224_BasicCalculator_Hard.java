/*Given a string s representing an expression, implement a basic calculator to evaluate it.
  Example 1:
Input: s = "1 + 1"
Output: 2
Example 2:
Input: s = " 2-1 + 2 "
Output: 3
Example 3:
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
  Constraints:
1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.*/ 
class Solution {
    public static int calculate(String s) {
        StringBuilder currStr = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(currStr);
                currStr = new StringBuilder();
            }
            else if(s.charAt(i) == ')') {
                int tmp = basicCalculate(currStr.toString());
                currStr = stack.pop();
                currStr.append(Integer.toString(tmp));
            }
            else {
                currStr.append(s.charAt(i));
            }
        }
        return basicCalculate(currStr.toString());
    }
    
    public static int basicCalculate(String s) {
        s = s.replaceAll("\\s","");
        s = s.replaceAll("--","+");
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
            if (tmp.length() == 0) continue;
            
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
