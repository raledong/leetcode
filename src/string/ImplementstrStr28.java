package string;


/**
 * @author rale
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementstrStr28 {

	public int strStr(String haystack, String needle) {
		int haystackLength = haystack.length();
        int needleLength = needle.length();
        if(haystackLength<needleLength){
        	return -1;
        }else if(needleLength==0){
        	return 0;
        }
		char start = needle.charAt(0);
        int index = haystack.indexOf(start);
        while(index!=-1){
        	if(index+needleLength>haystackLength){
        		index = -1;
        		break;
        	}
        	if(haystack.substring(index).startsWith(needle)){
        		break;
        	}
        	int tempIndex = haystack.substring(index+1).indexOf(start);
        	index = tempIndex==-1?-1:(tempIndex+index+1);
        }
        return index;
    }
	
	//更简洁
	public int strStr2(String haystack, String needle){
		int index = 0;
		for( ; index+needle.length()<=haystack.length() ; index++){
			if(haystack.substring(index).startsWith(needle)){
				return index;
			}
		}
		if(index+needle.length()==haystack.length()){
			index = -1;
		}
		return index;
	}
	
	public int strStr3(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
	public static void main(String[] args){
		ImplementstrStr28 i = new ImplementstrStr28();
		i.strStr("mississippi", "issip");
	}
}
