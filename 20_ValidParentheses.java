class Solution {
    public static boolean isValid(String s) {
    	Deque<Character> stack = new ArrayDeque<>();
		
        for(int i =0; i < s.length(); i++){
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
				stack.add(s.charAt(i));
			}
			if (s.charAt(i) == ')'){
				if ( stack.isEmpty() ||stack.pollLast() != '(')
					return false;
			}
			if (s.charAt(i) == '}'){
				if ( stack.isEmpty() || stack.pollLast() != '{')
					return false;
			}
			if (s.charAt(i) == ']'){
				if ( stack.isEmpty() || stack.pollLast() != '[')
					return false;
			}

		}
		if (stack.isEmpty())return true;
		else return false;
    }
}
