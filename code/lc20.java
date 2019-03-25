package code;

import java.util.HashMap;
import java.util.Stack;

/*
 * 20. Valid Parentheses
 * 题意：括号匹配
 * 难度：Easy
 * 分类：String, Stack
 */
public class lc20 {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
    
    //用栈
    public boolean isValid(String s) {
      
      if(s.length() == 0)
			return true;
      
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		
		for(int i = 1; i < s.length(); i++){
			
		
			if(!stack.isEmpty() && map.containsKey(stack.peek()) && s.charAt(i) == map.get(stack.peek())){
				stack.pop();
			}else{
				stack.push(s.charAt(i));
			}
		}
		
		if(stack.isEmpty() == true)
			return true;
		else
			return false;
		
	}

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
