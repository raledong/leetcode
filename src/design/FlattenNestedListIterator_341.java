package design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rale
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * 
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * 
 * Example 2:
 * Given the list [1,[4,[6]]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */
public class FlattenNestedListIterator_341 implements Iterator<Integer>{

		private List<NestedInteger> nestedList;
		private Iterator<Integer> iterator;
		private int next;
		private int index;
		public FlattenNestedListIterator_341(List<NestedInteger> nestedList){
			this.nestedList = nestedList;
		}
		
	 	@Override
	    public Integer next() {
	 		return next;
	    }

	    @Override
	    public boolean hasNext() {
	    	if(iterator != null && iterator.hasNext()){
	    		this.next = iterator.next();
	    		return true;
	    	}
	    	
	    	if(index>=nestedList.size()){
	    		return false;
	    	}
	    	
	    	NestedInteger n = nestedList.get(index++);
	    	if(n.isInteger()){
	    		next = n.getInteger();
	    	}else{
	    		iterator = new FlattenNestedListIterator_341(n.getList());
	    		if(iterator.hasNext()){
	    			next = iterator.next();
	    		}else{
	    			return hasNext();
	    		}
	    	}
	        return true;
	    }
}
