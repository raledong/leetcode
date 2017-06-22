package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rale
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval_57 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		int index = 0;
		while(index<intervals.size() && intervals.get(index).end < newInterval.start){
			result.add(intervals.get(index++));
		}
		while(index<intervals.size() && intervals.get(index).start < newInterval.end){
			newInterval.start = Math.min(intervals.get(index).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(index).end, newInterval.end);
			index++;
		}
		result.add(newInterval);
		while(index<intervals.size()){
			result.add(intervals.get(index++));
		}
		return result;
    }
	
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		for(Interval temp : intervals){
			if(newInterval==null || temp.end < newInterval.start){
				result.add(temp);
			}else if(temp.start > newInterval.end){
				result.add(newInterval);
				result.add(temp);
				newInterval = null;
			}else{
				newInterval.start = Math.min(newInterval.start, temp.start);
				newInterval.end = Math.max(newInterval.end, temp.end);
			}
		}
		return result;
	}
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static void main(String[] args){
		InsertInterval_57 i = new InsertInterval_57();
	}
}
