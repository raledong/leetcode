package sort;

/**
 * @author rale
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class HIndexII_275 {
	
	public int hIndex(int[] citations) {
		int length = citations.length;
		if(length == 0) return 0;
		int left = 0, right = length-1;
		while(left <= right){
			int mid = (left + right) / 2;
			if(citations[mid] == length - mid ){
				return mid;
			}else if(citations[mid] > length - mid){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return length - (right + 1);
    }
}
