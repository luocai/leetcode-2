package code;
import java.util.List;
import java.util.Vector;
/*
 * 17. Letter Combinations of a Phone Number
 * 题意：手机键盘字母输入
 * 难度：Medium
 * 思路：思路记一下，每次放到vector中，遍历vector,加上所有的可能
 * 分类：String, Backtracking
 */
public class lc17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23").toString());
    }
    
    //递归的做法
    public List<String> letterCombinations(String digits) {
		
		List<String> result = new ArrayList<>();
		
		if (digits.length() == 0){
			return result;
		}
		
		String[] arr= {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		
		String res = "";
		
			
		
		solve(res, 0, arr, digits, result);
		
		
		
		return result;
		
		
    }
	
	public void solve(String res, int index,String[] arr,String digits,List<String> result){
		if(index == digits.length()){
			result.add(res);
			return ;
		}
		
        //分支
		for(int i = 0; i < arr[digits.charAt(index)-'0'-2].length(); i++){
			solve(res + arr[digits.charAt(index)-'0'-2].charAt(i),index+1,arr,digits,result);
		}
	}

    
    //非递归
    public static List<String> letterCombinations(String digits) {
        Vector<String> res = new Vector<>();
        if(digits.length()==0)
            return res;
        String[] charmap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int n = digits.charAt(i)-'0';
            Vector<String> temp_res = new Vector<>();
            for (int j = 0; j < charmap[n].length(); j++) {
                for (int k = 0; k < res.size(); k++) {
                    temp_res.add(res.get(k)+charmap[n].charAt(j));
                }
            }

            res = temp_res;
        }
        return res;
    }
}
