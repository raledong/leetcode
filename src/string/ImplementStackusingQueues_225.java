package string;

import java.util.LinkedList;

/**
 * @author rale
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * Notes:
 * You must use only standard operations of a queue -- 
 * which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplementStackusingQueues_225 {

	LinkedList<Integer> queue1 = new LinkedList<Integer>();
	LinkedList<Integer> queue2 = new LinkedList<Integer>();
	
	/** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty()){
        	queue2.offer(x);
        }else{
        	queue1.offer(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int top = 0;
        if(queue1.isEmpty()){
        	while(queue2.size() > 1){
        		top = queue2.poll();
        		queue1.offer(top);
        	}
        	top = queue2.poll();
        }else{
        	while(queue1.size() > 1){
        		top = queue1.poll();
        		queue2.offer(top);
        	}
        	top = queue1.poll();
        }
        return top;
    }
    
    /** Get the top element. */
    public int top() {
    	int top = 0;
        if(queue1.isEmpty()){
        	while(!queue2.isEmpty()){
        		top = queue2.poll();
        		queue1.offer(top);
        	}
        }else{
        	while(!queue1.isEmpty()){
        		top = queue1.poll();
        		queue2.offer(top);
        	}
        }
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return queue1.isEmpty() && queue2.isEmpty();
    }
    
}
        
