package other;

/**
 * @author rale
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 */
public class PalindromeNumber_9 {
	//双指针，将左右指针分别指向数字的首位
	public boolean isPalindrome(int x) {
		if(x<0 || (x%10==0&&x!=0)){
			return false;
		}
		int rightPointer = 0;
		while(Math.pow(10, rightPointer)<=x){
			rightPointer++;
		}
		rightPointer--;
        int leftPointer = 0;
        while(rightPointer>leftPointer){
        	int left = (int) (x/Math.pow(10, leftPointer)%10);
        	int right = (int) (x/(Math.pow(10, rightPointer))%10);
        	leftPointer++;
        	rightPointer--;
        	if(left!=right){
        		return false;
        	}
        }
        return true;
    }
	
	public boolean isPalindrome2(int x) {
		if(x<0 || (x%10==0&&x!=0)){
			return false;
		}
		int res = 0;
		while(x>res){
			res = res*10 + (x%10);
			x /= 10;
		}
		return (x==res || x==(res/10));
	}
	
	public static void main(String[] args){
		PalindromeNumber_9 p = new PalindromeNumber_9();
		p.isPalindrome2(1222221);
	}
}
