package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals56 {

	public class Interval{
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	//效率低下
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if( intervals.size() == 0){
			return result;
		}
		intervals.sort(new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start < o2.start){
					return -1;
				}else if(o1.start > o2.start){
					return 1;
				}
				
				return 0;
			}	
		});
		
		result.add(intervals.get(0));
		for(int i = 1 ; i<intervals.size() ; i++){
			Interval previous = result.get(result.size()-1);
			Interval temp = intervals.get(i);
			if(temp.start <= previous.end){
				previous.end = temp.end > previous.end ? temp.end : previous.end;
			}else{
				result.add(temp);
			}
		}
        
        return result;
    }
	
	//道理同merge1
	public List<Interval> merge2(List<Interval> intervals) {
	    if (intervals.size() <= 1)
	        return intervals;
	    
	    // Sort by ascending starting point using an anonymous Comparator
	    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
	    
	    List<Interval> result = new LinkedList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
	}
	
	//效率较高，将对象看成两个数组来比较。
	public List<Interval> merge3(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2)
            return intervals;
        List<Interval> res = new ArrayList<>();
        int len = intervals.size();
        int[] starts = new int[len], ends = new int[len];
        for(int i = 0; i < len; i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int start = starts[0], end = ends[0];
        for(int i = 0; i < len - 1; i++){
            if(ends[i] >= starts[i + 1]){
                end = ends[i + 1];
            }
            else{
                end = ends[i];
                res.add(new Interval(start, end));
                start = starts[i + 1];
                end = ends[i + 1];
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
	//高级方法，将题目从另一个更高的角度看待，主要是省去了排序浪费的时间
	public List<Interval> merge4(List<Interval> intervals) {
	       int size = intervals.size();
	        if (size < 2) {
	            return intervals;
	        }
	        
	        List<Interval> result = new ArrayList<Interval>(size);
	        Interval[] array = intervals.toArray(new Interval[size]);
	        
	        for (int f = 0; f < size; f++) {
	            Interval first = array[f];
	            boolean add = true;
	            for (int s = f + 1; s < size; s++) {
	                Interval second = array[s];
	                if (first.end < second.start || first.start > second.end) {
	                    continue;
	                }

	                if (first.start <= second.start) {
	                    second.start = first.start;
	                }
	                if (first.end >= second.end) {
	                    second.end = first.end;
	                }
	                add = false;
	                break;
	            }
	            
	            if (add) {
	                result.add(first);
	            }
	        }
	        return result;
	    }
	
}
