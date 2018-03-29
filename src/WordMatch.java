import java.util.ArrayList;
import java.util.List;

public class WordMatch {
	public static List<Integer> findMatch(String text, String pattern){
		int textLength = text.length();
		int patternLength = pattern.length();
		List<Integer> result = new ArrayList<Integer>();
		if(patternLength > textLength) return result;
		
		int leftIndex = 0;
		while(leftIndex + patternLength <= textLength){
			boolean match = true;
			
			for(int i = patternLength-1;  i>=0 ; i--){
				char curText = text.charAt(leftIndex + i);
				char curPattern = pattern.charAt(i);
				if(curText != curPattern){
					match = false;
					String sub = pattern.substring(0, i);
					int index = sub.lastIndexOf(curText);
					if(index == -1){
						leftIndex += i + 1;
					}else{
						leftIndex += sub.length() - index;
					}
					break;
				}
			}
			if(match){
				result.add(leftIndex);
				leftIndex++;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		findMatch("cbcaccbcaccbcaccbcac", "cbcac");
	}
}
