package code;
/*
 * 394. Decode String
 * 题意：解码字符串
 * 难度：Medium
 * 分类：Stack, Depth-first Search
 * 思路：用栈
 * Tips：可以用两个栈，一个字符串入栈，而不是字符入栈，另一个数字入栈。提高运行速度，不用重复遍历字符。
 */
import java.util.Stack;

public class lc394 {
    
    // 栈
     public String decodeString(String s) {
        
        LinkedList<String> stack = new LinkedList();
        
        // 特别注意字符串操作的顺序   count = stack.pop() + count 和 count = count + stack.pop()
        for(int i = 0; i < s.length() ; i++){
            
            if(s.charAt(i) == ']'){
                
                String str = "";
                //弹弹弹，弹到底
                while(!stack.peek().equals("[")){
                    str = stack.pop() + str;
                }
                
                stack.pop(); // 弹出 [
                
                //计算数字
                String count = "";
                while(!stack.isEmpty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9'){
                    count = stack.pop() + count;
                }
                
                int c = Integer.parseInt(count);
                // 循环，然后放入栈中
                String tar = "";
                for(int j = 0; j < c;j++){
                    tar += str;
                }
                stack.push(tar);
                
            }else{
                stack.push(""+s.charAt(i));
            }
            
        }
        
        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
        
    }
    
    
    
    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
    public static String decodeString(String s) {
        Stack<Character> st = new Stack();
        int i = 0;
        char[] str_arr = s.toCharArray();
        StringBuilder res = new StringBuilder();

        while(i<s.length()){
            if(str_arr[i]==']'){
                StringBuilder temp = new StringBuilder();
                StringBuilder num = new StringBuilder();
                while(st.peek()!='['){
                    temp.insert(0, st.pop());
                }
                st.pop();   // pop出 [
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    num.insert(0, st.pop());
                }
                StringBuilder temp2 = new StringBuilder();
                for (int j = 0; j < Integer.valueOf(num.toString()) ; j++) {
                    temp2.append(temp.toString());
                }
                //入栈
                for (int j = 0; j < temp2.toString().length() ; j++) {
                    st.push(temp2.toString().toCharArray()[j]);
                }
            }else{
                st.push(str_arr[i]);
            }
            i++;
        }
        // 别忘了末尾的
        StringBuilder sb1 = new StringBuilder();
        while(!st.isEmpty()){
            sb1.insert(0, st.pop());
        }
        res.append(sb1);
        return res.toString();
    }
}
