package code;
/*
 * 38. Count and Say
 * 题意：初始输出为1，后续输出为上次输出的读法，求第n次的读法
 * 难度：Easy
 * 分类：String
 * 注意：题意很难懂，读懂题意了就简单了
 */
public class lc38 {
    
    public String countAndSay(int n) {
        
        String r = "1";
        for(int i = 2; i <= n; i++){
            
            r = getNext(r);
            System.out.println(r);
        }
        return r;
    }
    
    public String getNext(String n){
        
        char v = n.charAt(0);
        int c = 1;
        
        String res = "";
        
        for(int i = 1 ;i < n.length() ;i++){
            
            if(n.charAt(i) != v){
                
                res = res + String.valueOf(c) + v;
                v = n.charAt(i);
                c = 1;
            }else{
                c++;
            }
            
        }
        
        res = res + String.valueOf(c) + v;
        return res;
    }
    
    ---------------------
        
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String temp = "1";
        while(n>1){
            temp = Say(temp);
            n--;
        }
        return temp;
    }

    public static String Say(String str){
        char[] chars = str.toCharArray();
        StringBuilder res = new StringBuilder();
        int sum =0;
        char pre = chars[0];
        for (int i = 0; i < chars.length ; i++) {
            if(chars[i]==pre)
                sum++;
            else{
                res.append(sum);
                res.append(pre);
                sum = 1;
                pre = chars[i];
            }
            if(i==chars.length-1){  //注意到字符末尾后要添加一次，因为不会再循环了
                res.append(sum);
                res.append(pre);
            }
        }
        return res.toString();
    }
}
