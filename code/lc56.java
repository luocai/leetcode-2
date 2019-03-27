package code;
/*
 * 56. Merge Intervals
 * 题意：区间合并
 * 难度：Medium
 * 分类：Array, Sort
 * 思路：排序以后，遍历一遍就可以了
 * Tips：对象的排序问题，转化为了数组，再把数组排序; java8可以用类似lambda表达式的方式排序; Collection实现Comparator排序
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc56 {

//    Collection.sort
/*    Collections.sort(intervals, new Comparator<Interval>(){
        @Override
        public int compare(Interval obj0, Interval obj1) {
            return obj0.start - obj1.start;
        }
    });*/

//    lambda 表达式
//    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

        
          // 先按第一位排序，然后合并操作（）
          public List<Interval> merge(List<Interval> intervals) {
        
		Collections.sort(intervals, new Comparetor());
		
		for(int i = 0; i < intervals.size() -1; ){
			
			if(intervals.get(i+1).start <= intervals.get(i).end){
				
				int end ;
				if(intervals.get(i+1).end >= intervals.get(i).end){
					end = intervals.get(i+1).end;
				}else{
					end = intervals.get(i).end;
				}
				
				intervals.remove(i+1);
				intervals.get(i).end = end;
			}else{
				i++;
			}
			
		}
		
		return intervals;
    }
	//比较器，按照第一位排序
	class Comparetor implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			
			return o1.start - o2.start;
		}
		
	}
        
        
        
        
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList();
        if(intervals.size()==0)
            return res;
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for (int i = 0; i < intervals.size() ; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 1; i < starts.length ; i++) {  //注意下这里的操作
            if(starts[i]<=ends[i-1]){
                starts[i] = starts[i-1];
            }else{
                res.add(new Interval(starts[i-1],ends[i-1]));
            }
        }
        res.add(new Interval(starts[starts.length-1],ends[starts.length-1]));   //把最后一个区间也加上
        return res;
    }
}
