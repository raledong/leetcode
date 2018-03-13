package design;

import java.util.PriorityQueue;

/**
 * @author rale
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
 * So the median is the mean of the two middle value.
 * 
 * Examples: 
 * [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * 
 * For example:
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 */
public class FindMedianfromDataStream_295 {

	private PriorityQueue<Long> minQueue;
	private PriorityQueue<Long> maxQueue;
	/** initialize your data structure here. */
    public FindMedianfromDataStream_295 () {
        minQueue = new PriorityQueue<Long>();
        maxQueue = new PriorityQueue<Long>();
    }
    
    public void addNum(int num) {
        maxQueue.add((long)num);
        minQueue.add(-maxQueue.poll());
        if(maxQueue.size() < minQueue.size()){
        	maxQueue.add(-minQueue.poll());
        }
        
    }
   
    public double findMedian() {
        if(maxQueue.size() > minQueue.size()){
        	return maxQueue.peek();
        }else{
        	return ( maxQueue.peek() - minQueue.peek() ) / 2.0;
        }
    }
    
    public static void main(String[] args){
    	FindMedianfromDataStream_295 f = new FindMedianfromDataStream_295();
    	f.addNum(1);
    	f.addNum(2);
    	System.out.println(f.findMedian());
    	f.addNum(3);
    	System.out.println(f.findMedian());
    }
}
