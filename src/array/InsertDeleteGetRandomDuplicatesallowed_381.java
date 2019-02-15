package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rale
 * Design a data structure that supports all following operations in average O(1) time.
 * 
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 * 
 * Example:
 * 
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 * 
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 * 
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 * 
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 * 
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 * 
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 * 
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 */
public class InsertDeleteGetRandomDuplicatesallowed_381 {
	private List<Pair> list;
	private Map<Integer, List<Integer>> index;
	 /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public InsertDeleteGetRandomDuplicatesallowed_381() {
		list = new ArrayList<>();
		index = new HashMap<>();
	}
    public boolean insert(int val) {
    	boolean contains = true;
    	if(!index.containsKey(val) || index.get(val).isEmpty()) {
    		contains = false;
    	}
    	
    	List<Integer> tmp = index.getOrDefault(val, new ArrayList<>());
    	tmp.add(list.size());
    	index.put(val, tmp);

    	list.add(new Pair(val,  tmp.size()-1));
    	return !contains;
    	
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!index.containsKey(val) || index.get(val).isEmpty()) {
        	return false;
        }
        List<Integer> tmp = index.get(val);
        int position = tmp.remove(tmp.size()-1);
        if(position != list.size()-1) {
        	Pair lastPair = list.get(list.size()-1);
        	int lastValue = lastPair.value;        	
        	List<Integer> lastValuePositions = index.get(lastValue);
        	lastValuePositions.set(lastPair.position, position);
        	list.set(position, lastPair);
        }
        list.remove(list.size()-1);
        return true;
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	int position = (int)Math.floor((Math.random() * list.size()));
        return list.get(position).value;
    }
    
    public static class Pair{
    	int value;
    	int position;
    	
    	public Pair(int value, int position) {
    		this.value = value;
    		this.position = position;
    	}
    }
    public static void main(String[] args) {
    	InsertDeleteGetRandomDuplicatesallowed_381 i = new InsertDeleteGetRandomDuplicatesallowed_381();
    	i.insert(4);
    	i.insert(3);
    	i.insert(4);
    	i.insert(2);
    	i.insert(4);
    	i.remove(4);
    	i.remove(3);
    	i.remove(4);
    	i.remove(4);
    }
}
