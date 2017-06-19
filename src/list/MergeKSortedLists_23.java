package list;


/**
 * @author rale
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists_23 {
	
	//divide and conquer
	 public ListNode mergeKLists2(ListNode[] lists){
		    return partion(lists,0,lists.length-1);
		}

		public static ListNode partion(ListNode[] lists,int s,int e){
		    if(s==e)  return lists[s];
		    if(s<e){
		        int q=(s+e)/2;
		        ListNode l1=partion(lists,s,q);
		        ListNode l2=partion(lists,q+1,e);
		        return merge(l1,l2);
		    }else
		        return null;
		}

		//This function is from Merge Two Sorted Lists.
		public static ListNode merge(ListNode l1,ListNode l2){
		    if(l1==null) return l2;
		    if(l2==null) return l1;
		    if(l1.val<l2.val){
		        l1.next=merge(l1.next,l2);
		        return l1;
		    }else{
		        l2.next=merge(l1,l2.next);
		        return l2;
		    }
		}
	
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){ val = x;}
	}
	
	public static void main(String[] args){
		MergeKSortedLists_23 m = new MergeKSortedLists_23();
	}

}
