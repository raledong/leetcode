package tree;

/**
 * @author rale
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.

For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII_117 {
	public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        TreeLinkNode prev = null;
        TreeLinkNode nextHead = null;
        while(head!=null){
            while(head!=null){
            	if(head.left!=null){
            		if(prev!=null){
            			prev.next = head.left;
            		}else{
            			nextHead = head.left;
            		}
                	prev = head.left ;
                }
                if(head.right!=null){
                	if(prev!=null){
            			prev.next = head.right;
            		}else{
            			nextHead = head.right;
            		}
                	prev = head.right ;
                }
                head = head.next;
            }
            head = nextHead;
            prev = null;
            nextHead = null;
        }
    }
}
