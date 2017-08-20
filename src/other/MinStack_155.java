package other;

import java.util.LinkedList;

public class MinStack_155 {
	//链表加上最小数值指针的实现，效率很一般
//	private LinkedList<Integer> list;
//	int minPointer;
//	public MinStack_155() {
//        list = new LinkedList<Integer>();
//        minPointer = -1;
//    }
//    
//    public void push(int x) {
//        list.addFirst(x);
//        minPointer++;
//        //更新指针
//        if(x<list.get(minPointer)){
//        	minPointer = 0;
//        }
//    }
//    
//    public void pop() {
//        list.removeFirst();
//        if(minPointer==0 && !list.isEmpty()){
//        	for(int i = 1 ; i<list.size() ; i++){
//        		if(list.get(minPointer) > list.get(i)) minPointer = i;
//        	}
//        }else{
//        	minPointer--;
//        }
//    }
//    
//    public int top() {
//        return list.getFirst();
//    }
//    
//    public int getMin() {
//    	return list.get(minPointer);
//    }
	
	/** initialize your data structure here. */
	MinStackNode head;
    public MinStack_155() {
        head = null;
    }
    
    public void push(int x) {
        if(head==null){
        	head = new MinStackNode(x,x);
        }else{
        	MinStackNode newHead = new MinStackNode(x, Math.min(head.val, x));
        	newHead.next = head;
        	head = newHead;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    class MinStackNode{
    	int min;
    	int val;
    	MinStackNode next;
    	MinStackNode(int val , int min){
    		this.min = min;
    		this.val = val;
    	}
    }
}
