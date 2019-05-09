package code;
/*
 * 406. Queue Reconstruction by Height
 * 题意：队列重构，每个元素有两个值，一个是身高，一个是他前边有几个比他高的，相同身高也算比他高
 * 难度：Medium
 * 分类：Greedy
 * 思路：每次把当前最高身高的挑出来，按第二个值排序插进来
 *      E.g.
 *      input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *      subarray after step 1: [[7,0], [7,1]]
 *      subarray after step 2: [[7,0], [6,1], [7,1]]
 * Tips：看下别人的代码，写的很简洁。注意相关的接口和方法。
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class lc406 {
    
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b){
                //如果身高相同，按照升序排
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }else{ //如果身高不同，按照身高 降序排
                    return b[0] - a[0];
                }
            }
        });
        
        //K值定义为 排在h前面且身高大于或等于h的人数 
        //因为从身高降序开始插入，此时所有人身高都大于等于h
        //因此K值即为需要插入的位置
        List<int[]> res = new ArrayList();
        
        for(int[] c : people){
            res.add(c[1],c);
        }
        
        return res.toArray(new int[res.size()][]);
    }
    
    
    
    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        reconstructQueue(people);
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];       //按身高降序排序，如果身高相同，则按前边有几个人增序排序
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);    //用于在列表的指定位置插入指定元素，并将当前处于该位置的元素及其后续元素的索引加1
        }
        return res.toArray(new int[people.length][]);   //list转array,需要传入一个array对象
    }
}
